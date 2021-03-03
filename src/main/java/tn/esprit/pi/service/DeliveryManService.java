package tn.esprit.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.DeliveryMan;
import tn.esprit.pi.repository.DeliveryManRepository;

@Service
public class DeliveryManService implements IDeliveryManService {

	@Autowired
	
	
	DeliveryManRepository deliverymanrep;
	
	@Override
	public void addDeliveryMan(DeliveryMan deliveryman) {
		// TODO Auto-generated method stub
		deliverymanrep.save(deliveryman);
	}

	@Override
	public void UpdateDeliveryMan(DeliveryMan deliveryman) {
		// TODO Auto-generated method stub
		deliverymanrep.save(deliveryman);
	}

	@Override
	public void DeleteDeliveryManById(long deliverymanId) {
		// TODO Auto-generated method stub
		deliverymanrep.deleteById(deliverymanId);
	}

	@Override
	public DeliveryMan RetrieveDeliveryManById(long deliverymanId) {
		// TODO Auto-generated method stub
		return deliverymanrep.findById(deliverymanId).get();
	}

	@Override
	public List<DeliveryMan> getAllDeliveryMans() {
		// TODO Auto-generated method stub
		return (List<DeliveryMan>)deliverymanrep.findAll();
	}

	}
