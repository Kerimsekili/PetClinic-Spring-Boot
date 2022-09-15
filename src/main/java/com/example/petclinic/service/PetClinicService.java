package com.example.petclinic.service;

import com.example.petclinic.exception.OwnerNotFoundException;
import com.example.petclinic.model.Owner;

import java.util.List;

public interface PetClinicService {
    List<Owner> findOwners();
    List<Owner> findOwners(String lastName);
    Owner findOwner(Long id) throws OwnerNotFoundException;
    void createOwner(Owner owner);
    void updateOwner(Owner owner);
    void deleteOwner(Long id);

}
