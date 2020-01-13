package com.application.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.entity.Data;

@Repository
public interface DataRepository extends CrudRepository<Data, Long> {

}
