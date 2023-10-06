package jaxrestdemo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hello {
	private String message;
	
	public Hello(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
