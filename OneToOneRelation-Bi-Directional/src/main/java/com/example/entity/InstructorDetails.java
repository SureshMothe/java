package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="instructor_details")
public class InstructorDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="youtube_channel")
	private String youtubeChannel;
	@Column(name="hobby")
	private String hobby;
	
	@OneToOne(mappedBy="instructorDetails",cascade= {
			CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Instructor instructor;
	
	public Instructor getInstructor() {
		return instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetails [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public InstructorDetails(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}
	
	public InstructorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYoutubeChannel() {
		return youtubeChannel;
	}
	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
