package com.theervu.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

 

@Entity
@Table(name="SUCCESS_STORIES")
public class SuccessStory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STORY_ID")
	//@Size(min = 1)  
	@Min(1)
	private int storyId;
	
	@Column(name="TYPE_OF_DISEASE")
	@NotEmpty(message = "The above field must not be blank.")
	private String typeofdisease;
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="story",fetch=FetchType.EAGER)
	private List<Person> person; 


	/**
	 * @return the storyId
	 */
	public int getStoryId() {
		return storyId;
	}

	/**
	 * @param storyId the storyId to set
	 */
	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}

	/**
	 * @return the typeofdisease
	 */
	public String getTypeofdisease() {
		return typeofdisease;
	}

	/**
	 * @param typeofdisease the typeofdisease to set
	 */
	public void setTypeofdisease(String typeofdisease) {
		this.typeofdisease = typeofdisease;
	}

	/**
	 * @return the person
	 */
	public List<Person> getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(List<Person> person) {
		this.person = person;
	}

}
