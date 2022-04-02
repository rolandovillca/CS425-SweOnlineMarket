package edu.miu.cs.cs425.sweonlinemarketproject.service;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> getAllAddress();
    Address createAddress(Address address);
    Address  updateAddress(Address address, Long id);
    void deleteAddressById(Long id);
}

