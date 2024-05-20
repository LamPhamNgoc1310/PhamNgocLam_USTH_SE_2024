package a2_22bi13240.studentman;

import utils.*;
import a2_22bi13240.kengine.*;

/**
 * @overview A PostgradStudent represents a person who has finished their
 *           bachelor degree in a university.
 * @attributes id Integer int name String phoneNumber String address String gpa
 *             Float double
 * 
 * @objects A PostgradStudent object:
 *          PostgradStudent(id,name,phoneNumber,address)
 * 
 * @abstract_properties mutable(id) = false /\ optional(id) = false /\ min(id) =
 *                      MIN_ID /\ max(id) = MAX_ID /\ P_Student.name = name /\
 *                      P_Student.phoneNumber = phoneNumber /\ P_Student.address
 *                      = address /\ mutable(gpa) = true /\ optional(gpa) =
 *                      false /\ min(gpa) = MIN_GPA /\ max(gpa) = MAX_GPA /\
 * 
 * @author lampham_1310
 * https://github.com/LamPhamNgoc1310/PhamNgocLam_USTH_SE_2024
 */
public class PostgradStudent extends Student {

	private static final double MIN_GPA = 0.0;
	private static final double MAX_GPA = 4.0;
	private static final int MIN_ID = (int) (1e8 + 1);
	private static final int MAX_ID = (int) 1e9;
	@DomainConstraint(mutable = true, optional = false, min = MIN_GPA, max = MAX_GPA)
	private float gpa;

	/**
	 * 
	 * @modifies this.id, this.name, this.phoneNumber, this.address, this.gpa
	 * 
	 * @effects
	 * 
	 *          <pre>
	 * if id, name, phoneNumber, address are valid
	 * 		initialize this as (id, name, phoneNumber, address)
	 * @throws NotPossibleException
	 * if id, name, phoneNumber, address are not valid
	 *          </pre>
	 */
	public PostgradStudent(@AttrRef("id") int id, @AttrRef("name") String name,
			@AttrRef("phoneNumber") String phoneNumber, @AttrRef("address") String address, @AttrRef("gpa") float gpa)
			throws NotPossibleException {

		super(id, name, phoneNumber, address);

		if (!validateId(id)) {
			throw new NotPossibleException("Invalid ID");
		}

		else if (!validateGpa(gpa)) {
			throw new NotPossibleException("Invalid GPA");
		}

		this.gpa = gpa;


	}

	// getters
	/**
	 * @effect return <tt>this.gpa</tt>
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("gpa")
	public double getGpa() {
		return this.gpa;
	}

	// setters
	/**
	 * @modifies this.gpa
	 * 
	 * @effect
	 * 
	 *         <pre>
	 *         if gpa is valid this.gpa = gpa return true else return false
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("gpa")
	public boolean setGpA(float gpa) {
		if (validateGpa(gpa)) {
			this.gpa = gpa;
			return true;
		} else {
			return false;
		}
	}


	// helpers-validators
	/**
	 * @effect
	 * 
	 *         <pre>
	 * if id is valid
	 * 		return true
	 * else
	 * 		return false
	 *         </pre>
	 */
	public boolean validateId(int id) {
		if (id < MIN_ID || id > MAX_ID) {
			return false;
		}
		return true;
	}

	/**
	 * @effect
	 * 
	 *         <pre>
	 * if gpa is valid 
	 * 		return true
	 * else 
	 * 		return false
	 *         </pre>
	 */
	public boolean validateGpa(double gpa) {
		if (gpa < MIN_GPA || gpa > MAX_GPA) {
			return false;
		}
		return true;
	}

	// repOK
	/**
	 * @effects
	 * 
	 *          <pre>
	 * if this is correct with abstract properties
	 * 		return true
	 * else 
	 * 		return false
	 *          </pre>
	 */
	@Override
	public boolean repOK() {
		if (super.repOK() && validateGpa(gpa)) {
			return true;
		} else {
			return false;
		}
	}

	// toString
	@Override
	public String toString() {
		String info = super.toString();
		return String.format("Post Graduate Student:\n%s\nGPA: %.2f", info,this.gpa);
	}

	// toHtmlDoc
	/**
	 * @effect
	 * 
	 *         <pre>
	 * 		return an object in html format
	 *         </pre>
	 */
	//	@Override
	@DOpt(type = OptType.Default)
	public String toHtmlDoc() {
		return String.format(
				"<html>\n<head><title>Student: %d - %s</title></head>\n<body>\n%d %s %s %s %.2f\n</body></html>", 
				id, name.trim(), id, name.trim(), phoneNumber.trim(), address.trim(), gpa);
	}
}
