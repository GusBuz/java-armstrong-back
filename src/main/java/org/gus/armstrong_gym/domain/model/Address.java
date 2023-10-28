package org.gus.armstrong_gym.domain.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "address")
public class Address {  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  private String cep;

  @NotEmpty
  private String street;

  @NotEmpty
  private String number;

  private String complement;

  @NotEmpty
  private String neighborhood;

  @NotEmpty
  private String city;  

  @NotEmpty
  private String state;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
  @JsonBackReference
  @NotNull
  private Member member;

  public Address(){}

  public Address(@NotEmpty String cep, @NotEmpty String street, @NotEmpty String number,
      String complement, @NotEmpty String neighborhood, @NotEmpty String city, @NotEmpty String state) {
    this.cep = cep;
    this.street = street;
    this.number = number;
    this.complement = complement;
    this.neighborhood = neighborhood;
    this.city = city;
    this.state = state;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getComplement() {
    return complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }

  public String getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Member getMember() {
    return member;
  }

  public void setMember(Member member) {
    this.member = member;
  }

  @Override
  public String toString() {
    return "Address [id=" + id + ", cep=" + cep + ", street=" + street + ", number=" + number + ", complement="
        + complement + ", neighborhood=" + neighborhood + ", city=" + city + ", state=" + state + ", member=" 
        + "]";
  }

  public void updateAddress(Address address){
    this.cep = address.getCep();
    this.street = address.getStreet();
    this.number = address.getNumber();
    this.complement = address.getComplement();
    this.neighborhood = address.getNeighborhood();
    this.city = address.getCity();
    this.state = address.getState();
  }
}
