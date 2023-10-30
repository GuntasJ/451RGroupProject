package com.tags.cs451r_groupproject_backend.filetransfer.service;

import com.tags.cs451r_groupproject_backend.filetransfer.model.File;
import com.tags.cs451r_groupproject_backend.filetransfer.repository.FileRepository;
import com.tags.cs451r_groupproject_backend.filetransfer.rest.FileNotFoundException;
import com.tags.cs451r_groupproject_backend.filetransfer.rest.InvalidFileException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FileService {
    private FileRepository fileRepository;

    public File createFile(MultipartFile multipartFile)  {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        try {
            File file = new File(fileName, multipartFile.getContentType(), multipartFile.getBytes());
            return fileRepository.save(file);

        } catch (IOException e) {
            throw new InvalidFileException(fileName);
        }
    }

    public File findById(Long id)  {
        Optional<File> fileOptional = fileRepository.findById(id);
        return fileOptional.orElseThrow(() -> new FileNotFoundException(id));
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }
}
