package com.inpt.projet.Clients;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address  implements Serializable {

		@Id
		private long id;
		public Address() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Address(long id, String address, String code_postal, String num_Tel) {
			super();
			this.id = id;
			Address = address;
			Code_postal = code_postal;
			Num_Tel = num_Tel;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getAdresse() {
			return Address;
		}
		public void setAdresse(String address) {
			Address = address;
		}
		public String getCode_postal() {
			return Code_postal;
		}
		public void setCode_postal(String code_postal) {
			Code_postal = code_postal;
		}
		public String getNum_Tel() {
			return Num_Tel;
		}
		public void setNum_Tel(String num_Tel) {
			Num_Tel = num_Tel;
		}
		private String Address;
		private String Code_postal;
		private String Num_Tel;


	}


