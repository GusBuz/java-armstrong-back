package org.gus.armstrong_gym.domain.model;

import java.lang.reflect.Field;

import org.gus.armstrong_gym.domain.model.enums.PaymentPlan;
import org.springframework.dao.DataIntegrityViolationException;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "member")
public class Member {  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  private String fullname;

  @Column(unique = true)
  @NotEmpty
  private String cpf;
  
  @NotEmpty
  private String phone;

  @Column(unique = true)
  @NotEmpty
  private String email;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id")
  @JsonManagedReference
  @NotNull
  private Address address;

  @Enumerated(EnumType.STRING)
  @NotNull
  private PaymentPlan paymentPlan;

  public Member(){}

  public Member(@NotEmpty String fullname, @NotEmpty String cpf, @NotEmpty String phone, @NotEmpty String email,
      @NotNull Address address, @NotNull PaymentPlan paymentPlan) {
    this.fullname = fullname;
    this.cpf = cpf;
    this.phone = phone;
    this.email = email;
    this.address = address;
    this.paymentPlan = paymentPlan;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public PaymentPlan getPaymentPlan() {
    return paymentPlan;
  }

  public void setPaymentPlan(PaymentPlan paymentPlan) {
    this.paymentPlan = paymentPlan;
  }

  public void updateMember(Member member){
    Field[] fields = this.getClass().getDeclaredFields();

    for (Field field : fields) {
      try {
        Object value = field.get(address);
        if (value != null) {
          field.set(this, value);
        }
      } catch (IllegalAccessException e) {
        throw new DataIntegrityViolationException("Data integrity violation, unable to access the field: " + field.getName(), e);
      }
    }
  }

  @Override
  public String toString() {
    return "Member [id=" + id + ", fullname=" + fullname + ", cpf=" + cpf + ", phone=" + phone + ", email=" + email
        + ", address=" + address + ", paymentPlan=" + paymentPlan + "]";
  }
}
