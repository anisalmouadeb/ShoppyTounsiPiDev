package tn.esprit.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tn.esprit.pi.entities.Provider;
import tn.esprit.pi.service.IproviderService;

@Controller
public class ProviderControllerImpl {

	@Autowired
	IproviderService iProviderService;

	public long addShelf(Provider provider) {
		iProviderService.addProvider(provider);
		return provider.getProviderId();
	}

	public void DeleteShelfById(long providerId) {

		iProviderService.DeleteProviderById(providerId);

	}

	public List<Provider> getAllEmployes() {

		return iProviderService.getAllProviders();
	}

}
