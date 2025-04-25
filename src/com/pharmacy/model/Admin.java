package com.pharmacy.model;

public class Admin {
private int adminId;
private String AdminName;
private String AdminPassword;
public Admin(int adminId, String adminName, String adminPassword) {
	super();
	this.adminId = adminId;
	AdminName = adminName;
	AdminPassword = adminPassword;
}
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public String getAdminName() {
	return AdminName;
}
public void setAdminName(String adminName) {
	AdminName = adminName;
}
public String getAdminPassword() {
	return AdminPassword;
}
public void setAdminPassword(String adminPassword) {
	AdminPassword = adminPassword;
}

}
