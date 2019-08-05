package com.swatch.maven;

public class Login {
private String uname;
private String pswd;
Login(String uname,String pswd){
	this.uname=uname;
	this.pswd=pswd;
}
boolean check() {
	if(this.uname.equals("abhi") && this.pswd.equals("abhi")) {
		return true;
	}
	else {
		return false;
	}
}
}
