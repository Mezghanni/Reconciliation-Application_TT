package com.tt.domain;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="reconcil_tab")
public class CdrReconc  {
	
	
	@Column(name="ANBR" )
    private Long anbr;
    @Column(name="BNBR")
    private Long bnbr;
    @Column(name="DATE")
    private Date date;
    @Column(name="Heure")
    private Time time;
    @Column(name="dureTT")
    private Double dureTT;
    @Column(name="dureTiers")
    private Double dureTiers;
    
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
	public Double getDureTT() {
		return dureTT;
	}
	public void setDureTT(Double dureTT) {
		this.dureTT = dureTT;
	}
	public Double getDureTiers() {
		return dureTiers;
	}
	public void setDureTiers(Double dureTiers) {
		this.dureTiers = dureTiers;
	}
    
    
    
}
