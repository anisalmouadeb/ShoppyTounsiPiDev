package tn.esprit.pi.paypayment;


import com.paypal.api.payments.Payment;

public class CompletePaymentResponseE {
	private String success;
	private Payment payment;
	public CompletePaymentResponseE() {
		super();
	}
	public CompletePaymentResponseE(String success, Payment payment) {
		super();
		this.success = success;
		this.payment = payment;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}
