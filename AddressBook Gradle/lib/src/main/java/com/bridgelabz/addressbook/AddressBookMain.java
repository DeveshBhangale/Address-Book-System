package com.bridgelabz.addressbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import com.google.gson.stream.JsonWriter;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;




public class AddressBookMain {
	public static Scanner sc = new Scanner(System.in);
	public static Dictionary<String,AddressBook> dict = new Hashtable<String,AddressBook>();
	public static Dictionary<String,ArrayList<ArrayList<String>>> personByCity = new Hashtable<String,ArrayList<ArrayList<String>>>();
	public static Dictionary<String,ArrayList<ArrayList<String>>> personByState = new Hashtable<String,ArrayList<ArrayList<String>>>();
	private static int count = 0;
	public static void selectAddressBook(AddressBook addressBook) throws IOException {
		
		int a;
		while(true) {
			do {
				System.out.println("1. Create or Add a Contact\n"
						+ "2. To show all Contacts\n"
						+ "3. Edit a Contact\n"
						+ "4. Delete a Contact\n"
						+ "5. search contact by city or state in multiple address book\n"
						+ "6. get count of persons by city or state in multiple address book\n"
						+ "7. sort the address book by name\n"
						+ "8. To Write Data into file\n"
						+ "9. To Read Data from the file\n"
						+ "10. To Write data into csv file\n"
						+ "11. To read data into csv file\n"
						+ "12. To Write data into Json file\n"
						+ "13. To read data into Json file\n");
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
						if(addressBook.checkDuplicacy(firstName)) {
							System.out.println("Duplicate Contact Found");
							selectAddressBook(addressBook);
						}
						System.out.println("LastName: ");
						lastName = sc.nextLine();
						System.out.println("Address (Type in one line): \n");
						address = sc.nextLine();
						System.out.println("City: ");
						city = sc.nextLine().toLowerCase();
						System.out.println("State: ");
						state = sc.nextLine().toLowerCase();
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
						String change = sc.nextLine().toLowerCase();
						System.out.println(addressBook.editContact(Name,b,change));
						break;
				
				case 4:System.out.println("Enter Name of the contact\n ");
					   Name = sc.next();
					   System.out.println(addressBook.deleteContact(Name));
					   break;
					   
				case 5: System.out.println("Enter 1 to search by city or 2 by state");
						int search = sc.nextInt();
						if(search == 1) {
							System.out.println("Enter the city name");
							String cityName = sc.next();
							searchByCity(cityName);
							System.out.println(personByCity.get(cityName));
							}
						else if(search == 2) { 
							System.out.println("Enter the state name");
							String stateName = sc.next();
							searchByState(stateName);
							System.out.println(personByState.get(stateName));
							}	
						break;						
						
				case 6: System.out.println("Enter 1 to get count of persons by city or 2 by state");
						search = sc.nextInt();
						if(search == 1) {
							System.out.println("Enter the city name");
							String cityName = sc.next();
							System.out.println(cityOrStatePersonsCount(cityName,1));
						}
						else {
							System.out.println("Enter the state name");
							String stateName = sc.next();
							
							System.out.println(cityOrStatePersonsCount(stateName,2));
						}
						break;
				
				case 7: System.out.println("1. To sort array by Name\n2. To sort array by City\n3. To sort array by State");
						int c = sc.nextInt();
						if(c == 1)addressBook.sortArray(0);
						else if(c == 2)addressBook.sortArray(3);
						else addressBook.sortArray(4);
						break;
				
				case 8: writeData();
						break;
				case 9: readData();
						break;
				case 10: writeDataToCSV();break;
				
				case 11: readDataFromCsvOrJson("data.csv");break;
				
				case 12: writeDatatoJson("data.json");break;
				
				case 13: readDataFromCsvOrJson("data.json");break;
				
				default:System.out.println("Current Address Book exited"); 
						return;
				
		}
		}
	}
	

	private static void writeDatatoJson(String fileName) {
		try(FileWriter fileWriter = new FileWriter(fileName);
                JsonWriter jsonWriter = new JsonWriter(fileWriter)
            ) {
			Enumeration<String> enu = dict.keys();
			 while (enu.hasMoreElements()) {
				 String x = enu.nextElement();
				 AddressBook tempAddressBook = dict.get(x);
				 String arr[][] = tempAddressBook.writeDataToCSV(x) ;
				 for(int i=0;i<arr.length;i++) {
					 if(arr[i][0]!=null) {
						jsonWriter.beginObject();
						jsonWriter.name("AddressBook").value(arr[i][0]);
						jsonWriter.name("firstName").value(arr[i][1]);
						jsonWriter.name("lastName").value(arr[i][2]);
						jsonWriter.name("Address").value(arr[i][3]);
						jsonWriter.name("City").value(arr[i][4]);
						jsonWriter.name("State").value(arr[i][5]);
						jsonWriter.name("ZipCode").value(arr[i][6]);
						jsonWriter.name("PhoneNo").value(arr[i][7]);
						jsonWriter.name("Email").value(arr[i][8]);
						jsonWriter.endObject();
					 }
				 }}
			 System.out.println("Json File Created Successfully");
			
		} catch (IOException e) {
                e.printStackTrace();
            }
	}

