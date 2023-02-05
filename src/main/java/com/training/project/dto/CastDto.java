package com.training.project.dto;

public class CastDto {
	
	private Integer castId;
	private String castName;
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
	
	public CastDto( String castName, String profession) {
		super();
		this.castName = castName;
		this.profession = profession;
	}
	public CastDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
