package tn.esprit.pi.paypayment;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.api.payments.Payment;

import tn.esprit.pi.entities.Orders;
import tn.esprit.pi.repository.OrdersRepository;



@RestController
@RequestMapping(value = "/paypale")
public class PaypalControllerE {
	private final PaypalClientE paypalClient;
	private Map<String,Object> response = new HashMap<>();
	
	@Autowired
	PaypalControllerE(PaypalClientE paypalClient) {
		this.paypalClient = paypalClient;
	}
	@Autowired
	OrdersRepository ordersRepository;
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/makee/paymentee/{orderId}")
	public ResponseEntity<?> makePaymentE(@PathVariable("orderId") long orderId,@RequestBody PaymentRequestE paymentRequest,Authentication auth) {
	Orders o= ordersRepository.findById(orderId).get();	
o.setConfirmedPayment(true);
ordersRepository.save(o);
		response = paypalClient.createPayment(paymentRequest);
		return new ResponseEntity<PaymentResponseE>(new PaymentResponseE((String)response.get("redirect_url"), (String)response.get("status")), 
        		HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/completee/paymentee")
	public ResponseEntity<?> completePaymentE(@RequestBody CompletePaymentRequestE completePaymentRequest){
		response = paypalClient.completePayment(completePaymentRequest);
		return new ResponseEntity<CompletePaymentResponseE>(new CompletePaymentResponseE((String)response.get("status"), (Payment)response.get("payment")), 
        		HttpStatus.OK);
	}

}
