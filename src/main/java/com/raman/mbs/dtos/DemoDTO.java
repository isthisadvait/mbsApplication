package com.raman.mbs.dtos;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DemoDTO {
	
	@JsonProperty("demo_id")
	private int demoId;
	
	@JsonProperty("demo_name")
	private String demoName;
	
	@JsonProperty("demo_desc")
	private String demoDescription;
	
	public int getDemoId() {
		return demoId;
	}
	public void setDemoId(int demoId) {
		this.demoId = demoId;
	}
	public String getDemoName() {
		return demoName;
	}
	public void setDemoName(String demoName) {
		this.demoName = demoName;
	}
	public String getDemoDescription() {
		return demoDescription;
	}
	public void setDemoDescription(String demoDescription) {
		this.demoDescription = demoDescription;
	}
	@Override
	public int hashCode() {
		return Objects.hash(demoDescription, demoId, demoName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DemoDTO other = (DemoDTO) obj;
		return Objects.equals(demoDescription, other.demoDescription) && demoId == other.demoId
				&& Objects.equals(demoName, other.demoName);
	}
	@Override
	public String toString() {
		return "DemoDTO [demoId=" + demoId + ", demoName=" + demoName + ", demoDescription=" + demoDescription + "]";
	}
	
	
	
	

}
