package contact.contactService;

import java.util.*;

public class ContactService {
	private final HashMap<String, Contact> contactBook = new HashMap<String, Contact>();
	private int currentIdNum = 0;
	
	public void addContact(String first, String last, String number, String address) {
		String id = Integer.toString(currentIdNum);
		Contact newContact = new Contact(id, first, last, number, address);
		contactBook.put(id, newContact);
		
		++currentIdNum;
	}
	
	public void deleteContact(String id) {
		if (contactBook.get(id) == null) {
			throw new IllegalArgumentException("Contact not in system");
		}
		contactBook.remove(id);
	}
	
	public void updateFirstName(String id, String name) {
		if (contactBook.get(id) == null) {
			throw new IllegalArgumentException("Contact not in system");
		}
		contactBook.get(id).setFirstName(name);
	}
	
	public void updateLastName(String id, String name) {
		if (contactBook.get(id) == null) {
			throw new IllegalArgumentException("Contact not in system");
		}
		contactBook.get(id).setLastName(name);
	}
	
	public void updatePhone(String id, String phoneNum) {
		if (contactBook.get(id) == null) {
			throw new IllegalArgumentException("Contact not in system");
		}
		contactBook.get(id).setPhoneNum(phoneNum);
	}
	
	public void updateAddress(String id, String address) {
		if (contactBook.get(id) == null) {
			throw new IllegalArgumentException("Contact not in system");
		}
		contactBook.get(id).setAddress(address);
	}
	
	public final HashMap<String, Contact> getContactBook() {
		return contactBook;
	}
}
