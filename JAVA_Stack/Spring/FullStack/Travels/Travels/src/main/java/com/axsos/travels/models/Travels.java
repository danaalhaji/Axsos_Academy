package com.axsos.travels.models;

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
@Table(name="travels")
public class Travels{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Size(min = 1, max = 200 , message="Expenses must be at least 1 character.")
	private String expenses;
	
	@NotNull
	@Size(min = 1, max = 200, message="Vendor must be at least 1 characters.")
	private String vendor;
	
	@NotNull
	@Size(min = 3, max = 200, message="Description must be at least 3 characters.")
	private String description;
	
	 @NotNull
	 private double amount;
	  
	 @Column(updatable=false)
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date createdAt;
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date updatedAt;

public Travels() {
}
public Travels(String expenses, String description, String vendor, double amount) {
    this.expenses = expenses;
    this.description = description;
    this.vendor = vendor;
    this.amount = amount;
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
public String getExpenses() {
	return expenses;
}
public void setExpenses(String expenses) {
	this.expenses = expenses;
}
public String getVendor() {
	return vendor;
}
public void setVendor(String vendor) {
	this.vendor = vendor;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
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



