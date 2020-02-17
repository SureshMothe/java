package com.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user_tab")
@Data
public class User {
	@Id
	private Integer id;
	private String name;
	@Column(name = "email")
	private String emailId;
	@Column(name="mobile")
	private long mobileNo;

}
