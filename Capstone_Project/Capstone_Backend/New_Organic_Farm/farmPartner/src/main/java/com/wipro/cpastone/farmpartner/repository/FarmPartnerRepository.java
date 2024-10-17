package com.wipro.cpastone.farmpartner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.cpastone.farmpartner.entity.FarmPartner;

@Repository
public interface FarmPartnerRepository extends JpaRepository<FarmPartner, Long> {

	Optional<FarmPartner> findByEmail(String email);
}
