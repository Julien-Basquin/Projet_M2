package com.application.service;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dao.DataRepository;
import com.application.entity.Data;

@Service
public class QueryMethodsServiceImpl implements QueryMethodsService {

	@Autowired
	private DataRepository dataRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	public QueryMethodsServiceImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public boolean checkQueryValidity(final String query) {
		final String excludedKeywords = "add|alter|backup|create|delete|default|drop|exec|insert|into|set|truncate|update";
		final int flags = Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE;
		
		Pattern p = Pattern.compile(excludedKeywords, flags);
		Matcher m = p.matcher(query);
		
		return !m.find();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Data> executeQuery(String query) {
		if (checkQueryValidity(query)) {
			return (List<Data>) em.createNativeQuery(query, Data.class).getResultList();
		}
		
		return null;
	}

	@Override
	@Transactional
	public long createData(Data data) {
		if (data != null) {
			data.setDateAdded(new Date(System.currentTimeMillis()));
			
			return dataRepository.save(data).getId();
		}
		
		return -1;
	}

}
