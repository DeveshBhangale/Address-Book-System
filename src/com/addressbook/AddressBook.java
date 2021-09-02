package com.addressbook;
import java.util.*;



public class AddressBook {
	public String [][]arr = new String[10][8];
	public int cnt = 0;
	
	
	public AddressBook() {
	}

	// Use Case - 1 &2
	public void createContact(String firstName,String lastName,String address,
			String city,String state,String zip,String phoneNo,String email) {
		
		this.arr[cnt][0] = firstName;
		this.arr[cnt][1] = lastName;
		this.arr[cnt][2] = address;
		this.arr[cnt][3] = city;
		this.arr[cnt][4] = state;
		this.arr[cnt][5] = zip;
		this.arr[cnt][6] = phoneNo;
		this.arr[cnt][7] = email;
		cnt++;
		System.out.println("Contact Successfully created");
		}
	
	public void showContacts() {
		if(this.arr.length == 0)
			System.out.println("No Contacts to display");
		else {	
			for(int i=0;i<arr.length;i++) {
				if((this.arr[i][0])!=(null)) {
				System.out.println((i+1)
						+ ".\nFirst Name: "+arr[i][0]
						+"\nLast Name: "+ arr[i][1]
						+"\nAddress:"+ arr[i][2]
						+"\nCity: "+ arr[i][3]
						+"\nState: "+arr[i][4] 
						+"\nZip Code: "+arr[i][5]
						+"\nPhone No: "+arr[i][6]
						+"\nEmail: "+arr[i][7]+"\n");
					
			}
			}
	}}
	
	// Use Case - 3
	public String editContact(String Name, int b,String change ) {
		for(int i =0;i<arr.length;i++) {
			if(this.arr[i][0].equals(Name)) {
				this.arr[i][b] = change;
				return("Contact edited");
 			}
		}
		return "Contact Failed to edit";
	
	}
	
	// Use Case - 4
	public String deleteContact(String Name) {
		for(int i =0;i<arr.length;i++) {
			if(this.arr[i][0].equals(Name)) {
				this.arr[i][0] = null;
				this.arr[i][1] = null;
				this.arr[i][2] = null;
				this.arr[i][3] = null;
				this.arr[i][4] = null;
				this.arr[i][5] = null;
				this.arr[i][6] = null;
				this.arr[i][7] = null;
				return("Contact Deleted");
 			}
		}
		return "Contact Failed to Delete";
	}
	

}