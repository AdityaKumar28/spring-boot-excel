package com.springbootexcel.poc.controller;

import com.springbootexcel.poc.model.NetflixTitlesEntity;
import com.springbootexcel.poc.service.NetflixTitlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("netflix")
public class NetflixTitlesController {

    @Autowired
    NetflixTitlesService netflixTitlesService;

    @GetMapping("findAll")
    public List<NetflixTitlesEntity> findAll() {
        return netflixTitlesService.findAll();
    }


}
