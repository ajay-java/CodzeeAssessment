package com.nt.repository.offersrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.offers.Offers;

public interface IOffersRepository extends JpaRepository<Offers, Integer> {

}
