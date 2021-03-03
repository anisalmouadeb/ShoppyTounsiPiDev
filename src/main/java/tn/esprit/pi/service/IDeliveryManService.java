package tn.esprit.pi.service;

import java.util.List;

import tn.esprit.pi.entities.DeliveryMan;

public interface IDeliveryManService {

	public void addDeliveryMan(DeliveryMan deliveryman);
	
	public void UpdateDeliveryMan(DeliveryMan deliveryman);

	public void DeleteDeliveryManById(long deliverymanId);
	
	public DeliveryMan RetrieveDeliveryManById(long deliverymanId);


	public List<DeliveryMan> getAllDeliveryMans();
}
