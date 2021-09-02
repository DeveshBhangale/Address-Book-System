package com.addressbook;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class AddressBookMain {
	static Scanner sc = new Scanner(System.in);
	
	
	public static void selectAddressBook(AddressBook addressBook) {
		
		int a;
		while(true) {
			do {
				System.out.println("1. Create or Add a Contact\n"
						+ "2. To show all Contacts\n"
						+ "3. Edit a Contact\n"
						+ "4. Delete a Contact\n"
						+ "5. Create a new Address Book\n");
				while(!sc.hasNextInt()) {
					System.out.println("Entered Input is not a number");
					sc.next();
				}
				a = sc.nextInt();
				break;
			}while(true);
			switch(a) {		
				case 1: 
						String firstName,lastName,address,city,state,zip,phoneNo,email,dummy;						
						System.out.println("FirstName: ");
						// To avoid moving to the next line
						dummy = sc.nextLine();
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
						addressBook.createContact(firstName,lastName,address,city,state,zip,phoneNo,email); 
						break;
				
				case 2:	addressBook.showContacts();
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
						dummy = sc.nextLine();
						String change = sc.nextLine();
						System.out.println(addressBook.editContact(Name,b,change));
						break;
				
				case 4:System.out.println("Enter Name of the contact\n ");
					   Name = sc.next();
					   System.out.println(addressBook.deleteContact(Name));
					   break;	
					   
						
				
				default:System.out.println("Current Address Book exited"); 
						return;
				
		}
		}
	}


	public static void main(String[] args) {
		AddressBook addressBook = new AddressBook();
		Dictionary<String,AddressBook> dict = new Hashtable<String,AddressBook>();
		String aBName = "first";
		Scanner sc = new Scanner(System.in);
		dict.put(aBName, addressBook);
		
		
		System.out.println("Welcome to Address Book\n ");
		int a;
		
		while(true) {
			System.out.println("Do you want to create new address book (Y / N)\n or enter x to exit");
			String input = sc.next();
			if(input.toUpperCase().equals("Y")) {
				a = 5;
				System.out.println("Enter your new Address Book Name");
				input = sc.next();
				dict.put(input,  new AddressBook());
				System.out.println("New Address Book Created");
			}
			else if(input.toUpperCase().equals("N")) {
				Enumeration enu = dict.keys();
		        System.out.println("The available address books are:");
		        while (enu.hasMoreElements()) {
		            System.out.print(enu.nextElement() + " ");
		        }
				System.out.println("\nEnter the address book Name ");
				aBName = sc.next();
				
				selectAddressBook(dict.get(aBName));
			}
			else {
				System.out.println("Program Exited");
				sc.close();
				break;
			}
			
			
			
		}
	}

}
