package com.t3.beans.requests;

/**
 * Created by TrungTrinh on 6/12/16.
 */
public class Customer {
  String fullName;
  String email;
  String mobile;
  String address;
  String brand;

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "fullName='" + fullName + '\'' +
        ", email='" + email + '\'' +
        ", mobile='" + mobile + '\'' +
        ", address='" + address + '\'' +
        ", brand='" + brand + '\'' +
        '}';
  }
}
