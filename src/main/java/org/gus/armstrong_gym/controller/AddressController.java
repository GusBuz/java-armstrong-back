package org.gus.armstrong_gym.controller;

import java.util.List;

import org.gus.armstrong_gym.domain.model.Address;
import org.gus.armstrong_gym.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressController {
  
  @Autowired
  AddressService addressService;

  @GetMapping
  public ResponseEntity<List<Address>> getAddresses(){
    var addressList = addressService.findAll();
    return ResponseEntity.ok(addressList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Address> getOneAddress(@PathVariable Long id){
    var address = addressService.findById(id);
    return ResponseEntity.ok(address);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address){
    var updatedAddress = addressService.updateAddress(id, address);
    return ResponseEntity.ok(updatedAddress);
  }
}
