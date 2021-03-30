package tn.esprit.pi.paypayment;

public class PaymentResponseE {
	private String redirectUrl;
    private String status;
    
    
	public PaymentResponseE() {
	}
	
	
	public PaymentResponseE(String redirectUrl, String status) {
		super();
		this.redirectUrl = redirectUrl;
		this.status = status;
	}


	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
