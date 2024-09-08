package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Expense {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String Date;
	private String time;
	private String Decription;
	private String Price;
	
	@ManyToOne
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDecription() {
		return Decription;
	}

	public void setDecription(String decription) {
		Decription = decription;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Expense(String title, String date, String time, String decription, String price, User user) {
		super();
		this.title = title;
		Date = date;
		this.time = time;
		Decription = decription;
		Price = price;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", title=" + title + ", Date=" + Date + ", time=" + time + ", Decription="
				+ Decription + ", Price=" + Price + ", user=" + user + "]";
	}
	
	
	
	

}
