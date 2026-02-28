package contact.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.contactService.Contact;


class ContactTest {

	@Test
	void testContactClass() {
		String id = "0";
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		Contact newContact = new Contact(id, first, last, phone, address);
		
		assertTrue(newContact.getContactId().equals(id));
		assertTrue(newContact.getFirstName().equals(first));
		assertTrue(newContact.getLastName().equals(last));
		assertTrue(newContact.getPhoneNum().equals(phone));
		assertTrue(newContact.getAddress().equals(address));
	}
	
	@Test
	void testContactIdTooLong() {
		String id = "000000000000000000";
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, first, last, phone, address);
		});
	}
	
	@Test
	void testContactIdNull() {
		String id = null;
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, first, last, phone, address);
		});

	}

	@Test
	void testContactFirstNameTooLong() {		
		String id = "0";
		String first = "Genjiiiiiiiii";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, first, last, phone, address);
		});
	}
	
	@Test
	void testContactFirstNameNull() {
		String id = "0";
		String first = null;
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, first, last, phone, address);
		});
	}
	
	@Test
	void testSetContactFirstTooLong() {
		String id = "0";
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		Contact newContact = new Contact(id, first, last, phone, address);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName("Genjiiiiiiiii");
		});
	}
	
	@Test
	void testSetContactFirstNull() {
		String id = "0";
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		Contact newContact = new Contact(id, first, last, phone, address);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName(null);
		});
	}

	
	@Test
	void testContactLastNameTooLong() {
		String id = "0";
		String first = "Genji";
		String last = "Umemototototo";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, first, last, phone, address);
		});
	}
	
	@Test
	void testContactLastNameNull() {
		String id = "0";
		String first = "Genji";
		String last = null;
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, first, last, phone, address);
		});
	}
	
	@Test
	void testSetContactLastTooLong() {
		String id = "0";
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		Contact newContact = new Contact(id, first, last, phone, address);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName("Umemototototo");
		});
	}
	
	@Test
	void testSetContactLastNull() {
		String id = "0";
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		Contact newContact = new Contact(id, first, last, phone, address);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName(null);
		});
	}
	
	@Test
	void testContactNumNotTen() {
		String id = "0";
		String first = "Genji";
		String last = "Umemoto";
		String phone = "123456789";
		String address = "123 Startdust ave";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, first, last, phone, address);
		});
	}
	
	@Test
	void testContactNumberNull() {		
		String id = "0";
		String first = "Genji";
		String last = "Umemoto";
		String phone = null;
		String address = "123 Startdust ave";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, first, last, phone, address);
		});
	}
	
	@Test
	void testContactPhoneNotNum() {
		String id = "0";
		String first = "Genji";
		String last = "Umemoto";
		String phone = "abcdefghij";
		String address = "123 Startdust ave";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, first, last, phone, address);
		});
	}

	@Test
	void testSetContactNumNotTen() {
		String id = "0";
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		Contact newContact = new Contact(id, first, last, phone, address);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhoneNum("123456789");
		});
	}
	
	@Test
	void testSetContactNumNull() {
		String id = "0";
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		Contact newContact = new Contact(id, first, last, phone, address);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhoneNum(null);
		});
	}
	
	@Test
	void testSetContactPhoneNotNum() {
		String id = "0";
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		Contact newContact = new Contact(id, first, last, phone, address);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhoneNum("abcdefghij");
		});
	}
	
	
	@Test
	void testContactAddressTooLong() {
		String id = "0";
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "1234654654654654465465465 Startdust ave";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, first, last, phone, address);
		});
	}
	
	
	@Test
	void testContactAddressNull() {
		String id = "0";
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = null;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, first, last, phone, address);
		});
	}
	
	@Test
	void testSetContactAddressTooLong() {
		String id = "0";
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		Contact newContact = new Contact(id, first, last, phone, address);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress("1234654654654654465465465 Startdust ave");
		});
	}
	
	@Test
	void testSetContactAddressNull() {
		String id = "0";
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		Contact newContact = new Contact(id, first, last, phone, address);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress(null);
		});
		
	}
}
