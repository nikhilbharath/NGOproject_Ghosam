package Model;

import java.util.HashMap;

public class PaymentModeMaster {
	
	private int PaymentModeID;
	private String PaymentMode;
	
	private HashMap<Integer,String> paylist;
	
	public int getPaymentModeID() {
		return PaymentModeID;
	}
	public void setPaymentModeID(int paymentModeID) {
		PaymentModeID = paymentModeID;
	}
	public String getPaymentMode() {
		return PaymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		PaymentMode = paymentMode;
	}
	public HashMap<Integer,String> getPaylist() {
		return paylist;
	}
	public void setPaylist(HashMap<Integer,String> paylist) {
		this.paylist = paylist;
	}

}
