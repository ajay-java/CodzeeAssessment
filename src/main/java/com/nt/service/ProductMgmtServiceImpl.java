package com.nt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.offers.Offers;
import com.nt.entity.product.Product;
import com.nt.repository.offersrepo.IOffersRepository;
import com.nt.repository.prodrepo.IProductRepository;

@Service
public class ProductMgmtServiceImpl implements IProductMgmtService {
	@Autowired
	private  IProductRepository  prodRepo;
	@Autowired
	private  IOffersRepository  offersRepo;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String saveProductAndOffers(Product prod, Offers offrs) {
		//use repo
		int pidVal=prodRepo.save(prod).getPid();
		int oidVal=offersRepo.save(offrs).getOid();
		return "product and  offers are saved with the id values :"+pidVal+"...."+oidVal;
	}

	@Override
	public Map<String, Object> showProductsAndOffers() {
		Map<String, Object> result = new HashMap<>();

		result.put("products", prodRepo.findAll());
		result.put("offers", offersRepo.findAll());

		return result;
	}

}
