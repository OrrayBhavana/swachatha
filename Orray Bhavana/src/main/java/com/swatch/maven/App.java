package com.swatch.maven;
import java.util.Scanner;

public class App 
{
	
    public static void main( String[] args )
    {
    	Scanner b=new Scanner(System.in);
    	int i;
    	
    	System.out.println("\n\n\n*-------------------*-------------------*");
        System.out.println("Welcome to our Application:");
        System.out.println("Select the option for the Further process:");
        System.out.println("1.Login\n2.Registration\nEnter the option:");

			i=b.nextInt();
			switch(i) {
			case 1:
				System.out.println(i);
				String uname=b.next();
				String password=b.next();
				Login l=new Login(uname,password);
				if(l.check()==true)
					System.out.println("\nRegistered");
				else
					System.out.println("\nNot Registered");
				break;
			case 2:
				System.out.println(i);
				String name=b.next();
				String email=b.next();
				String pswd=b.next();
				String phone=b.next();
				Regs r=new Regs(name,email,phone,pswd);
				if(r.check()==true) {
					System.out.println("Registration Successfull");
				}
				else {
					System.out.println("Registration Unsuccessfull");
				}
				break;
			}
		
    b.close();
    }
}
