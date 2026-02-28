package contact.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.contactService.ContactService;

class ContactServiceTest {
	
	@Test
	void testAddContact() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		test.addContact(first, last, phone, address);
		test.addContact(first, last, phone, address);
		
		assertTrue(test.getContactBook().size() == 2);
		assertEquals(first, test.getContactBook().get("0").getFirstName());
		assertEquals(last, test.getContactBook().get("0").getLastName());
		assertEquals(phone, test.getContactBook().get("0").getPhoneNum());
		assertEquals(address, test.getContactBook().get("0").getAddress());
		assertEquals(first, test.getContactBook().get("1").getFirstName());
		assertEquals(last, test.getContactBook().get("1").getLastName());
		assertEquals(phone, test.getContactBook().get("1").getPhoneNum());
		assertEquals(address, test.getContactBook().get("1").getAddress());
	}
	
	@Test
	void testDeleteContact() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		test.addContact(first, last, phone, address);		
		test.deleteContact("0");
		
		assertTrue(test.getContactBook().size() == 0);		
	}
	
	@Test
	void testUpdateContact() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		test.addContact(first, last, phone, address);		
		test.updateFirstName("0", "Rose");
		test.updateLastName("0", "Wolf");
		test.updatePhone("0", "8002459000");
		test.updateAddress("0", "234 Stardust ave");
		
		assertEquals("Rose", test.getContactBook().get("0").getFirstName());
		assertEquals("Wolf", test.getContactBook().get("0").getLastName());
		assertEquals("8002459000", test.getContactBook().get("0").getPhoneNum());
		assertEquals("234 Stardust ave", test.getContactBook().get("0").getAddress());
	}
	
	@Test
	void testAddLongFirst() {
		ContactService test = new ContactService();
		String first = "Genjiiiiiiiii";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.addContact(first, last, phone, address);
		});
	}
	
	@Test
	void testAddNullFirst() {
		ContactService test = new ContactService();
		String first = null;
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.addContact(first, last, phone, address);
		});
	}
	
	@Test
	void testAddLongLast() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemototototo";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.addContact(first, last, phone, address);
		});
	}
	
	@Test
	void testAddNullLast() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = null;
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.addContact(first, last, phone, address);
		});
	}
	
	@Test
	void testAddNotTenNum() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemoto";
		String phone = "123456789";
		String address = "123 Startdust ave";
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.addContact(first, last, phone, address);
		});
	}
	
	@Test
	void testAddNumNull() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemoto";
		String phone = null;
		String address = "123 Startdust ave";
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.addContact(first, last, phone, address);
		});
	}
	
	@Test
	void testAddNotNum() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemoto";
		String phone = "abcdefghij";
		String address = "123 Startdust ave";
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.addContact(first, last, phone, address);
		});
	}
	
	@Test
	void testAddLongAddress() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "1234654654654654465465465 Startdust ave";
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.addContact(first, last, phone, address);
		});
	}
	
	@Test
	void testAddNullAddress() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = null;
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.addContact(first, last, phone, address);
		});
	}
	
	@Test
	void testUpdateIdNotFound() {
		ContactService test = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.updateFirstName("0", "Miki");
		});
	}
	
	@Test
	void testUpdateFirstLong() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		test.addContact(first, last, phone, address);
		assertThrows(IllegalArgumentException.class, () -> {
			test.updateFirstName("0", "Genjiiiiiiiii");
		});
	}
	
	@Test
	void testUpdateFirstNull() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		test.addContact(first, last, phone, address);
		assertThrows(IllegalArgumentException.class, () -> {
			test.updateFirstName("0", null);
		});
	}
	
	@Test
	void testUpdateLastLong() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		test.addContact(first, last, phone, address);
		assertThrows(IllegalArgumentException.class, () -> {
			test.updateLastName("0", "Umemototototo");
		});
	}
	
	@Test
	void testUpdateLastNull() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		test.addContact(first, last, phone, address);
		assertThrows(IllegalArgumentException.class, () -> {
			test.updateLastName("0", null);
		});
	}
	
	@Test
	void testUpdatePhoneNotTen() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		test.addContact(first, last, phone, address);
		assertThrows(IllegalArgumentException.class, () -> {
			test.updatePhone("0", "123456789");
		});
	}
	
	@Test
	void testUpdatePhoneNull() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		test.addContact(first, last, phone, address);
		assertThrows(IllegalArgumentException.class, () -> {
			test.updatePhone("0", null);
		});
	}
	
	@Test
	void testUpdatePhoneNotNum() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		test.addContact(first, last, phone, address);
		assertThrows(IllegalArgumentException.class, () -> {
			test.updatePhone("0", "abcdefghij");
		});
	}
	
	@Test
	void testUpdateAddressLong() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		test.addContact(first, last, phone, address);
		assertThrows(IllegalArgumentException.class, () -> {
			test.updateAddress("0", "1234654654654654465465465 Startdust ave");
		});
	}
	
	@Test
	void testUpdateAddressNull() {
		ContactService test = new ContactService();
		String first = "Genji";
		String last = "Umemoto";
		String phone = "1234567890";
		String address = "123 Startdust ave";
		
		test.addContact(first, last, phone, address);
		assertThrows(IllegalArgumentException.class, () -> {
			test.updateAddress("0", null);
		});
	}
	
	@Test
	void testDeleteIdNotFound() {
		ContactService test = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.deleteContact("0");
		});
	}

}
