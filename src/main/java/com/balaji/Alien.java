package com.balaji;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="alien")
@XmlAccessorType(XmlAccessType.NONE)
public class Alien {
	
	private int alienId;
	private String alienName;
	private int alienPoints;
	public int getAlienId() {
		return alienId;
	}
	public void setAlienId(int alienId) {
		this.alienId = alienId;
	}
	public String getAlienName() {
		return alienName;
	}
	public void setAlienName(String alienName) {
		this.alienName = alienName;
	}
	public int getAlienPoints() {
		return alienPoints;
	}
	public void setAlienPoints(int alienPoints) {
		this.alienPoints = alienPoints;
	}
	
	

}
