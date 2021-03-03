package tn.esprit.pi.service;

import java.util.List;

import tn.esprit.pi.entities.Delivery;

public interface IDeliveryService {
	
	public void addDelivery(Delivery delivery);
	
	public void UpdateDelivery(Delivery delivery);

	public void DeleteDeliveryById(long deliveryId);
	
	public Delivery RetrieveDeliveryById(long deliveryId);


	public List<Delivery> getAllDeliverys();

}
