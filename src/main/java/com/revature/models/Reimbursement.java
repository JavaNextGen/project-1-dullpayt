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


public class Reimbursement  {

	

	private int reimb_id;
    private int reimb_author;
    private int reimb_resolver;
    private int reimb_amount;
    private int reimb_status_id;
    private int reimb_type_id;
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

	public int getReimb_status_id() {
		return reimb_status_id;
	}

	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}

	public int getReimb_type_id() {
		return reimb_type_id;
	}

	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
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
	
	
//	rs.getInt("reimb_id"),
//	rs.getInt("reimb_amount"),
//	rs.getString("reimb_description"),
//	rs.getByte("reimb_receipt"),
//	rs.getInt("reimb_author"),
//	rs.getInt("reimb_resolver"),
//	rs.getInt("reimb_status_id"),
//	rs.getInt("reimb_type_id")
//	);

	public Reimbursement (int reimb_id, int reimb_amount, String reimb_description, byte reimb_receipt, int reimb_author,int reimb_resolver, int reimb_status_id, int reimb_type_id) {
        super();
        this.reimb_id = reimb_id;
        this.reimb_author = reimb_author;
        this.reimb_resolver = reimb_resolver;
        this.reimb_amount = reimb_amount;
        this.reimb_status_id = reimb_status_id;
        this.reimb_type_id = reimb_type_id;
        this.reimb_description = reimb_description;
        this.reimb_receipt = reimb_receipt;
        } 
	
	//Does not include reimb_id
	public Reimbursement (int reimb_amount, String reimb_description, byte reimb_receipt, int reimb_author,int reimb_resolver, int reimb_status_id, int reimb_type_id) {
        super();
       
        this.reimb_author = reimb_author;
        this.reimb_resolver = reimb_resolver;
        this.reimb_amount = reimb_amount;
        this.reimb_status_id = reimb_status_id;
        this.reimb_type_id = reimb_type_id;
        this.reimb_description = reimb_description;
        this.reimb_receipt = reimb_receipt;
        } 
    
	public Reimbursement (int reimb_amount, String reimb_description, int reimb_author, int reimb_status_id, int reimb_type_id) {
        super();
       
        this.reimb_author = reimb_author;
        
        this.reimb_amount = reimb_amount;
        this.reimb_status_id = reimb_status_id;
        this.reimb_type_id = reimb_type_id;
        this.reimb_description = reimb_description;
        
        } 
	   public Reimbursement (int reimb_id,int reimb_status_id,int reimb_resolver) {
	        super();
	        this.reimb_id = reimb_id;
	        this.reimb_resolver = reimb_resolver;
	        this.reimb_status_id = reimb_status_id;
	        }
    /**
     * This includes the minimum parameters needed for the {@link com.revature.models.AbstractReimbursement} class.
     * If other fields are needed, please create additional constructors.
     */
    public Reimbursement(int id, Status pending, User author, User resolver, double amount) {
        super();
    }
}
