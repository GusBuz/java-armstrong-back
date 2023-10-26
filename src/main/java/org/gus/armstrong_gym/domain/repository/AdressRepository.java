package org.gus.armstrong_gym.domain.repository;

import org.gus.armstrong_gym.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Address,Long>{
  
}
