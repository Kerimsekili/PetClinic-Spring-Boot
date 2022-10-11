package com.example.petclinic.service;

import com.example.petclinic.dao.OwnerRepository;
import com.example.petclinic.dao.PetRepository;
import com.example.petclinic.dao.jpa.VetRepository;
import com.example.petclinic.exception.OwnerNotFoundException;
import com.example.petclinic.exception.VetNotFoundException;
import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
@Service
@Transactional(rollbackFor = Exception.class)
public class PetClinicServiceImpl implements PetClinicService{

    private OwnerRepository ownerRepository;

    private PetRepository petRepository;

    @Autowired
    private JavaMailSender mailSender;

    private VetRepository vetRepository;

    @Autowired
    public void setVetRepository(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Autowired
    public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Autowired
    public void setPetRepository(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Secured(value ={"ROLE_USER","ROLE_EDITOR"})
    public List<Owner> findOwners() {
        return ownerRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Owner> findOwners(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Owner findOwner(Long id) throws OwnerNotFoundException {
        Owner owner = ownerRepository.findById(id);
        if (owner==null) throw new OwnerNotFoundException("Owner not found with id : " + id);
        return owner;
    }

    @Override
    @CacheEvict(cacheNames = "allOwners",allEntries = true)
    public void createOwner(@Valid Owner owner) {
        ownerRepository.create(owner);

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("k@s");
        msg.setTo("m@y");
        msg.setSubject("Owner Created ! ");
        msg.setText("Owner entity with id : "+ owner.getId() +"created successfully!");

        mailSender.send(msg);
    }

    @Override
    public void updateOwner(Owner owner) {
        ownerRepository.update(owner);
    }

    @Override
    public void deleteOwner(Long id) {
        petRepository.deleteByOwnerId(id);
        ownerRepository.delete(id);
        //if (true) throw new RuntimeException("testing rollback");
    }

    @Override
    public List<Vet> findVets() {
        return vetRepository.findAll();
    }

    @Override
    public Vet findVet(Long id) throws VetNotFoundException {
        vetRepository.findById(id).orElseThrow(() ->{return new VetNotFoundException("Vet not found by id : "+ id);});
        return null;
    }
}
