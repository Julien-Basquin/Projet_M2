package com.application.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.entity.Authority;

@Repository
public interface AuthorityRepository  extends CrudRepository<Authority, Integer> {

}
