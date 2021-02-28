package tn.esprit.pi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jackpot implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long jackpotId;
	private String name ;
	private int currentAmount ;
	private int globalAmount;
	public Jackpot(String name, int currentAmount, int globalAmount) {
		super();
		this.name = name;
		this.currentAmount = currentAmount;
		this.globalAmount = globalAmount;
	}
	public Jackpot() {
		super();
	}
	public long getJackpotId() {
		return jackpotId;
	}
	public void setJackpotId(long jackpotId) {
		this.jackpotId = jackpotId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}
	public int getGlobalAmount() {
		return globalAmount;
	}
	public void setGlobalAmount(int globalAmount) {
		this.globalAmount = globalAmount;
	}
	
	
	

}
