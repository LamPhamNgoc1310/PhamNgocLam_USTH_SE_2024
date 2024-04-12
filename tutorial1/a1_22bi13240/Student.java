package a1_22bi13240;

import utils.*;

/**
 * @overview
 * A student represents a person who is currently studying in a university.
 * @attributes
 * id			Integer		int
 * name			String		
 * phoneNumber	String	
 * address		String
 * 
 * @objects
 * A student object: Student(id,name,phoneNumber,address)
 * 
 * @abstract_properties
 * mutable(id) = false /\ optional(id) = false /\ min(id) = MIN_ID /\ max(id) = MAX_ID /\
 * mutable(name) = true /\ optional(name) = false /\ length(name) = NAME_LEN /\
 * mutable(phoneNumber) = true /\ optional(phoneNumber) = false /\ length(phoneNumber) = PHONE_LEN /\
 * mutable(address) = true /\ optional(address) = false /\ length(address) = ADDRESS_LEN /\
 * 
 * @author lampham_1310
 */
public class Student implements Comparable<Student>{
	private static final double MIN_ID = 1;

	private static final double MAX_ID = 1e9;

	private static final int NAME_LEN = 50;

	private static final int PHONE_LEN = 10;

	private static final int ADDRESS_LEN = 100;

	// attributes
	@DomainConstraint(mutable = false, optional = false, min = MIN_ID, max = MAX_ID)
	private int id;
	@DomainConstraint(mutable = true, optional = false, length = NAME_LEN)
	private String name;
	@DomainConstraint(mutable = true, optional = false, length = PHONE_LEN)
	private String phoneNumber;
	@DomainConstraint(mutable = true, optional = false, length = ADDRESS_LEN)
	private String address;
	// methods
	
	// constructor
	/**
	 * @modifies this.id, this.name, this.phoneNumber, this.address
	 * @effects if id, name, phoneNumber, address are valid
	 * 			initialize this as Student(id,name,phoneNumber,address)
	 * 			else 
	 * 			throw NotPossibleException
	 * 
	 */
	public Student(
			@AttrRef("id") int id, 
			@AttrRef("name") String name, 
			@AttrRef("phoneNumber") String phoneNumber, 
			@AttrRef("address") String address) 
			throws NotPossibleException{
		// TODO: Validates the inputs of users
		if(!validateId(id)) {
			throw new NotPossibleException("Invalid ID!");
		}
		if(!validateName(name)) {
			throw new NotPossibleException("Invalid Name!");
		}
		if(!validatePhoneNumber(phoneNumber)) {
			throw new NotPossibleException("Invalid Phone Number!");
		}
		if(!validateAddress(address)) {
			throw new NotPossibleException("Invalid Address!");
		}
		
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	// getters
	/**
	 * @effect return this.id
	 */
	@DOpt(type = OptType.Observer) @AttrRef("id")
	public int getId() {
		return this.id;
	}
	
	/**
	 * @effect return this.name
	 */
	@DOpt(type = OptType.Observer) @AttrRef("id")
	public String getName() {
		return this.name;
	}
	
	/**
	 * @effect return this.phoneNumber
	 */
	@DOpt(type = OptType.Observer) @AttrRef("phoneNumber")
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	/**
	 * @effect return this.address
	 */
	@DOpt(type = OptType.Observer) @AttrRef("address")
	public String getAddress() {
		return this.address;
	}
	
	
	// setters
	/**
	 * @modifies this.name
	 * @effects 
	 * <pre>
	 * 		if name is valid
	 * 			set this.name = name
	 * 			return true
	 * 		else
	 * 			return false
	 * </pre>
	 */
	@DOpt(type = OptType.Mutator) @AttrRef("name")
	public boolean setName(String name) {
		if(validateName(name)) {
			this.name = name;
			return true;
		}
		else {			
			return false;
		}
	}
	
	/**
	 * @modifies this.name
	 * @effects 
	 * <pre>
	 * 		if name is valid
	 * 			set this.name = name
	 * 			return true
	 * 		else
	 * 			return false
	 * </pre>
	 */
	@DOpt(type = OptType.Mutator) @AttrRef("phoneNumber")
	public boolean setPhoneNumber(String phoneNumber) {
		if(validatePhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber ;
			return true;
		}
		else {			
			return false;
		}
	}
	
	/**
	 * @modifies this.name
	 * @effects 
	 * <pre>
	 * 		if name is valid
	 * 			set this.name = name
	 * 			return true
	 * 		else
	 * 			return false
	 * </pre>
	 */
	@DOpt(type = OptType.Mutator) @AttrRef("address")
	public boolean setAddress(String address) {
		if(validateAddress(address)) {
			this.address = address;
			return true;
		}
		else {			
			return false;
		}
	}
	
	
	// helpers - validators
	/**
	 * @effect 
	 * <pre>
	 * if id is valid
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 */
	public boolean validateId(int id) {
	
		if (id < MIN_ID || id > MAX_ID) {
			return false;
		}
		return true;
	}
	
	/**
	 * @effect 
	 * <pre>
	 * if name is valid
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 */
	public boolean validateName(String name) {
	
		if (name.length() > NAME_LEN || name.length() == 0 || name == null) {
			return false;
		}
		return true;
	}

	/**
	 * @effect 
	 * <pre>
	 * if phoneNumber is valid
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 */
	public boolean validatePhoneNumber(String phoneNumber) {
	
		if (phoneNumber.length() > PHONE_LEN || phoneNumber.length() == 0 || phoneNumber == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * @effect 
	 * <pre>
	 * if address is valid
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 */
	public boolean validateAddress(String address) {
	
		if (address.length() > ADDRESS_LEN || address.length() == 0 || address == null) {
			return false;
		}
		return true;
	}
	// some other stuff
	
	// repOK
	/**
	 * @effect
	 * <pre>
	 * if this satisfies abstract properties
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 */
	public boolean repOK() {
		if(validateId(this.id) 
				&& validateName(this.name) 
				&& validatePhoneNumber(this.phoneNumber) 
				&& validateAddress(this.address)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// equals

	
	// toString
	@Override
	public String toString() {
		return "Student ID: " + this.id + "\nStudent Name: " + this.name + "\nStudent Phone Number: " + this.phoneNumber + "\nStudent Address: " + this.address ;
	}
	
	
	// compareTo
	@Override
	public int compareTo(Student student) {
		return this.name.compareTo(student.name);
	}
}



