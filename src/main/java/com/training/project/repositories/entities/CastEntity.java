package com.training.project.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cast_details")
public class CastEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer castId;
	
	@Column(name="cast_name")
	private String castName;
	
	@Column(name="profession")
	private String profession;
	
	// getters and setters
	
	public Integer getCastId() {
		return castId;
	}
	public void setCastId(Integer castId) {
		this.castId = castId;
	}
	public String getCastName() {
		return castName;
	}
	public void setCastName(String castName) {
		this.castName = castName;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	//constructor
	
	public CastEntity(String castName, String profession) {
		super();
		this.castName = castName;
		this.profession = profession;
	}
	public CastEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
