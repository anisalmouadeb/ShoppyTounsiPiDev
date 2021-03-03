package tn.esprit.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.Delivery;
import tn.esprit.pi.entities.DeliveryMan;
import tn.esprit.pi.repository.DeliveryManRepository;
import tn.esprit.pi.repository.DeliveryRepository;

@Service
public class DeliveryService implements IDeliveryService {
	
	
	
	@Autowired
	
	
	DeliveryRepository deliveryrep;

	@Override
	public void addDelivery(Delivery delivery) {
		// TODO Auto-generated method stub
		deliveryrep.save(delivery);
	}

	@Override
	public void UpdateDelivery(Delivery delivery) {
		// TODO Auto-generated method stub
		deliveryrep.save(delivery);
	}

	@Override
	public void DeleteDeliveryById(long deliveryId) {
		// TODO Auto-generated method stub
		deliveryrep.deleteById(deliveryId);
	}

	@Override
	public Delivery RetrieveDeliveryById(long deliveryId) {
		// TODO Auto-generated method stub
		return deliveryrep.findById(deliveryId).get();
	}

	@Override
	public List<Delivery> getAllDeliverys() {
		// TODO Auto-generated method stub
		return (List<Delivery>)deliveryrep.findAll();
	}

}
