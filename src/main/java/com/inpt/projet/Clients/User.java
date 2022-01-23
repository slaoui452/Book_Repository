package com.inpt.projet.Clients;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String Nom;
	private String Prenom;
	private String UserName;
	private String PassWord;
	private String Email;
    private long address;
	@Override
	public String toString() {
		return id + ", " + Nom + ", " + Prenom + ", " + UserName + ", "
				+ PassWord + ", " + Email + ", " + books;
	}
	
	@OneToMany(targetEntity = Books.class, cascade = CascadeType.ALL)
	@JoinColumn(name="book_fk",referencedColumnName = "id")
	private List<Books> books;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public List<Books> getBooks() {
		return books;
	}
	public void setBooks(List<Books> books) {
		this.books = books;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(long id, String nom, String prenom, String userName, String passWord, String email, List<Books> books) {
		super();
		this.id = id;
		Nom = nom;
		Prenom = prenom;
		UserName = userName;
		PassWord = passWord;
		Email = email;
		this.books = books;
	}
	public long getAddress() {
		return address;
	}
	public void setAddress(long address) {
		this.address = address;
	}
	
}
