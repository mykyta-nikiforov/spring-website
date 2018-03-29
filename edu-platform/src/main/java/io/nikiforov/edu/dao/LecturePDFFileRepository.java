package io.nikiforov.edu.dao;

import io.nikiforov.edu.entity.LecturePDFFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturePDFFileRepository extends JpaRepository<LecturePDFFile, Integer> {
    LecturePDFFile findByLectureFileId(int id);
}
