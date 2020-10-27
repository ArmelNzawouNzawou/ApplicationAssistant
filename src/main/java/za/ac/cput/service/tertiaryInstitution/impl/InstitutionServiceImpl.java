package za.ac.cput.service.tertiaryInstitution.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.tertiaryInstitution.Institution;
import za.ac.cput.repository.tertiaryInstitution.InstitutionRepository;
import za.ac.cput.service.tertiaryInstitution.InstitutionService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    @Autowired
    private InstitutionRepository repository;

    @Override
    public Set<Institution> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Institution> getAllStartingWith(String letter) {
        Set<Institution> institutionSet = getAll();
        Set<Institution> institutionsStartingWith = new HashSet<>();
        for(Institution institution : institutionSet){
            if(institution.getInstitutionName().trim().toLowerCase().startsWith(letter))
            {
                institutionsStartingWith.add(institution);
            }
        }
        return institutionsStartingWith;
    }

    @Override
    public Institution create(Institution institution) {
        return this.repository.save(institution);
    }

    @Override
    public Institution read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Institution update(Institution institution) {
        if (this.repository.existsById(institution.getInstitutionId())) {
            return this.repository.save(institution);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s)) return false;
        else return true;
    }
}