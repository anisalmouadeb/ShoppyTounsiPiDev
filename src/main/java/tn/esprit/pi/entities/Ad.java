package tn.esprit.pi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Ad implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private long adId;
	private String name;
	private String Channel;
	private int nbTouchedPpl;
	private int nbTargetViews;
	private float price;
	private String adType;
	@Temporal(TemporalType.DATE)
	private Date StartDate;
	@Temporal(TemporalType.DATE)
	private Date EndDate;
	@ManyToOne 
	private Product product;
	
	
	public Ad(String name, String channel, int nbTouchedPpl, int nbTargetViews, float price, String adType,
			Date startDate, Date endDate, Product product) {
		super();
		this.name = name;
		Channel = channel;
		this.nbTouchedPpl = nbTouchedPpl;
		this.nbTargetViews = nbTargetViews;
		this.price = price;
		this.adType = adType;
		StartDate = startDate;
		EndDate = endDate;
		this.product = product;
	}



	public Ad() {
		super();
	}
	
	
	
	public long getAdId() {
		return adId;
	}
	public void setAdId(long adId) {
		this.adId = adId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChannel() {
		return Channel;
	}
	public void setChannel(String channel) {
		Channel = channel;
	}
	public int getNbTouchedPpl() {
		return nbTouchedPpl;
	}
	public void setNbTouchedPpl(int nbTouchedPpl) {
		this.nbTouchedPpl = nbTouchedPpl;
	}
	public int getNbTargetViews() {
		return nbTargetViews;
	}
	public void setNbTargetViews(int nbTargetViews) {
		this.nbTargetViews = nbTargetViews;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getAdType() {
		return adType;
	}
	public void setAdType(String adType) {
		this.adType = adType;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	
	
}
