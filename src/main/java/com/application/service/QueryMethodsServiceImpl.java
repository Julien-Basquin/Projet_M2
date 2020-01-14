package com.application.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class QueryMethodsServiceImpl implements QueryMethodsService {

	@Override
	public boolean checkQueryValidity(final String query) {
		final String excludedKeywords = "add|alter|backup|create|delete|default|drop|exec|insert|into|set|truncate|update";
		final int flags = Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE;
		
		Pattern p = Pattern.compile(excludedKeywords, flags);
		Matcher m = p.matcher(query);
		
		return !m.find();
	}

}
