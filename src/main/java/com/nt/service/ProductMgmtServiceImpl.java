package com.nt.service;

import java.util.List;
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
	public List<Object[]> showProductsAndOffers() {
		List<Product> listProd=prodRepo.findAll();
		List<Offers> listOffers=offersRepo.findAll();
		List<Object[]> combined = 
			    IntStream.range(0, Math.min(listProd.size(), listOffers.size()))
			             .mapToObj(i -> new Object[]{listProd.get(i), listOffers.get(i) })
			             .collect(Collectors.toList());
		return combined;
	}

}
