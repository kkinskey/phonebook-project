//Phone book 
//Entries 
//People object
//Full Name 
//First name 
//Option Initial for middle name 
//Last name 

//Phone Numbers 
//10 digits

//Addresses 
//House Number 
//Street Name
//City
//State 
//Zip code 
package phonebook;
//1.	Add new entries 

import java.util.InputMismatchException;

//2.	Search by first name *
//3.	Search by last name *
//4.	Search by full name *note name is not unique therefore the result should be an array of Person Objects.
//5.	Search by telephone number
//6. 	Search by city
//7.	Search by state
//8.	Delete a record for a given telephone number
//9.	Update a record for a given telephone number
//10.	Show all records in asc order *note you will need to research sorting on an array.
//11.	An option to exit the program 

import java.util.Scanner;

public class phonebook {
	static Scanner input = new Scanner(System.in);

	public static void mainMenu() {
		
		boolean running = true;
		while (running) {

			System.out.println("Press 1 to Add new entries \n" + "Press 2 To Search by first name\n"
					+ "Press 3 To Search by last name\n" + "Press 4 To Search by full name\n"
					+ "Press 5 To Search by telephone number\n" + "Press 6 To Search by city\n"
					+ "Press 7 To Search by state\n" + "Press 8 To Delete a contact for a given telephone number\n"
					+ "Press 9 To Update a contact for a given telephone number\n"
					+ "Press 10 To Show all contacts in asc order\n" + "Press 11 to Exit\n");

			int num = input.nextInt();

			switch (num) {

			case 1:
				addNewEntry();
				break;

			case 2:
				System.out.println("Enter First Name: ");
				String firstName = input.next();
				firstName = firstName.toLowerCase();
				firstName = capitalizeFirst(firstName);
				searchFirstName(firstName);
				
				break;

			case 3:
				System.out.println("Enter Last Name: ");
				String lastName = input.next();
				lastName = lastName.toLowerCase();
				lastName = capitalizeFirst(lastName);
				
				searchLastName(lastName);
				break;
				
			case 4:
				try {
				System.out.println("Please enter the contacts last name: ");
				String lastname2 = input.next();
				lastname2 = lastname2.toLowerCase();
				lastname2 = capitalizeFirst(lastname2);
				
				while (lastNameCheck(lastname2) == false) {
					System.out.println("Invalid last name, please enter only letters");
					lastName = input.next();
				}
				
				System.out.println("Please enter the contacts first name: ");
				String firstname2 = input.next();
				firstname2 = firstname2.toLowerCase();
				firstname2 = capitalizeFirst(firstname2);
				
				while (firstNameCheck(firstname2) == false) {
					System.out.println("Invalid first name, please enter only letters");
					firstname2 = input.next();
				}
				
				System.out.println("Please enter the contacts middle name: ");
				String middlename2 = input.next();
				middlename2 = middlename2.toLowerCase();
				middlename2 = capitalizeFirst(middlename2);
				
				while (middleNameCheck(middlename2) == false) {
					System.out.println("Invalid middle name, please enter only letters");
					middlename2 = input.next();
				}
				
				searchFullName(lastname2, firstname2, middlename2).toString();
				} catch (NullPointerException error) {
					
				}
				break;

			case 5:
				try {
				System.out.println("Enter Phone Number: ");
				String phoneNumber = input.next();
					
				System.out.println(searchPhoneNumber(phoneNumber).toString());
				}
				catch (NullPointerException error) {

				}
				break;

			case 6:
				System.out.println("Enter City Name: ");
				String city = input.next();
				city = city.toLowerCase();
				city = capitalizeFirst(city);

				searchCity(city);
				break;

			case 7:
				System.out.println("Enter State Name: ");
				String state = input.next();
				state = state.toUpperCase();

				searchState(state);
				break;

			case 8:
				System.out.println("Enter the Phone Number of the Contact you wish to delete: ");
				String phoneNumber = input.next();

				deleteContactForPhoneNumber(phoneNumber);
				break;

			case 9:
				try {
				System.out.println("Enter the Phone Number of the Contact you wish to update: ");
				String phoneNumber1 = input.next();
				updateEntry(phoneNumber1);
				}
				
				catch (NullPointerException error) {

				}
				break;

			case 10:
				showAllEntries();
				System.out.println();
				break;

			case 11:
				System.out.println("Exiting");
				running = false;
				break;

			default:
				System.out.println("Invalid Entry");
				mainMenu();
				break;

			}

		}

	}

