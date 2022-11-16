package com.axsos.world.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="languages")
public class language {
    public language() {
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String countryCode;
    
    private String language;
    
    private enum isOfficial{
    	T,F
    };
    
    private Double percentage;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id")
    private countrey country;
    
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
}
