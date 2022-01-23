package com.inpt.projet.Clients;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="Books")
public class Books implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String BookName;
	private String Author;
	private String Prix;
	private boolean Disponibility;
	
		public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
		public Books(long id, String bookName, String author, String prix, boolean disponibility) {
		super();
		this.id = id;
		BookName = bookName;
		Author = author;
		Prix = prix;
		Disponibility = disponibility;
	}
		public long getid() {
		return id;
	}
	public void setid(long id) {
		this.id =id;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPrix() {
		return Prix;
	}
	public void setPrix(String prix) {
		Prix = prix;
	}
	public boolean isDisponibility() {
		return Disponibility;
	}
	public void setDisponibility(boolean disponibility) {
		Disponibility = disponibility;
	}



	}