	public static void addNewEntry() {
		System.out.println("Enter First Name: ");
		String firstName = input.next();
		
		while (firstNameCheck(firstName) == false) {
			System.out.println("Invalid first name");
			firstName = input.next();
		}
		
		System.out.println("Enter Middle Name: ");
		String middleName = input.next();
		System.out.println("Enter Last Name: ");
		String lastName = input.next();
		
		while (lastNameCheck(lastName) == false) {
			System.out.println("Invalid last name");
			lastName = input.next();
		}
		
		System.out.println("Enter House Number: ");
		String houseNumber = input.next();
		
		while (houseNumberCheck(houseNumber) == false) {
			System.out.println("Invalid house number");
			houseNumber = input.next();
		}
		
		System.out.println("Enter Street Name: ");
		input.nextLine();
		String street = input.nextLine();
		
		System.out.println("Enter City: ");
		String city = input.next();
		
		while (cityCheck(city) == false) {
			System.out.println("Invalid city");
			city = input.next();
		}
		
		System.out.println("Enter Enter State: ");
		String state = input.next();
		
		while (stateCheck(state) == false) {
			System.out.println("Invalid state, please enter the two letter state abbreviation");
			state = input.next();
		}
		
		System.out.println("Enter Zip Code: ");
		String zipCode = input.next();
		
		while (zipCodeCheck(zipCode) == false) {
			System.out.println("Invalid zip code, please enter a 5 digit number");
			zipCode = input.next();
		}
		
		System.out.println("Enter Phone Number: ");
		String phoneNumber = input.next();

		while (!phoneNumberCheck(phoneNumber)) {
			System.out.println("Invalid phone number, please enter a 10 digit number ");
			phoneNumber = input.next();
		}
		try {
		for (int i = 0; i < Contact_list.contactList.length; i++) {
			if (!(Contact_list.contactList[i] == null)) {
				while (phoneNumberCheck2(phoneNumber) == true) {
					System.out.println(
							"The Phone number has already been entered in the phonebook\nPlease enter a different number: ");
					phoneNumber = input.next();
				}
			}
		}
		} catch (NullPointerException error) {
			
		}
		
//		char[] phoneNumberArray = new char[phoneNumber.length()];
//
//	    for (int i = 0; i < phoneNumber.length(); i++) {
//	    	phoneNumberArray[i] = phoneNumber.charAt(i);
//	    }
//	    
//	    for(int i = 0; i< phoneNumberArray.length; i++) {
//	    	if(phoneNumberArray[0] >= '1' && phoneNumberArray[0] <= '9') {
//	    		phoneNumberArray[0] = phoneNumberArray[1];
//	    		phoneNumberArray[0] = '(';
//	    	} else if(phoneNumberArray[4] >= '1' && phoneNumberArray[0] <= '9') && phoneNumberArray[5] >= '1' && phoneNumberArray[0] <= '9') {
//	    		phoneNumberArray[4] = phoneNumberArray[5];
//	    		
//	    		phoneNumberArray[4] = ')';
//	    	} else if(phoneNumberArray[5] >= '1' && phoneNumberArray[0] <= '9') {
//	    		phoneNumberArray[5] = '-';
//	    	} else if(phoneNumberArray[9] >= '1' && phoneNumberArray[0] <= '9') {
//	    		phoneNumberArray[9] = '-';
//	    	}
//	    }
//	    	
//	    	
////	    	for(int j)
////	    	if() {
//	    		
////	    }
//
//	    for (char c : phoneNumberArray) {
//	        System.out.println(c);
//	    }
//		
//		
//		
//		phoneNumber = phonenumber 

		Contacts entry = new Contacts(capitalizeFirst(lastName), capitalizeFirst(firstName), capitalizeFirst(middleName), houseNumber, capitalizeFirst(street), capitalizeFirst(city), state.toUpperCase(),
				zipCode, phoneNumber);

		Contact_list.addContact(entry);
		
		
	}
	
	public static String capitalizeFirst(String string) {
		String first = string.substring(0,1).toUpperCase();
		String last = string.substring(1, string.length());
		return first+last;
	}

	public static void searchFirstName(String placeholderFirstName) {
		int counter = 0;
		for (int i = 0; i < Contact_list.contactList.length; i++) {
			if (((Contacts) Contact_list.contactList[i]) != null
					&& ((Contacts) Contact_list.contactList[i]).getFirstName().equals(placeholderFirstName) && placeholderFirstName.matches("^[a-zA-Z]*$")) {
				System.out.println(Contact_list.contactList[i].toString());
				counter++;
			}
		}
		if (counter == 0) {
			System.out.println("The first name you entered does not exist in the phonebook\n");
		}

	}

