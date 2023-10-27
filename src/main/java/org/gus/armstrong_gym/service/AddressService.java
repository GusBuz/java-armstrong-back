package org.gus.armstrong_gym.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.gus.armstrong_gym.domain.model.Address;
import org.gus.armstrong_gym.domain.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
  
  @Autowired
  AddressRepository addressRepository;

  public List<Address> findAll(){
    return addressRepository.findAll();
  }

  public Address findById(Long id) {
    return addressRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  public Address updateAddress(Long id, Address newAddress){
    Address updatedAddress = addressRepository.findById(id).orElseThrow(NoSuchElementException::new);
    updatedAddress.updateAdress(newAddress);
    return addressRepository.save(updatedAddress);
  }
}
