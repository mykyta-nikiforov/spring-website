package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.DegreeRepository;
import io.nikiforov.edu.entity.Degree;
import io.nikiforov.edu.service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DegreeServiceImpl implements DegreeService {
    @Autowired
    private DegreeRepository degreeRepository;

    @Override
    public List<Degree> findAll() {
        return degreeRepository.findAll();
    }
}
