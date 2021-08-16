package com.addressbook;
import java.util.*;



public class AddressBook {
	public static String [][]arr = new String[10][8];
	public static int cnt = 0;
	// Use Case - 1 
	public static void createContact(String firstName,String lastName,String address,
			String city,String state,String zip,String phoneNo,String email) {
		
		arr[cnt][0] = firstName;
		arr[cnt][1] = lastName;
		arr[cnt][2] = address;
		arr[cnt][3] = city;
		arr[cnt][4] = state;
		arr[cnt][5] = zip;
		arr[cnt][6] = phoneNo;
		arr[cnt][7] = email;
		cnt++;
		System.out.println("Contact Successfully created");
		}
	
	public static void showContacts() {
		if(arr.length == 0)
			System.out.println("No Contacts to display");
		else {	
			for(int i=0;i<arr.length;i++) {
				if((arr[i][0])!=(null)) {
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
	
	
	public static String editContact(String Name, int b,String change ) {
		for(int i =0;i<arr.length;i++) {
			if(arr[i][0].equals(Name)) {
				arr[i][b] = change;
				return("Contact edited");
 			}
		}
		return "Contact Failed to edit";
	
	}
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book\n ");
		int a;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. Create or Add a Contact\n"
					+ "2. To show all Contacts\n"
					+ "3. Edit a Contact\n");
			do {
				while(!sc.hasNextInt()) {
					System.out.println("Entered Input is not a number");
					sc.next();
				}
				a = sc.nextInt();
				break;
			}while(true);
			switch(a) {
			
				case 1: 
						String firstName,lastName,address,city,state,zip,phoneNo,email;
						
						System.out.println("FirstName: ");
						String dummy = sc.nextLine(); // To avoid moving to the next line
						firstName = sc.nextLine();
						System.out.println("LastName: ");
						lastName = sc.nextLine();
						System.out.println("Address (Type in one line): \n");
						address = sc.nextLine();
						System.out.println("City: ");
						city = sc.nextLine();
						System.out.println("State: ");
						state = sc.nextLine();
						System.out.println("zip: ");
						zip = sc.nextLine();
						System.out.println("Phone No. ");
						phoneNo = sc.nextLine();
						System.out.println("Email: ");
						email = sc.nextLine();
						createContact(firstName,lastName,address,city,state,zip,phoneNo,email); 
						break;
				
				case 2:	showContacts();
						break;
				
				case 3: System.out.println("Enter Name of the contact\n ");
						String Name = sc.next();
						System.out.println("What you want to edit \n"
								+ "1. First Name\n"
								+ "2. Last Name\n"
								+ "3. Address\n"
								+ "4. City\n"
								+ "5. State\n"
								+ "6. Zip Code\n"
								+ "7. Phone No.\n"
								+ "8. Email\n ");
						int b = sc.nextInt() - 1;
						System.out.println("Enter the new one:");
						String dummy1 = sc.nextLine(); // To avoid moving to the next line
						String change = sc.nextLine();
						System.out.println(editContact(Name,b,change));
						break;
																	
				
				default:System.out.println("Program Exited"); 
						return;
					
			}
		}
	}

}
