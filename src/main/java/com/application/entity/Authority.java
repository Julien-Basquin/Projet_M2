package com.application.entity;

import javax.persistence.*;

import com.application.entity.enumeration.AuthorityEnum;
@Entity
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private AuthorityEnum name;
    public Authority() {}
    public Authority(AuthorityEnum name) {
        this.name = name;
    }
    public Integer getId() {
		return id;
	}
    public AuthorityEnum getName() {
		return name;
	}
    public void setId(Integer id) {
		this.id = id;
	}
    public void setName(AuthorityEnum name) {
		this.name = name;
	}
}