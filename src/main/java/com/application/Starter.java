package com.application;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.application.configuration.WebSecurityConfig;
import com.application.dao.AuthorityRepository;
import com.application.dao.BdskUrlRepository;
import com.application.dao.UserRepository;
import com.application.entity.Authority;
import com.application.entity.Data;
import com.application.entity.User;
import com.application.entity.enumeration.AuthorityEnum;
import com.application.service.QueryMethodsService;
import com.application.service.QueryMethodsServiceImpl;
import com.application.util.Import;

@SpringBootApplication
public class Starter {


	private static final Logger log = LogManager.getLogger(WebSecurityConfig.class);

	public static void main(String[] args) throws IOException {
		ApplicationContext context =   SpringApplication.run(Starter.class, args);
		//insertUserAndGetUser(context);
//		dataTest(context);
//		Import.importMethode(context.getBean(QueryMethodsServiceImpl.class), "export1.txt");
//		Import.exportMethode(context.getBean(QueryMethodsServiceImpl.class), context.getBean(BdskUrlRepository.class), "FROM bdsk_url bu, data d, data_bdsk_url dbu", "where dbu.data_id = d.id and dbu.bdsk_url_id = bu.id and bu.id = 3");
	}


	private static void insertUserAndGetUser(ApplicationContext context) {
		UserRepository userRepository = context.getBean(UserRepository.class);
		AuthorityRepository authorityRepository = context.getBean(AuthorityRepository.class);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String pwd = passwordEncoder.encode("user");
		String pwd2 = passwordEncoder.encode("user2");

		Authority authority = new Authority(AuthorityEnum.USER);

		Set<Authority> authorities = new HashSet<>();
		authorities.add(authority);
		Set<Authority> authorities2 = new HashSet<>();
		authorities.add(authority);

		User user = new User("user",pwd,"User_Test",authorities);
		User user2 = new User("user2",pwd2,"User_Test2",authorities2);

		userRepository.save(user);
		log.info("ici");
		userRepository.save(user2);

	}
	
	private static void dataTest(ApplicationContext context) {
		QueryMethodsService queryMethodsService = context.getBean(QueryMethodsServiceImpl.class);
		
		Data data = new Data();
		data.setTypeBibliography("article");
		data.setNameBibliography("Test");
		data.setDocumentType("article");
		
		queryMethodsService.createData(data);
		
		System.out.println(queryMethodsService.executeQuery("SELECT * FROM DATA"));
		System.out.println(queryMethodsService.executeQuery("DROP TABLE DATA"));
	}

}
