package com.telecom.kanban.services;

import com.telecom.kanban.model.Developer;
import com.telecom.kanban.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class DeveloperService {
    @Autowired
    private DeveloperRepository developerRepository;
    public Developer addDeveloper(Developer developer){return developerRepository.save(developer);}
    public Optional<Developer> findDeveloperById(Long id){return developerRepository.findById(id);}
    public Collection<Developer> findAllDeveloper() {return developerRepository.findAll();}


}
