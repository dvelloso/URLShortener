package com.dvb.URLShortener.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class URL {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
		
	private String completeURL;
	
	private String shortURL;
	
	private String shortURLBegin;

	public URL() {
		super();
		// TODO Auto-generated constructor stub
	}

	public URL(String completeURL, String shortURL, String shortURLBegin) {
		super();
		this.completeURL = completeURL;
		this.shortURL = shortURL;
		this.shortURLBegin = shortURLBegin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompleteURL() {
		return completeURL;
	}

	public void setCompleteURL(String completeURL) {
		this.completeURL = completeURL;
	}

	public String getShortURL() {	 	
		return shortURL.replace('_', '/');
	}

	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}
	
	public String getShortURLBegin() {
		return shortURLBegin;
	}
	
	public void setShortURLBegin(String shortURLBegin) {
		this.shortURLBegin = shortURLBegin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		URL other = (URL) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "URL [id=" + id + ", completeURL=" + completeURL + ", shortURL=" + shortURL + ", shortURLBegin="
				+ shortURLBegin + "]";
	}



}
