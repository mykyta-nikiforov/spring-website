package io.nikiforov.edu.service;

import io.nikiforov.edu.entity.Degree;

import java.util.List;

public interface DegreeService {
    List<Degree> findAll();
}
