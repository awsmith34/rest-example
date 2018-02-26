package com.example.rest.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String make;
	private String model;
	private short year;
	private Color color;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + Long.hashCode(id);
		result = 31 * result + (make != null ? make.hashCode() : 0);
		result = 31 * result + (model != null ? model.hashCode() : 0);
		result = 31 * result + year;
		result = 31 * result + (color != null ? color.hashCode() : 0);
		result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
		result = 31 * result + (lastModifiedDate != null ? lastModifiedDate.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null || !(object instanceof Car)) {
			return false;
		}
		if (this == object) {
			return true;
		}
		
		Car other = (Car) object;
		
		return id == other.getId() &&
				Objects.equals(make, other.getMake()) &&
				Objects.equals(model, other.getModel()) &&
				year == other.getYear() &&
				Objects.equals(color, other.getColor()) &&
				Objects.equals(createdDate, other.getCreatedDate()) &&
				Objects.equals(lastModifiedDate, other.getLastModifiedDate());
		
	}
}
