package com.nt.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IProductMgmtService;

@Component
public class MultiDBTestRunner implements CommandLineRunner {
	@Autowired
	private  IProductMgmtService prodService;

	@Override
	public void run(String... args) throws Exception {
		/*	try {
		  Product prod=new Product("table",4000.0,10.0);
		  Offers offrs=new Offers("Diwali",20.0,LocalDate.of(2026, 10, 11));
		  //invoke the method
		  String msg=prodService.saveProductAndOffers(prod, offrs);
		  System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		try {
			prodService.showProductsAndOffers().forEach(row->{
				System.out.println(Arrays.toString(row));
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//run(-)

}//class
