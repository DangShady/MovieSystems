package com.moon.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")

public class Account{
	
	@Id
	String username;
	String password;
	String fullname;
	String phone;
	
	String email;
	
	String address;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/YYYY")
	Date dateregister;
	Boolean activated;
	Boolean admin;
	
	@OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
	List<Order> orders;
	
	@JsonIgnore
	@OneToMany(mappedBy = "authority")
	List<Authority> accountRoles;
}
