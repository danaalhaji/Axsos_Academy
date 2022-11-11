package com.axsos.languages.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Languages")
public class Language {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		long id;
		
		@NotNull
		@Size(min = 2, max = 20, message="Name must be atleast 2 characters and maximum 20")
		private String name;
		
		@NotNull
		@Size(min = 2, max = 20, message="Name must be atleast 2 characters and maximum 20")
		private String creator;
		
		@NotNull
		private double currentVersion;
		
		 @Column(updatable=false)
		 @DateTimeFormat(pattern="yyyy-MM-dd")
		 private Date createdAt;
		 @DateTimeFormat(pattern="yyyy-MM-dd")
		 private Date updatedAt;
	public Language() {
		
	}
	public Language(String name, String creator, double currentVersion) {
		this.name = name;
		this.creator = creator;
		this.currentVersion = currentVersion;
	}
	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public double getCurrentVersion() {
		return currentVersion;
	}
	public void setCurrentVersion(double currentVersion) {
		this.currentVersion = currentVersion;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
		
}