	public static void searchLastName(String placeholderLastName) {
		int counter = 0;
		for (int i = 0; i < Contact_list.contactList.length; i++) {
			if (((Contacts) Contact_list.contactList[i]) != null
					&& ((Contacts) Contact_list.contactList[i]).getLastName().equals(placeholderLastName) && placeholderLastName.matches("^[a-zA-Z]*$")) {
				System.out.println(Contact_list.contactList[i].toString());
				counter++;
			}
		}
		if (counter == 0) {
			System.out.println("The last name you entered does not exist in the phonebook\n");
		}
	}
	
	public static Contacts searchFullName(String placeholderLastName, String placeholderFirstName, String placeholderMiddleName) {
		Contacts result = null;
		for (int i = 0; i < Contact_list.contactList.length; i++) {
			if (((Contacts) Contact_list.contactList[i]).getLastName().equals(placeholderLastName) && placeholderLastName.matches("^[a-zA-Z]*$") 
					&& ((Contacts) Contact_list.contactList[i]).getFirstName().equals(placeholderFirstName) && placeholderFirstName.matches("^[a-zA-Z]*$") 
						&& ((Contacts) Contact_list.contactList[i]).getMiddleName().equals(placeholderMiddleName) && placeholderMiddleName.matches("^[a-zA-Z]*$")) {
				System.out.println(Contact_list.contactList[i].toString());
				result = (Contacts) Contact_list.contactList[i];
			} else {
				System.out.println("The contact's full name you entered does not exist in the phonebook\n");
				result = null;
			}
			
			break;
		}
		
		return result;
	}

	public static Contacts searchPhoneNumber(String phoneNumberPlaceholder) {
		
		while (!phoneNumberCheck(phoneNumberPlaceholder)) {
			System.out.println("Invalid phone number, please enter a 10 digit number ");
			phoneNumberPlaceholder = input.next();
		}
		int counter = 0;
		int tempCounter;
		Contacts result = null;
		for (int i = 0; i < Contact_list.contactList.length; i++) {
			if (((Contacts) Contact_list.contactList[i]) != null
					&& ((Contacts) Contact_list.contactList[i]).getPhoneNumber().equals(phoneNumberPlaceholder)) {
				result = (Contacts) Contact_list.contactList[i];
				tempCounter = i;
				counter++;
			} else if (result != null) {
				break;
			} else {
				System.out.println("No contacts exist with the phone number you have entered");
				result = null;
				
			}
		}
		return result;

	}
	
	public static boolean firstNameCheck(String firstNamePlaceholder) {
		if (firstNamePlaceholder.matches("^[a-zA-Z]*$")) {
			return true;
		}
		return false;
	}
	
	public static boolean middleNameCheck(String middleNamePlaceholder) {
		if (middleNamePlaceholder.matches("^[a-zA-Z]*$")) {
			return true;
		}
		return false;
	}
	
	public static boolean lastNameCheck(String lastNamePlaceholder) {
		if (lastNamePlaceholder.matches("^[a-zA-Z]*$")) {
			return true;
		}
		return false;
	}
	
	public static boolean houseNumberCheck(String houseNumberPlaceholder) {
		if (houseNumberPlaceholder.length() == 3 && houseNumberPlaceholder.matches("[0-9]+")) {
			return true;
		}
		return false;
	}

	public static boolean phoneNumberCheck(String phoneNumberPlaceholder) {
		if (phoneNumberPlaceholder.length() == 10 && phoneNumberPlaceholder.matches("(0|[1-9]\\d*)")) {
			return true;
		}
		return false;
	}
	
