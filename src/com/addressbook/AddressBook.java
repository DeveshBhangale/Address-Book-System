package com.addressbook;
import java.util.*;



public class AddressBook {
	public static ArrayList<ArrayList<String>> l1 = new ArrayList<ArrayList<String>>();
	
	// Use Case -1 
	public static String createContact(String firstName,String lastName,String address,
			String city,String state,String zip,String phoneNo,String email) {
		if(l1.add(new ArrayList<String>(Arrays.asList(firstName,lastName,address,city,state,zip,phoneNo,email)))) {
			return "Contact Created";
			}
		else
			return "Failed";
		}
	
	public static void showContacts() {
		if(l1.isEmpty())
			System.out.println("No Contacts to display");
		else {
			for(int i=0;i<l1.size();i++) {
				System.out.println("1. "
						+ "First Name: "+l1.get(i).get(0)
						+"\nLast Name: "+ l1.get(i).get(1)
						+"\nAddress: \n"+ l1.get(i).get(2)
						+"\nCity: "+l1.get(i).get(3)
						+"\nState: "+l1.get(i).get(4)
						+"\nZip Code: "+l1.get(i).get(5)
						+"\nPhone No: "+l1.get(i).get(6)
						+"Email: "+l1.get(i).get(7));
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book\n ");
		int a;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. Create a Contact\n"
					+ "2. To show all Contacts");
			do {
				while(!sc.hasNextInt()) {
					System.out.println("Entered Input is not a number");
					sc.next();
				}
				a = sc.nextInt();
				break;
			}while(true);
			switch(a) {
			
				case 1: System.out.println("FirstName: ");
						String firstName = sc.nextLine();
						System.out.println("LastName: ");
						String lastName = sc.nextLine();
						System.out.println("Address (Type in one line): \n");
						String address = sc.nextLine();
						System.out.println("City: ");
						String city = sc.nextLine();
						System.out.println("State: ");
						String state = sc.nextLine();
						System.out.println("zip: ");
						String zip = sc.nextLine();
						System.out.println("Phone No. ");
						String phoneNo = sc.nextLine();
						System.out.println("Email: ");
						String email = sc.nextLine();

						createContact(firstName,lastName,address,city,state,zip,phoneNo,email); 
						break;
				
				case 2: System.out.println(l1); 
					//showContacts();
				default: return;
					
			}
		}
	}

}
