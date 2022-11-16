package com.axsos.world.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="countries")
public class countrey {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String code;
    
    private String name;
    
    private enum continent{
        Asia, Africa, NorthAmerica, SouthAmerica, Antarctica, Europe, Australia
    };
    
    private String region;
    
    private double surfaceArea;
    
    private Integer indepYear;
    
    private Integer population;
    
    private double lifeExpectancy;
    
    private double gnp;
    
    private double gnpOld;
    
    private String localName;
    
    private String governmentForm;
    
    private String headOfState;
    
    private String capital;
    
    private String code2;
    
    @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<language> languages;
    
    @OneToMany(mappedBy="coun", fetch = FetchType.LAZY)
    private List<city> cities;
    
    
    public countrey() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public double getSurfaceArea() {
		return surfaceArea;
	}
	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	public Integer getIndepYear() {
		return indepYear;
	}
	public void setIndepYear(Integer indepYear) {
		this.indepYear = indepYear;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public double getLifeExpectancy() {
		return lifeExpectancy;
	}
	public void setLifeExpectancy(double lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}
	public double getGnp() {
		return gnp;
	}
	public void setGnp(double gnp) {
		this.gnp = gnp;
	}
	public double getGnpOld() {
		return gnpOld;
	}
	public void setGnpOld(double gnpOld) {
		this.gnpOld = gnpOld;
	}
	public String getLocalName() {
		return localName;
	}
	public void setLocalName(String localName) {
		this.localName = localName;
	}
	public String getGovernmentForm() {
		return governmentForm;
	}
	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}
	public String getHeadOfState() {
		return headOfState;
	}
	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
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
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
}