	public static boolean phoneNumberCheck2(String phoneNumberPlaceholder) {
		for (int i = 0; i < Contact_list.contactList.length; i++) {
			if (((Contacts) Contact_list.contactList[i]).getPhoneNumber().equals(phoneNumberPlaceholder)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean stateCheck(String statePlaceholder) {
		if (statePlaceholder.length() == 2 && statePlaceholder.matches("^[a-zA-Z]{2}$")) {
			return true;
		}
		return false;
	}
	
	public static boolean cityCheck(String cityPlaceholder) {
		if (cityPlaceholder.matches("^[a-zA-Z]*$")) {
			return true;
		}
		return false;
	}
	
	public static boolean zipCodeCheck(String zipCodePlaceholder) {
		if (zipCodePlaceholder.length() == 5 && zipCodePlaceholder.matches("(0|[1-9]\\d*)")) {
			return true;
		}
		return false;
	}

	public static void searchCity(String cityPlaceholder) {
		int counter = 0;
		for (int i = 0; i < Contact_list.contactList.length; i++) {
			if (((Contacts) Contact_list.contactList[i]) != null
					&& ((Contacts) Contact_list.contactList[i]).getCity().equals(cityPlaceholder) && cityPlaceholder.matches("^[a-zA-Z]*$")) {
				System.out.println(Contact_list.contactList[i].toString());
				counter++;
			}
		}
		if (counter == 0) {
			System.out.println("The city you entered does not exist in the phonebook\n");
		}
	}

	public static void searchState(String statePlaceholder) {
		int counter = 0;
		for (int i = 0; i < Contact_list.contactList.length; i++) {
			if (((Contacts) Contact_list.contactList[i]) != null
					&& ((Contacts) Contact_list.contactList[i]).getState().equals(statePlaceholder) && statePlaceholder.matches("^[a-zA-Z]{2}$")) {
				System.out.println(Contact_list.contactList[i].toString());
				counter++;
			}
		}
		if (counter == 0) {
			System.out.println("The state you entered does not exist in the phonebook\nPlease enter a two letter state abbreviation\n");
		}
	}

	public static void deleteContactForPhoneNumber(String phoneNumberPlaceholder) {
		Contacts number = null;

		if (!(searchPhoneNumber(phoneNumberPlaceholder) == number)) {

			for (int i = 0; i < Contact_list.contactList.length; i++) {
				if (((Contacts) Contact_list.contactList[i]).getPhoneNumber().equals(phoneNumberPlaceholder)) {
					
					Contact_list.contactList[i] = null;
				}
				break;
			}
			System.out.println("The contact has been deleted");
			System.out.println();
		} else {
			System.out.println("No contacts exist with the phone number you have entered");
		}
	}

	public static void updateEntry(String phoneNumberPlaceholder) {
		
		
		Contacts number = searchPhoneNumber(phoneNumberPlaceholder);

				System.out.println("Is this the contact you wish to update? " + "(" + number.toString() + ")");
				System.out.println();
				System.out.println("Press 1 if this is the contact you wish to update\n"
								+  "Press 2 to return to the main menu");
				int num = input.nextInt();
				if (num == 1) {
				System.out.println("Press 1 to update the contacts last name\n"
						+ 		   "Press 2 to update the contacts middle name\n"
						+ 		   "Press 3 to update the contacts first name\n"
						+ 		   "Press 4 to update the contacts house number\n"
						+		   "Press 5 to update the contacts street name\n"
						+ 		   "Press 6 to update the contacts city\n"
						+ 		   "Press 7 to update the contacts state\n"
						+ 		   "Press 8 to update the contacts zipcode\n"
						+		   "Press 9 to update the contacts phone number\n");
				int num2 = input.nextInt();
					switch(num2) {
					
					case 1: System.out.println("Enter the new last name: ");
							number.setLastName(input.next());
//							String newLastName = input.next();
//								
//							while (firstNameCheck(newLastName) == false) {
//								System.out.println("Invalid last name");
//								newLastName = input.next();
//							}
//							newLastName = number.setLastName(input.next());
						break;
						
					case 2: System.out.println("Enter the new middle name: ");
							number.setMiddleName(input.next());
						break;
					case 3: System.out.println("Enter the new first name: ");
							number.setFirstName(input.next());
						break;
					case 4: System.out.println("Enter the new house number: ");
							number.setHouseNumber(input.next());
						break;
					case 5: System.out.println("Enter the new street name: ");
							number.setStreetName(input.next());
						break;
					case 6: System.out.println("Enter the new city: ");
							number.setCity(input.next());
						break;
					case 7: System.out.println("Enter the new state: ");
							number.setState(input.next());
						break;
					case 8: System.out.println("Enter the new zipcode: ");
							number.setZipCode(input.next());
						break;
					case 9: System.out.println("Enter the new phone number: ");
							number.setPhoneNumber(input.next());
						break;
				
					}
				} else {
					mainMenu();
				}
				System.out.println(number);
				System.out.println();
				

		}
	
	public static void showAllEntries() {
		Contact_list.sortContacts();
	}

	public static void main(String[] args) {
		
		System.out.println();
		mainMenu();
		

	}
}

