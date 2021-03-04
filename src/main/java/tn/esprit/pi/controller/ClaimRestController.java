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

import tn.esprit.pi.entities.Claim;
import tn.esprit.pi.entities.Delivery;
import tn.esprit.pi.service.IClaimService;

@RestController
@RequestMapping("/claim")
public class ClaimRestController {
	

	@Autowired
	
	IClaimService devserv;


	@PostMapping("/addClaim")
	public void AddClaim(@RequestBody Claim dev){
		devserv.addClaim(dev);
	}
	
	@GetMapping("/getallClaim")
	public List<Claim> GetAllClaim(){
		
		return devserv.getAllClaims();
		
	}
	
	@GetMapping("getClaim/{id}")
	public Claim GetClaim(@PathParam("id") long claimId){
		
		return devserv.RetrieveClaimById(claimId);
	}
	
	@DeleteMapping("/deleteClaim/{id}")
	public  void DeleteClaim(@PathParam("id") long claimId){
		devserv.DeleteClaimById(claimId);
	}
	
	@PutMapping("/updateClaim")
	public void UpdateClaim(@RequestBody Claim dev){
		devserv.UpdateClaim(dev);
	}
	

}
