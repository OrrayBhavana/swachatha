package com.swatch.maven;

public class Regs{
private String name,email,phone,pswd;
//private double coupon;
  Regs(String name,String email,String phone,String pswd){
	  this.name=name;
	  this.email=email;
	  this.setPhone(phone);
	  this.pswd=pswd;
  }
  boolean check() {
	  if(name.startsWith("$")||!email.endsWith("@gmail.com")) {       
		  return false;
	  }
	  else {  
		  
		  return true;
	  }
  }
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
}
