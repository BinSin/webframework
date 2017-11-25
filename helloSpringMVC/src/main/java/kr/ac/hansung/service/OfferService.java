package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.hansung.dao.OfferDAO;
import kr.ac.hansung.model.Offer;

public class OfferService {

	@Autowired
	private OfferDAO offerDAO;
	
	public List<Offer> getCurrent() {
		return offerDAO.getOffers();
	}

	public void insert(Offer offer) {
		offerDAO.insert(offer);
	}

}
