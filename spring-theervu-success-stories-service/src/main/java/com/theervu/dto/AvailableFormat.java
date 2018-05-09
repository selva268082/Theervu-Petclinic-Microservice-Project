package com.theervu.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SUCCESS_STRY_DATA_FRMT")
public class AvailableFormat {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int formatID;
	private String formatType;
	private String status;
	private String link;
/*	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Person person;*/
	/**
	 * @return the link
	 */
	
	public String getLink() {
		return link;
	}
	/**
	 * @return the person
	 */
/*	public Person getPerson() {
		return person;
	}
	*//**
	 * @param person the person to set
	 *//*
	public void setPerson(Person person) {
		this.person = person;
	}*/
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return the formatID
	 */
	public int getFormatID() {
		return formatID;
	}
	/**
	 * @param formatID the formatID to set
	 */
	public void setFormatID(int formatID) {
		this.formatID = formatID;
	}
	/**
	 * @return the formatType
	 */
	public String getFormatType() {
		return formatType;
	}
	/**
	 * @param formatType the formatType to set
	 */
	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
    

}
