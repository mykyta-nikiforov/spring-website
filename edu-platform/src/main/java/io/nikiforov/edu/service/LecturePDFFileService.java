package io.nikiforov.edu.service;

import io.nikiforov.edu.entity.LecturePDFFile;
import io.nikiforov.edu.model.LecturePDFFileInfo;

public interface LecturePDFFileService {
    LecturePDFFile save(LecturePDFFileInfo lecturePDFFileInfo);

    LecturePDFFile findOne(int id);
}
