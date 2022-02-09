package Model;

import java.util.Date;

public class ReceiptForm {
	
	private int Sno;
	private String receiptno;
	private String PoojaBookingDate;
	private String Donar_Name;
	private String Donar_AddressLine1;
	private String Donar_AddressLine2;
	private String Donar_City;
	private int Donar_Pin;
	private long Contact_No;
	private String Amountwords;
	
	private long Rid;
	
	private PoojaSchemeMaster Scheme;
	
	private String Donar_PAN;
	
	private String Gothram;
	
	private RaasiMaster Raasi;
	
	private NatchatramMaster Natchatram;
	
	private PaymentModeMaster payMode;
	
	private String PaymentDescription;
	private String PaymentDate;
	private int Amount;
	
	private LoginBean billedBy;
	
	private Date Billed_Date;
	
	private TrustMaster trustID;
	
	public int getSno() {
		return Sno;
	}
	public void setSno(int sno) {
		Sno = sno;
	}
	public String getPoojaBookingDate() {
		return PoojaBookingDate;
	}
	public void setPoojaBookingDate(String poojaBookingDate) {
		PoojaBookingDate = poojaBookingDate;
	}
	public String getDonar_Name() {
		return Donar_Name;
	}
	public void setDonar_Name(String donar_Name) {
		Donar_Name = donar_Name;
	}
	public String getDonar_AddressLine1() {
		return Donar_AddressLine1;
	}
	public void setDonar_AddressLine1(String donar_AddressLine1) {
		Donar_AddressLine1 = donar_AddressLine1;
	}
	public String getDonar_AddressLine2() {
		return Donar_AddressLine2;
	}
	public void setDonar_AddressLine2(String donar_AddressLine2) {
		Donar_AddressLine2 = donar_AddressLine2;
	}
	public String getDonar_City() {
		return Donar_City;
	}
	public void setDonar_City(String donar_City) {
		Donar_City = donar_City;
	}
	public int getDonar_Pin() {
		return Donar_Pin;
	}
	public void setDonar_Pin(int donar_Pin) {
		Donar_Pin = donar_Pin;
	}
	public long getContact_No() {
		return Contact_No;
	}
	public void setContact_No(long contact_No) {
		Contact_No = contact_No;
	}
	
	public String getDonar_PAN() {
		return Donar_PAN;
	}
	public void setDonar_PAN(String donar_PAN) {
		Donar_PAN = donar_PAN;
	}
	public String getGothram() {
		return Gothram;
	}
	public void setGothram(String gothram) {
		Gothram = gothram;
	}
	
	public String getPaymentDescription() {
		return PaymentDescription;
	}
	public void setPaymentDescription(String paymentDescription) {
		PaymentDescription = paymentDescription;
	}
	public String getPaymentDate() {
		return PaymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		PaymentDate = paymentDate;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	
	public String getAmountwords(){
		return Amountwords;
	}
	
	public void setAmountwords(String amountwords){
		Amountwords = amountwords;
	}
	
	public Date getBilled_Date() {
		return Billed_Date;
	}
	public void setBilled_Date(Date billed_Date) {
		Billed_Date = billed_Date;
	}
	public PoojaSchemeMaster getScheme() {
		return Scheme;
	}
	public void setScheme(PoojaSchemeMaster scheme) {
		Scheme = scheme;
	}
	public RaasiMaster getRaasi() {
		return Raasi;
	}
	public void setRaasi(RaasiMaster raasi) {
		Raasi = raasi;
	}
	public NatchatramMaster getNatchatram() {
		return Natchatram;
	}
	public void setNatchatram(NatchatramMaster natchatram) {
		Natchatram = natchatram;
	}
	public long getRid() {
		return Rid;
	}
	public void setRid(long rid) {
		Rid = rid;
	}
	public PaymentModeMaster getPayMode() {
		return payMode;
	}
	public void setPayMode(PaymentModeMaster payMode) {
		this.payMode = payMode;
	}
	public LoginBean getBilledBy() {
		return billedBy;
	}
	public void setBilledBy(LoginBean billedBy) {
		this.billedBy = billedBy;
	}
	public TrustMaster getTrustID() {
		return trustID;
	}
	public void setTrustID(TrustMaster trustID) {
		this.trustID = trustID;
	}
	public String getReceiptno() {
		return receiptno;
	}
	public void setReceiptno(String receiptno) {
		this.receiptno = receiptno;
	}
	
	

}
