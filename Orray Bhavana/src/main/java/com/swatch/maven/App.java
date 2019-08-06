package com.swatch.maven;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

//import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class App 
{
	public static boolean login(String email,String pswd) throws Exception {
		JSONParser parser = new JSONParser();
		String filename=email+".json";
		Reader reader = new FileReader(filename);
		Object jsonObj = parser.parse(reader);
		JSONObject jsonObject = (JSONObject) jsonObj;
		String name = (String) jsonObject.get("email");
		String password = (String) jsonObject.get("pswd");
		if(name.equals(email) && password.equals(hash(pswd))) {
			return true;
		}
		else
			return false;	
	}
	@SuppressWarnings("unchecked")
	public static boolean reges(String name,String email,String phone,String pswd) {
		if(email.endsWith("@gmail.com") && phone.length()==10 && pswd.length()>=8) {
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("email",email);		
		obj.put("pswd",hash(pswd));
		obj.put("phone",phone);
		obj.put("Coupuns",0);
		String filename=email+".json";
		try {
			FileWriter file = new FileWriter(filename);
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
		}
		else {
			return false;
		}
	}
    public static void main( String[] args ) throws Exception
    {
    	Scanner b=new Scanner(System.in);
    	int i;
    	String ch;
    	do {
    	System.out.println("\n\n\n*-------------------*-------------------*");
        System.out.println("Welcome to our Application:");
        System.out.println("Select the option for the Further process:");
        System.out.println("1.Login\n2.Registration\nEnter the option:");
			i=b.nextInt();
			switch(i) {
			case 1:
				System.out.print("\n\n\nEnter Email:");
				String uname=b.next();
				System.out.print("Enter Password:");
				String password=b.next();
				if(login(uname,password))
					System.out.println("Registered");
				else
					System.out.println("Not Registered");
				
				break;
			case 2:
				System.out.print("\n\n\nEnter Name:");
				String name=b.next();
				System.out.print("Enter Email:");
				String email=b.next();
				System.out.print("Enter Password:");
				String pswd=b.next();
				System.out.print("Enter Phone Number:");
				String phone=b.next();
				if(reges(name,email,phone,pswd)==true) {
					System.out.println("Successfully Registered");
					if(login(email,pswd)==true) {
						wastage();
					}
				}
				else
					System.out.println("Not Done");
				break;
			}
			System.out.print("Enter yes to enter again:");
			ch=b.next();
    	}while(ch.equals("yes"));
    	System.out.println("*----------------*Thank You*-----------------*\n\n\n\n\n");
    b.close();
    }
    public static String hash(String pswd) {
    	String passwordToHash = pswd;
        String generatedPassword = null;
        try {      
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    public static void wastage() {
    	System.out.println("Entered into Wastage section");
    }
}
