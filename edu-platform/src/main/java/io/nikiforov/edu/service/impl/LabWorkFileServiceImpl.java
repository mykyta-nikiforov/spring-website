package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.LabWorkFileRepository;
import io.nikiforov.edu.entity.LabWork;
import io.nikiforov.edu.entity.LabWorkFile;
import io.nikiforov.edu.model.LabWorkFileInfo;
import io.nikiforov.edu.service.LabWorkFileService;
import io.nikiforov.edu.service.LabWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
public class LabWorkFileServiceImpl implements LabWorkFileService {

    @Autowired
    LabWorkFileRepository labWorkFileRepository;

    @Autowired
    LabWorkService labWorkService;

    @Override
    public List<LabWorkFile> findAllByLabWorkId(int id) {
        return labWorkFileRepository.findAllByLabWorkId(id);
    }

    @Override
    public LabWorkFile findById(int id) {
        return labWorkFileRepository.findOne(id);
    }

    @Override
    public void save(LabWorkFile labWorkFile) {
        labWorkFileRepository.save(labWorkFile);
    }

    @Override
    public LabWorkFile save(LabWorkFileInfo labWorkFileInfo, MultipartFile file) {
        LabWork labWork = labWorkService.getLabWork(labWorkFileInfo.getLabWorkId());
        LabWorkFile labWorkFile = new LabWorkFile(labWorkFileInfo, file);
        labWorkFile.setLabWork(labWork);
        return labWorkFileRepository.save(labWorkFile);
    }

    @Override
    public void delete(int id) {
        labWorkFileRepository.delete(id);
    }
}