package com.application;

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
import com.application.dao.UserRepository;
import com.application.entity.Authority;
import com.application.entity.User;
import com.application.entity.enumeration.AuthorityEnum;

@SpringBootApplication
public class Starter {


	private static final Logger log = LogManager.getLogger(WebSecurityConfig.class);

	public static void main(String[] args) {
		ApplicationContext context =   SpringApplication.run(Starter.class, args);
		//insertUserAndGetUser(context);
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

}
