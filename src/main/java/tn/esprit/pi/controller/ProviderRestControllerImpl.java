package tn.esprit.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.pi.entities.Provider;
import tn.esprit.pi.service.IproviderService;

@RestController
public class ProviderRestControllerImpl {

	@Autowired
	IproviderService iProviderService;

	@PostMapping("/addProvider")
	@ResponseBody
	public Provider addShelf(@RequestBody Provider provider) {
		iProviderService.addProvider(provider);
		return provider;
	}

	@DeleteMapping("/deleteProviderById/{idProvider}")
	@ResponseBody
	public void deleteEmployeById(@PathVariable("idProvider") long providerId) {
		iProviderService.DeleteProviderById(providerId);

	}

	@GetMapping(value = "/getAllProviders")
	@ResponseBody
	public List<Provider> getAllEmployes() {

		return iProviderService.getAllProviders();
	}

}
