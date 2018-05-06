package io.nikiforov.edu.service;

import io.nikiforov.edu.entity.LabWorkFile;
import io.nikiforov.edu.model.LabWorkFileInfo;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface LabWorkFileService {

    List<LabWorkFile> findAllByLabWorkId(int id);

    LabWorkFile findById(int id);

    void save(LabWorkFile labWorkFile);

    LabWorkFile save(LabWorkFileInfo labWorkFileInfo, MultipartFile file);

    void delete(int id);
}