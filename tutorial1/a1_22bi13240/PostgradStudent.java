package a1_22bi13240;
import utils.*;

/**
 * @overview
 * A PostgradStudent represents a person who has finished their bachelor degree in a university.
 * @attributes
 * id			Integer		int
 * name			String		
 * phoneNumber	String	
 * address		String
 * gpa 			Float 		double
 * 
 * @objects
 * A PostgradStudent object: PostgradStudent(id,name,phoneNumber,address)
 * 
 * @abstract_properties
 * mutable(id) = false /\ optional(id) = false /\ min(id) = MIN_ID /\ max(id) = MAX_ID /\
 * P_Student.name = name /\
 * P_Student.phoneNumber = phoneNumber /\
 * P_Student.address = address /\
 * mutable(gpa) = true /\ optional(gpa) = false /\ min(gpa) = MIN_GPA /\ max(gpa) = MAX_GPA /\
 * 
 * @author lampham_1310
 */
public class PostgradStudent extends Student{

	private static final double MIN_GPA = 0.0;
	private static final double MAX_GPA = 4.0;
	private static final int MIN_ID = (int) (1e8 + 1);
    private static final int MAX_ID = (int) 1e9;
	private double gpa;

	public PostgradStudent(
			@AttrRef("id") int id, 
			@AttrRef("name") String name, 
			@AttrRef("phoneNumber") String phoneNumber, 
			@AttrRef("address") String address, 
			@AttrRef("gpa") double gpa)
			throws NotPossibleException {
		
		super(id, name, phoneNumber, address);
		this.gpa = gpa;
		
		if(!validateId(id)) {
			throw new NotPossibleException("Invalid ID");
		}
		if(!validateGpa(gpa)) {
			throw new NotPossibleException("Invalid GPA");
		}
		// TODO Auto-generated constructor stub
		
	}
	
	// getters
	/**
	 * @effect return this.gpa
	 */
	@DOpt(type=OptType.Observer) @AttrRef("gpa")
	public double getGpa() {
		return this.gpa;
	}
	
	// setters
	/**
	 * @modifies this.gpa
	 * 
	 * @effect 
	 * <pre>
	 * if gpa is valid
	 * 		this.gpa = gpa
	 * 		return true
	 * else
	 * 		return false
	 */
	@DOpt(type=OptType.Mutator) @AttrRef("gpa")
	public boolean setGpA(double gpa) {
		if(validateGpa(gpa)) {			
			this.gpa = gpa;
			return true;
		}
		else {
			return false;
		}
	}
	// helpers-validators
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
		if(id < MIN_ID || id > MAX_ID) {
			return false;
		}
		return true;
	}
	
	/**
	 * @effect
	 * <pre>
	 * if gpa is valid 
	 * 		return true
	 * else 
	 * 		return false
	 * </pre>
	 */
	public boolean validateGpa(double gpa) {
		if(gpa < MIN_GPA || gpa > MAX_GPA) {
			return false;
		}
		return true;
	}
	
	
	// repOK
	/**
	 * @effect
	 * <pre>
	 * if this is correct with abstract properties
	 * 		return true
	 * else 
	 * 		return false
	 * </pre>
	 */
	
	public boolean repOK() {
		if(super.repOK() && validateGpa(gpa)) {
			return true;
		}
		else {
			return false;
		}
	}
	// toString
	@Override
	public String toString() {
		String info = super.toString();
		return "Post Graduate Student\n" + info + "\nGPA: " + this.gpa;
	}
	
}
