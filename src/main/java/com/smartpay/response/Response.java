package com.smartpay.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response {
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "en-in", timezone = "IST")
    private LocalDateTime timestamp;
    private HttpStatus statusCode;
    private boolean processStatus;
    private String message;
    private Object datasource;
	public Response(LocalDateTime timestamp, HttpStatus statusCode, boolean processStatus, String message,
			Object datasource) {
		super();
		this.timestamp = timestamp;
		this.statusCode = statusCode;
		this.processStatus = processStatus;
		this.message = message;
		this.datasource = datasource;
	}
    
    

}
