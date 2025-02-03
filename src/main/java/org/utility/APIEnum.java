package org.utility;

public enum APIEnum {
	
	createData("api/users"),
	getData("/api/users?page=2"),
	updateData("api/users/2"),
	deleteData("api/users/");
	
	String resource;
	
	APIEnum(String resourc) {
		
		this.resource= resourc;
		
	}
	
	public String getResource() {
		
		return resource;
		
	}

}
