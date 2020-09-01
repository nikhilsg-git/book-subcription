package com.example.subscriptionservice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subscription implements Serializable{
	
	@Id
	@Column(name="SUBSCRIBER_NAME")
	private String subscriberName;
	
	@Column(name="BOOK_ID")
	private String bookId;
	
	@Column(name="DATE_SUBSCRIBED")
	private Date dateSubscribed;
	
	@Column(name="DATE_RETURNED")
	private Date dateReturned;
	
	
	
 
	public Subscription(String subscriberName,Date dateSubscribed, Date dateReturned, String bookId) {
		super();
		this.subscriberName = subscriberName;
		this.dateSubscribed = dateSubscribed;
		this.bookId = bookId;
		 
	}
	public String getSubscriberName() {
		return subscriberName;
	}
	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}
	public Date getDateSubscribed() {
		return dateSubscribed;
	}
	public void setDateSubscribed(Date dateSubscribed) {
		this.dateSubscribed = dateSubscribed;
	}
	public Date getDateReturned() {
		return dateReturned;
	}
	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public Subscription() {
		
	}

}
