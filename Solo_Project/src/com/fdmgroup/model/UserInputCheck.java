package com.fdmgroup.model;

import java.util.regex.Pattern;

public class UserInputCheck {
	//check if the user name is Valid
		static public boolean checkUserId(String id) {
			if (id.length()<=4 || id.length()>20){
				return false;
			}
			if (!(id.matches("[A-Za-z0-9_]+"))) {
				return false;
			}
			return true;
		}
		static public boolean checkpw(String pw) {
			if (pw.length()<6 || pw.length()>40) {
				return false;
			}
			if (!(pw.matches("[A-Za-z0-9!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~]+"))) {
				return false;
			}
			return true;
		}
		
		
		static public boolean checkValidEmail(String email) {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                    "[a-zA-Z0-9_+&*-]+)*@" + 
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                    "A-Z]{2,7}$"; 
			if (email.length()==0 || email.length()>60) {
				return false;
			}
			Pattern pat = Pattern.compile(emailRegex);
			return pat.matcher(email).matches();
		}
}