	private static void readDataFromCsvOrJson(String fileName) throws IOException {
		try {
			Files.lines(new File(fileName).toPath())
            .forEach(System.out::println);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void readData() throws IOException {
		System.out.println("reading file...");
		Path filePath = Paths.get("data.txt");
		File file = new File(filePath.toString());
		BufferedReader br = new BufferedReader(new FileReader(file.toString()));
		String st;
		int i = 0;
		  while ((st = br.readLine()) != null) {
			if(i==0) {
				i++;
				continue;
			}
		    System.out.println(st);
		  }
		  
	}
	
	private static void writeDataToCSV()throws IOException {
		try{
				List<String[]> data = new ArrayList<String[]>();
				System.out.println("writing data to CSV ...");
				data.add(new String[] {"Address Book","first Name","last Name","Address",
						"City","State","Zip Code","phoneNo","email"});
				Enumeration<String> enu = dict.keys();
				 while (enu.hasMoreElements()) {
					 String x = enu.nextElement();
					 AddressBook tempAddressBook = dict.get(x);
					 String arr[][] = tempAddressBook.writeDataToCSV(x) ;
					 for(int i=0;i<arr.length;i++) {
						 if(arr[i][0]!=null) data.add(arr[i]);
					 }}
				 File file = new File("data.csv");
				 FileWriter outputfile = new FileWriter(file);
			     CSVWriter writer = new CSVWriter(outputfile);
			     writer.writeAll(data);
			     writer.close();
			     System.out.println("CSV file created Successfully !!");
	     }catch (IOException e) {
	         e.printStackTrace();
	     }
	}

	private static void writeData() throws IOException{
		StringBuffer data = new StringBuffer("\n");
		Enumeration<String> enu = dict.keys();
		 while (enu.hasMoreElements()) {
			 String x = enu.nextElement();
			 AddressBook tempAddressBook = dict.get(x);
			 data.append(tempAddressBook.writeData(x).toString());
	        }
		 Path filePath = Paths.get("data.txt");
		 File file = new File(filePath.toString());
			if(Files.exists(filePath))
				file.delete();
		 ObjectOutputStream outputStream;
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(file));
			outputStream.writeObject(data.toString().getBytes());
			System.out.println("File Saved !!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}

	public static int cityOrStatePersonsCount(String Name,int choice) {
		ArrayList<ArrayList<String>> personCount;
		count = 0;
		if(choice == 1) {
			searchByCity(Name);
			personCount = personByCity.get(Name);
		}else{
			searchByState(Name);
			personCount = personByState.get(Name);
		}
		personCount.stream().forEach(y -> count++);
		return count;
		
	}

	private static void searchByCity(String cityName) {
		ArrayList<ArrayList<String>> cityNames = new ArrayList<ArrayList<String>>();
		Enumeration<String> enu = dict.keys();
        while (enu.hasMoreElements()) {
            AddressBook tempAddressBook = dict.get(enu.nextElement());
            cityNames.add(tempAddressBook.searchByCity(cityName));
        }
        personByCity.put(cityName, cityNames);
        
	}


	private static void searchByState(String stateName) {
		ArrayList<ArrayList<String>> stateNames = new ArrayList<ArrayList<String>>();
		Enumeration<String> enu = dict.keys();
        while (enu.hasMoreElements()) {
            AddressBook tempAddressBook = dict.get(enu.nextElement());
            stateNames.add(tempAddressBook.searchByCity(stateName));
        }
        personByState.put(stateName, stateNames);
        
	}


	public static void main(String[] args) throws IOException {
		AddressBook addressBook = new AddressBook();
		
		String aBName = "first";
		Scanner sc = new Scanner(System.in);
		dict.put(aBName, addressBook);
		
		
		System.out.println("Welcome to Address Book\n ");
		
		while(true) {
			System.out.println("Do you want to create new address book (Y / N)\n or enter x to exit");
			String input = sc.next();
			if(input.toUpperCase().equals("Y")) {
				System.out.println("Enter your new Address Book Name");
				input = sc.next();
				dict.put(input,  new AddressBook());
				System.out.println("New Address Book Created");
			}
			else if(input.toUpperCase().equals("N")) {
				Enumeration<String> enu = dict.keys();
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
