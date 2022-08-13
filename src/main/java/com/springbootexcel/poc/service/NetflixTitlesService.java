package com.springbootexcel.poc.service;

import com.springbootexcel.poc.model.NetflixTitlesEntity;
import com.springbootexcel.poc.repository.NetflixTitlesRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class NetflixTitlesService {

    @Autowired
    NetflixTitlesRepository netflixTitlesRepository;

    public List<NetflixTitlesEntity> findAll(){
        List<NetflixTitlesEntity> netflixTitlesEntities = netflixTitlesRepository.findAll();
        saveToExcel(netflixTitlesEntities);
        return netflixTitlesEntities;
    }

    public void saveToExcel(List<NetflixTitlesEntity> entities) {

        try(Workbook workbook = new XSSFWorkbook()){
            Sheet sheet = workbook.createSheet("netflix_titles");

            //Create headers for Excel sheet.
            int rowNumber = 0;
            Row row = sheet.createRow(rowNumber++);
            List<String> fieldNames = getFieldNamesForClass(entities.get(0).getClass());

            for (int i = 0; i < fieldNames.size(); i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(fieldNames.get(i).toUpperCase());
            }

            //Fill out Excel sheet with remaining data.
            int entityIndex = 0;
            while(entityIndex<entities.size()) {
                NetflixTitlesEntity entity = entities.get(entityIndex++);
                row = sheet.createRow(rowNumber++);
                for (int i = 0; i < fieldNames.size(); i++) {
                    Cell cell = row.createCell(i);
                    Field field = entity.getClass().getDeclaredField(fieldNames.get(i));
                    field.setAccessible(true);
                    String value = String.valueOf(field.get(entity));
                    cell.setCellValue(value);
                }
            }

            File currDir = new File(".");
            String path = currDir.getAbsolutePath();
            String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";
            FileOutputStream outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
        }catch (Exception e){
            log.error("Exception Occurred : ",e);
        }
    }

 // or List<SomeClass> data; etc.


    private static List<String> getFieldNamesForClass(Class<?> clazz){
        List<String> fieldNames = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            fieldNames.add(field.getName());
        }
        return fieldNames;
    }
 }
