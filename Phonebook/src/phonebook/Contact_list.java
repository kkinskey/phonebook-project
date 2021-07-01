package phonebook;

import java.util.Arrays;

public class Contact_list {
	public static Object[] contactList = new Object[100];
	public static String fullNames[];

	public static void addContact(Contacts placeholder) {
//		System.out.println(placeholder.toString());
//		System.out.println("*********");
		for (int i = 0; i < contactList.length; i++) {
			if (contactList[i] == null) {
				contactList[i] = placeholder;
				break;
			}

		}
		String contactasString = placeholder.toString();
//		System.out.println(contactasString);

	}

	public static void sortContacts() {
		int counter = 0;
		for (int i = 0; i < contactList.length; i++) {
			if (contactList[i] != null) {
//				System.out.println(contactList[i].toString());
				counter++;
			}
		}
		fullNames = new String [counter];
//		System.out.println(fullNames.length);
		for (int i = 0; i < fullNames.length; i++) {
			if (fullNames[i] == null) {
				fullNames[i] = ((Contacts) contactList[i]).toString();
		
			}
		}
		if (fullNames.length > 0) {
				Arrays.sort(fullNames);
		
			for (int i = 0; i < fullNames.length; i++) {
				System.out.println(fullNames[i]);
			}
		} else {
				System.out.println();
				phonebook.mainMenu();

			} 
		}
		
	}