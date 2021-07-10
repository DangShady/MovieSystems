package com.moon.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Roles")
public class Role implements Serializable{
	
	
	@Id
	private String id;
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "role")
	List<Authority> accountRoles;
}
