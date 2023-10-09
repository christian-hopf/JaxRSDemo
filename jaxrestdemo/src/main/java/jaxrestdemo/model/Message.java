package jaxrestdemo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message{
	private int id;
	private String messageText;
	
	public Message(int id, String messageText) {
		super();
		this.id = id;
		this.messageText = messageText;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMessageText() {
		return this.messageText;
	}
	
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
}