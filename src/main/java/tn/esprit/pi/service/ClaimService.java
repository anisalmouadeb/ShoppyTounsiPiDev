package tn.esprit.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.Claim;
import tn.esprit.pi.entities.Delivery;
import tn.esprit.pi.repository.ClaimRepository;

@Service
public class ClaimService implements IClaimService {
	

	@Autowired
	
	
	ClaimRepository claimrep;

	@Override
	public void addClaim(Claim claim) {
		// TODO Auto-generated method stub
		claimrep.save(claim);
	}

	@Override
	public void UpdateClaim(Claim claim) {
		// TODO Auto-generated method stub
		claimrep.save(claim);
	}

	@Override
	public void DeleteClaimById(long claimId) {
		// TODO Auto-generated method stub
		claimrep.deleteById(claimId);
	}

	@Override
	public Claim RetrieveClaimById(long claimId) {
		// TODO Auto-generated method stub
		return claimrep.findById(claimId).get();
	}

	@Override
	public List<Claim> getAllClaims() {
		// TODO Auto-generated method stub
		return (List<Claim>)claimrep.findAll();
	}

}
