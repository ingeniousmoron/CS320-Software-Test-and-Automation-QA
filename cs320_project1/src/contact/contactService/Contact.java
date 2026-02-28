package contact.contactService;

public class Contact {
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String address;
	
	public Contact(String id,String firstName, String lastName, String phoneNum, String address) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (phoneNum == null || phoneNum.length() != 10 || !isNumeric(phoneNum)) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.contactId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	
	public final String getContactId() {
		return contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public String getAddress() {
		return address;
	}
	
	public void setFirstName(String name) {
		if (name == null || name.length() > 10) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.firstName = name;
	}
	public void setLastName(String name) {
		if (name == null || name.length() > 10) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.lastName = name;
	}
	public void setPhoneNum(String number) {
		if (number == null || number.length() != 10 || !isNumeric(number)) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phoneNum = number;
	}
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
	}
	
	public static boolean isNumeric(String num)	{
		if (num == null) {
			return false;
		}
		try {
			Long.parseLong(num);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
