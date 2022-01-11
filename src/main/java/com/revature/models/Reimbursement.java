package com.revature.models;

/**
 * This concrete Reimbursement class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>Description</li>
 *     <li>Creation Date</li>
 *     <li>Resolution Date</li>
 *     <li>Receipt Image</li>
 * </ul>
 *
 */
public class Reimbursement extends AbstractReimbursement {

    private int reimb_id;
    private int reimb_author;
    private int reimb_resolver;
    private int reimb_amount;
    private int reimb_status;
    private int reimb_type;
	private String reimb_description; 
	private byte reimb_receipt; 

	public Reimbursement() {
        super();
    }

    public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public int getReimb_author() {
		return reimb_author;
	}

	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}

	public int getReimb_resolver() {
		return reimb_resolver;
	}

	public void setReimb_resolver(int reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}

	public int getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(int reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public int getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(int reimb_status) {
		this.reimb_status = reimb_status;
	}

	public int getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(int reimb_type) {
		this.reimb_type = reimb_type;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public byte getReimb_receipt() {
		return reimb_receipt;
	}

	public void setReimb_receipt(byte reimb_receipt) {
		this.reimb_receipt = reimb_receipt;
	}

	//All args constructor
	public Reimbursement (int reimb_id, int reimb_author, int reimb_amount, int reimb_type, int reimb_status,int reimb_resolver, String reimb_description, byte reimb_receipt) {
        super();
        this.reimb_id = reimb_id;
        this.reimb_author = reimb_author;
        this.reimb_resolver = reimb_resolver;
        this.reimb_amount = reimb_amount;
        this.reimb_status = reimb_status;
        this.reimb_type = reimb_type;
        this.reimb_description = reimb_description;
        this.reimb_receipt = reimb_receipt;
        } 
	
	//Does not include reimb_id
	public Reimbursement (int reimb_author, int reimb_amount, int reimb_type, int reimb_status,int reimb_resolver, String reimb_description, byte reimb_receipt) {
        super();
       
        this.reimb_author = reimb_author;
        this.reimb_resolver = reimb_resolver;
        this.reimb_amount = reimb_amount;
        this.reimb_status = reimb_status;
        this.reimb_type = reimb_type;
        this.reimb_description = reimb_description;
        this.reimb_receipt = reimb_receipt;
        } 
    
    /**
     * This includes the minimum parameters needed for the {@link com.revature.models.AbstractReimbursement} class.
     * If other fields are needed, please create additional constructors.
     */
    public Reimbursement(int id, Status pending, User author, User resolver, double amount) {
        super(id, pending, author, resolver, amount);
    }
}
