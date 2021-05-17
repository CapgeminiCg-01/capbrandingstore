package com.capbranding.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capbranding.entities.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
