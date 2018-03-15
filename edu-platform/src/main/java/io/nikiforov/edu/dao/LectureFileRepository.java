package io.nikiforov.edu.dao;

import io.nikiforov.edu.entity.LectureFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureFileRepository extends JpaRepository<LectureFile, Integer> {

}
