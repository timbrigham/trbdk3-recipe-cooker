package com.trbdk3.RecipeCooker;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


@XmlRootElement
public class Recipe 
{
	String   lineA;
	String   lineB;
	String   lineC;
	String   output;
	int      outputCount; 
	String   id;
	
	@XmlElement
	public void setlineA(String lineA) {
		this.lineA = lineA;
	}
	public String getlineA() {
		return lineA;
	}

	@XmlElement
	public void setlineB(String lineB) {
		this.lineB = lineB;
	}
	public String getlineB() {
		return lineB;
	}
	
	@XmlElement
	public void setlineC(String lineC) {
		this.lineC = lineC;
	}
	public String getlineC() {
		return lineC;
	}
	
	@XmlElement
	public void setoutput(String output) {
		this.output = output;
	}
	public String getoutput() {
		return output;
	}
	

	@XmlElement
	public void setoutputCount(int outputCount) {
		this.outputCount = outputCount;
	}
	public int getoutputCount() {
		return outputCount;
	}
	
	
	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}
		
	@XmlList
    List<String>       inputItems;

	@XmlList
	List<String>       inputAssociation;
	
	public char assc( int id ) {
		return inputAssociation.get(id).charAt(0);
	}
}
