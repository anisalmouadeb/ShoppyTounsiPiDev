package tn.esprit.pi.service;

import java.util.List;

import tn.esprit.pi.entities.Claim;

public interface IClaimService {

	public void addClaim(Claim claim);
	
	public void UpdateClaim(Claim claim);

	public void DeleteClaimById(long claimId);
	
	public Claim RetrieveClaimById(long claimId);


	public List<Claim> getAllClaims();
}
