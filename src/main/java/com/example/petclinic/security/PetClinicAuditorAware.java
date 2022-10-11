package com.example.petclinic.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PetClinicAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication aut = SecurityContextHolder.getContext().getAuthentication();
        return Optional.ofNullable(aut !=null?aut.getName():null);
    }
}
