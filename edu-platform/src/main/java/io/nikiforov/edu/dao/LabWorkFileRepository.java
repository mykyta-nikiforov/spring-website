package io.nikiforov.edu.dao;

import io.nikiforov.edu.entity.LabWorkFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabWorkFileRepository extends JpaRepository<LabWorkFile, Integer> {

    List<LabWorkFile> findAllByLabWorkId(int id);

}