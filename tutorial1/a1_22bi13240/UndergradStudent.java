package a1_22bi13240;

import utils.*;

/**
 * @overview
 * UndergradStudent represents a person in a university's course
 * @attributes
 * id			Integer		int
 * name			String		
 * phoneNumber	String	
 * address		String
 * 
 * @objects
 * An UndergradStudent object UndergradStudent(id,name,phoneNumber, address)
 * @abstract_properties
 * mutable(id) = false /\ optional(id) = false /\ min(id) = MIN_ID /\ max(id) = MAX_ID /\
 * P_Student.name = name /\
 * P_Student.phoneNumber = phoneNumber /\
 * P_Student.address = address /\
 * 
 * @author lampham_1310
 * 
 */

public class UndergradStudent extends Student {
	
	private static final int MIN_ID = (int) 1e5;
	private static final int MAX_ID = (int) 1e8;
	
	public UndergradStudent(
			@AttrRef("id") int id, 
			@AttrRef("name") String name, 
			@AttrRef("phoneNumber") String phoneNumber, 
			@AttrRef("address") String address) 
			throws NotPossibleException {
		super(id, name, phoneNumber, address);
		if(!validateId(id)) {
			throw new NotPossibleException("Invalid Id!");
		}
		// TODO Auto-generated constructor stub
	}
	
	// helper - validators
	/**
	 * @effect 
	 * <pre>
	 * if id is valid
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 * 
	 */
	@Override
	@DomainConstraint(mutable = false, optional = false, min = MIN_ID, max = MAX_ID)
	
	public boolean validateId(int id) {
		if (id < MIN_ID || id > MAX_ID) {
			return false;
		}
		return true;
	}
	
	// toString
	@Override
	public String toString() {
		String info = super.toString();
		return "Undergraduate Student\n" + info; 
	}
	
	// equals
	
}
