package com.store.ecommerce.dto;

import com.store.ecommerce.model.User;

public class UserDto {
    private String name;

    private String email;

    private String address;

    private String addressNumber;

    public UserDto() {
    }

    public UserDto(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.addressNumber = user.getAddressNumber();
    }

    public UserDto(String name, String email, String address, String addressNumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.addressNumber = addressNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }
}
