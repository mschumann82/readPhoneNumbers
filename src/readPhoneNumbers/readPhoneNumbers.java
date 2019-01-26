package readPhoneNumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readPhoneNumbers {

	public static void main(String[] args) {
		// This will read a text file and will retrieve phone number.
		// valid phone number is 10 digits long
		// area code can't start with 0 or 9
		// there can't be 911 in number
		String filename = "C:\\Users\\User\\Documents\\javaStuff\\phoneNumber.txt";
		File file = new File(filename);
		String phoneNum = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			phoneNum = br.readLine();
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: file not found");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: could not read file");
			e.printStackTrace();
		}
		
		try {
			if (phoneNum.length() != 10) {
				throw new TenDigitException(phoneNum);
			}
			if (phoneNum.substring(0,1) == "0" || phoneNum.substring(0,1) == "9") {
				
			}
		System.out.println(phoneNum);
		} catch (TenDigitException e) {
			System.out.println("Phone number is not 10 digits.");
			System.out.println(e.toString());
	}

}
}

class TenDigitException extends Exception {
	String num;
	TenDigitException(String num) {
		this.num = num;
	}
	
	public String toString() {
		return ("TenDigitException: " + num);
	}
}

class AreaCodeException extends Exception {
	
	
}

class EmergencyException extends Exception {
	
	
}
