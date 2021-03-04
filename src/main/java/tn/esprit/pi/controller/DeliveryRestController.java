package tn.esprit.pi.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pi.entities.Delivery;
import tn.esprit.pi.service.IDeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryRestController {
   
	@Autowired
	
	IDeliveryService devserv;
	
	
	
	@PostMapping("/addDelivery")
	public void AddDelivery(@RequestBody Delivery dev){
		devserv.addDelivery(dev);
	}
	
	@GetMapping("/getallDelivery")
	public List<Delivery> GetAllDelivery(){
		
		return devserv.getAllDeliverys();
		
	}
	
	@GetMapping("getDelivery/{id}")
	public Delivery GetDelivery(@PathParam("id") long deliveryId){
		
		return devserv.RetrieveDeliveryById(deliveryId);
	}
	
	@DeleteMapping("/deleteDelivery/{id}")
	public  void DeleteDelivery(@PathParam("id") long deliveryId){
		devserv.DeleteDeliveryById(deliveryId);
	}
	
	@PutMapping("/updateDelivery")
	public void UpdateDelivery(@RequestBody Delivery dev){
		devserv.UpdateDelivery(dev);
	}
	
	
	
	
}
