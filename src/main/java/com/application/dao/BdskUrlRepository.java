package com.application.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.entity.Bdsk_url;

@Repository
public interface BdskUrlRepository extends CrudRepository<Bdsk_url, Long> {

}
