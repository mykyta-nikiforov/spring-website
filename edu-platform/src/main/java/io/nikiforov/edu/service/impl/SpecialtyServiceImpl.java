package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.SpecialtyRepository;
import io.nikiforov.edu.entity.Specialty;
import io.nikiforov.edu.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    SpecialtyRepository specialtyRepository;

    @Override
    public List<Specialty> findAll() {
        return specialtyRepository.findAll();
    }

    @Override
    public Specialty getById(int id) {
        return specialtyRepository.findOne(id);
    }
}
