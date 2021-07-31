package com.moon.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
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
	@NotEmpty(message = "{account.username.notnull}")
	String username;
	@NotEmpty(message = "{account.password.notnull}")
	String password;
	@NotEmpty(message = "{account.fullname.notnull}")
	String fullname;
	@Pattern(regexp = "\\d{10}", message="{account.phone.pattern}")
	String phone;
	
	@NotEmpty(message = "{account.email.notnull}")
	@Email(message = "{account.email.pattern}")
	String email;
	
	@NotEmpty(message = "{account.address.notnull}")
	String address;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/YYYY")
	Date dateregister;
	Boolean activated;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@Fetch(value = FetchMode.SUBSELECT)
	List<Authority> accountRoles;

}
