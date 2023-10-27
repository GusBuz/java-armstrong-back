package org.gus.armstrong_gym.domain.repository;

import org.gus.armstrong_gym.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{
  
}
