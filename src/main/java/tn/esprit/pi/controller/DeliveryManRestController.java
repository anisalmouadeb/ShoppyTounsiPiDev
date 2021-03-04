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

import tn.esprit.pi.entities.DeliveryMan;
import tn.esprit.pi.service.IDeliveryManService;

@RestController
@RequestMapping("/deliveryman")
public class DeliveryManRestController {

	
	@Autowired
	
	IDeliveryManService devserv;
	
	@PostMapping("/addDeliveryMan")
	public void AddDeliveryMan(@RequestBody DeliveryMan dev){
		devserv.addDeliveryMan(dev);
	}
	
	@GetMapping("/getallDeliveryMans")
	public List<DeliveryMan> GetAllDeliveryMans(){
		
		return devserv.getAllDeliveryMans();
		
	}
	
	@GetMapping("getDeliveryMan/{id}")
	public DeliveryMan GetDelivery(@PathParam("id") long deliveryId){
		
		return devserv.RetrieveDeliveryManById(deliveryId);
	}
	
	@DeleteMapping("/deleteDeliveryMan/{id}")
	public  void DeleteDeliveryMan(@PathParam("id") long deliveryId){
		devserv.DeleteDeliveryManById(deliveryId);
	}
	
	@PutMapping("/updateDeliveryMan")
	public void UpdateDeliveryMan(@RequestBody DeliveryMan dev){
		devserv.UpdateDeliveryMan(dev);
	}
}
