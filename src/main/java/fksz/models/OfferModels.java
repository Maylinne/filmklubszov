package fksz.models;

import java.util.List;

public class OfferModels {
	
	boolean isMine;
	List<OfferModel> offers;
	int principalId;
	
	public int getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(int principalId) {
		this.principalId = principalId;
	}

	public OfferModels() {}

	public boolean getIsMine() {
		return isMine;
	}

	public void setIsMine(boolean isMine) {
		this.isMine = isMine;
	}

	public List<OfferModel> getOffers() {
		return offers;
	}

	public void setOffers(List<OfferModel> offers) {
		this.offers = offers;
	}
}
