package com.pharmacy.model;

public class Report {
private int Rid;
private String Rtype;
private String Rdate;
private String  Rdata;
public Report(int rid, String rtype, String rdate, String rdata) {
	super();
	Rid = rid;
	Rtype = rtype;
	Rdate = rdate;
	Rdata = rdata;
}
public int getRid() {
	return Rid;
}
public void setRid(int rid) {
	Rid = rid;
}
public String getRtype() {
	return Rtype;
}
public void setRtype(String rtype) {
	Rtype = rtype;
}
public String getRdate() {
	return Rdate;
}
public void setRdate(String rdate) {
	Rdate = rdate;
}
public String getRdata() {
	return Rdata;
}
public void setRdata(String rdata) {
	Rdata = rdata;
}

}
