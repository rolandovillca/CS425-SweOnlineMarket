package edu.miu.cs.cs425.sweonlinemarketproject.controller;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Address;
import edu.miu.cs.cs425.sweonlinemarketproject.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
    public List<Address> loadAllUsers(){
        return addressService.getAllAddress();
    }

    @PostMapping("/addresses")
    public Address addAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    @DeleteMapping("/addresses/{id}")
    public void deleteAddress(@PathVariable long id){
        addressService.deleteAddressById(id);
    }

}



