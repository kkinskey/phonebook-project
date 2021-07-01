package phonebook;

public class Contacts {
	String firstName;
	String middleName;
	String lastName;
	String houseNumber;
	String streetName;
	String city;
	String state;
	String zipCode;
	String phoneNumber;
	
	public Contacts (String lastName, String firstName, String middleName , String houseNumber, String streetName, String city, String state,
	String zipCode, String phoneNumber) {
		setFirstName(phonebook.capitalizeFirst(firstName));
		setMiddleName(phonebook.capitalizeFirst(middleName));
		setLastName(phonebook.capitalizeFirst(lastName));
		setHouseNumber(houseNumber);
		setStreetName(phonebook.capitalizeFirst(streetName));
		setCity(phonebook.capitalizeFirst(city));
		setState(state.toUpperCase());
		setZipCode(zipCode);
		setPhoneNumber(phoneNumber);

		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		firstName = firstName.toLowerCase();
		
		this.firstName = phonebook.capitalizeFirst(firstName);;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		middleName = middleName.toLowerCase();
		
		this.middleName = phonebook.capitalizeFirst(middleName);
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		lastName = lastName.toLowerCase();
		
		this.lastName = phonebook.capitalizeFirst(lastName);
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return  lastName + ", " + firstName + ", " + middleName
				+ ", " + houseNumber + ", " + streetName + ", " + city + ", " + state
				+ ", " + zipCode + ", " + phoneNumber;
	}
	

}

