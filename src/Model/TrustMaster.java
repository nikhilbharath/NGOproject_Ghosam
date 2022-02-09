package Model;

import java.util.HashMap;

public class TrustMaster {
	
	
	private int TrustID;
	private String TrustName;
	private String Trust_PAN;
	private String Trust_AddressLine1;
	private String Trust_AddressLine2;
	private String Trust_City;
	private String Trust_Pin;
	private String Trust_Contact;
	private String Trust_Email;
	
	private HashMap<Integer,String> trustlist;
	
	public int getTrustID() {
		return TrustID;
	}
	public void setTrustID(int trustID) {
		TrustID = trustID;
	}
	public String getTrustName() {
		return TrustName;
	}
	public void setTrustName(String trustName) {
		TrustName = trustName;
	}
	public String getTrust_PAN() {
		return Trust_PAN;
	}
	public void setTrust_PAN(String trust_PAN) {
		Trust_PAN = trust_PAN;
	}
	public String getTrust_AddressLine1() {
		return Trust_AddressLine1;
	}
	public void setTrust_AddressLine1(String trust_AddressLine1) {
		Trust_AddressLine1 = trust_AddressLine1;
	}
	public String getTrust_AddressLine2() {
		return Trust_AddressLine2;
	}
	public void setTrust_AddressLine2(String trust_AddressLine2) {
		Trust_AddressLine2 = trust_AddressLine2;
	}
	public String getTrust_City() {
		return Trust_City;
	}
	public void setTrust_City(String trust_City) {
		Trust_City = trust_City;
	}
	public String getTrust_Pin() {
		return Trust_Pin;
	}
	public void setTrust_Pin(String trust_Pin) {
		Trust_Pin = trust_Pin;
	}
	public String getTrust_Contact() {
		return Trust_Contact;
	}
	public void setTrust_Contact(String trust_Contact) {
		Trust_Contact = trust_Contact;
	}
	public String getTrust_Email() {
		return Trust_Email;
	}
	public void setTrust_Email(String trust_Email) {
		Trust_Email = trust_Email;
	}
	public HashMap<Integer,String> getTrustlist() {
		return trustlist;
	}
	public void setTrustlist(HashMap<Integer,String> trustlist) {
		this.trustlist = trustlist;
	}

}
