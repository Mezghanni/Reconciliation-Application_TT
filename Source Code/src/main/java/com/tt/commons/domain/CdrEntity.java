package com.tt.commons.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CdrEntity extends BaseEntity implements Serializable  {

	private static final long serialVersionUID = -545921208073098505L;
	
	
    @Column(name="ANBR" ,nullable=true)
    private Long anbr;
    @Column(name="BNBR",nullable=true)
    private Long bnbr;
    @Column(name="DATE")
    private Date date;
    @Column(name="Heure")
    private Time time;
    @Column(name="DURE")
    private Double dure;
    
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Long getAnbr() {
		return anbr;
	}
	public void setAnbr(Long anbr) {
		this.anbr = anbr;
	}
	public Long getBnbr() {
		return bnbr;
	}
	public void setBnbr(Long bnbr) {
		this.bnbr = bnbr;
	}
	
	public Double getDure() {
		return dure;
	}
	public void setDure(Double dure) {
		this.dure = dure;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
	
    

}
