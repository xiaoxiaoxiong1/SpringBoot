package org.spring.entities;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
//@XmlRootElement(name = "person")  

public class MyInfo {
	private String username;
	private String password;
}

