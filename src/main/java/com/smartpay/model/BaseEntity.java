package com.smartpay.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss",locale = "en-in",timezone="IST")
	@CreationTimestamp
	@Column(name="createdDate",updatable = false,insertable = true)
	private Timestamp createdDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss",locale = "en-in",timezone="IST")
	@CreationTimestamp
	@Column(name="updatedDate",updatable = true,insertable = false)
	private Timestamp updatedDate;

}
