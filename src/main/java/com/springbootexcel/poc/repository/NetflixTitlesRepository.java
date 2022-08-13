package com.springbootexcel.poc.repository;

import com.springbootexcel.poc.model.NetflixTitlesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetflixTitlesRepository extends JpaRepository<NetflixTitlesEntity, String> {
}
