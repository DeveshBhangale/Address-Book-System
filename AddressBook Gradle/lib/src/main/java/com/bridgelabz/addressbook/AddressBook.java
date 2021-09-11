package com.bridgelabz.addressbook;
import java.io.File;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.*;


public class AddressBook {
	public String [][]arr = new String[10][8];
	public int cnt = 0;

	// Use Case - 1 &2
	public void createContact(String firstName,String lastName,String address,
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
	
	public void showContacts() {
		if(this.arr.length == 0)
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
	
	// Use Case - 3
	public String editContact(String Name, int b,String change ) {
		for(int i =0;i<arr.length;i++) {
			if(arr[i][0].equals(Name)) {
				arr[i][b] = change;
				return("Contact edited");
 			}
		}
		return "Contact Failed to edit";
	
	}
	
	// Use Case - 4
	public String deleteContact(String Name) {
		for(int i =0;i<arr.length;i++) {
			if(arr[i][0].equals(Name)) {
				arr[i][0] = null;
				arr[i][1] = null;
				arr[i][2] = null;
				arr[i][3] = null;
				arr[i][4] = null;
				arr[i][5] = null;
				arr[i][6] = null;
				arr[i][7] = null;
				return("Contact Deleted");
 			}
		}
		return "Contact Failed to Delete";
	}
	
	public boolean checkDuplicacy(String Name) {
		List<String> list = new ArrayList<String>();
		Arrays.asList(arr).stream().forEach(n -> { list.add(n[0]);});
	    if(list.stream().anyMatch(n -> n!=null && n.equals(Name))) return true;
	    return false;
	}
	
	public ArrayList<String> searchByCity(String Name) {
		ArrayList<String> cityNames = new ArrayList<String>();
		Arrays.asList(arr).stream().forEach(n1 -> {
			if(n1[3]!=null && n1[3].equals(Name)) cityNames.add(n1[0]);
		});
		return cityNames;
	}
	
	public ArrayList<String> searchByState(String Name) {
		ArrayList<String> stateNames = new ArrayList<String>();
		Arrays.asList(arr).stream().forEach(n1 -> {
			if(n1[4]!=null && n1[4].equals(Name)) stateNames.add(n1[0]);
		});
		return stateNames;
	}
	
	public void sortArray(int index){
		 Arrays.sort(arr, new Comparator<String[]>() {
	            @Override
	            public int compare(final String[] entry1, final String[] entry2) {
	            	if(entry1[index]!=null && entry2[index]!=null) {
		                final String time1 = entry1[index];
		                final String time2 = entry2[index];
		                return time1.compareTo(time2);
	                }
	            	return 0;
	            	}});
		 print();
		} 
	
	public void print() {
		for(String[] i: arr) {
			if(i[0]!=null)
				System.out.println("FirstName="+i[0]+" LastName="+i[1]+" Address="+i[2]
						+" City="+i[3]+" State="+i[4]+" ZipCode="+i[5]+" PhoneNo="+i[6]
						+" Email="+i[7]);
		}
	}

	
	
	public StringBuffer writeData(String addressBookName) {
		StringBuffer str = new StringBuffer("Address Book "+ addressBookName +"\n");
		for(int i=0;i<arr.length;i++) {
			if(arr[i][0] != null) {
				str.append("\nfirst Name "+ arr[i][0]);
				str.append("\nLast Name "+ arr[i][1]);
				str.append("\nAddress "+ arr[i][2]);
				str.append("\nCity "+ arr[i][3]);
				str.append("\nState "+ arr[i][4]);
				str.append("\nZip Code "+ arr[i][5]);
				str.append("\nPhone No "+ arr[i][6]);
				str.append("\nEmail "+ arr[i][7]);
			}
		}
		str.append("\n\n");
		return str;
	}

	public String[][] writeDataToCSV(String x) {
		String [][]arr1 = new String[10][9];
		for(int i=0;i<arr.length;i++) {
			if(arr[i][0] != null) {
				arr1[i][0] = x;
				arr1[i][1] = arr[i][0];
				arr1[i][2] = arr[i][1];
				arr1[i][3] = arr[i][2];
				arr1[i][4] = arr[i][3];
				arr1[i][5] = arr[i][4];
				arr1[i][6] = arr[i][5];
				arr1[i][7] = arr[i][6];
				arr1[i][8] = arr[i][7];
			}}
		return arr1;
	}

	
	}
	

	
	
