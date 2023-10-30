package com.tags.cs451r_groupproject_backend.filetransfer.rest;

import com.tags.cs451r_groupproject_backend.filetransfer.model.FileDescriptionDTO;
import com.tags.cs451r_groupproject_backend.filetransfer.service.FileService;
import com.tags.cs451r_groupproject_backend.filetransfer.model.File;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class FileController {
    private FileService storageService;

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        File file = storageService.findById(id);

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getName() + "\""
                ).body(file.getData());
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileDescriptionDTO>> getAllFiles() {
        List<FileDescriptionDTO> fileDescriptionDTOList = storageService.getAllFiles()
                .stream()
                .map(FileDescriptionDTO::new)
                .toList();
        return new ResponseEntity<>(fileDescriptionDTOList, HttpStatus.OK);
    }

    @PostMapping("/files")
    public ResponseEntity<FileDescriptionDTO> createFile(@RequestParam("file")MultipartFile file) {
        File file1 = storageService.createFile(file);
        FileDescriptionDTO fileDescriptionDTO = new FileDescriptionDTO(file1);
        return new ResponseEntity<>(fileDescriptionDTO, HttpStatus.OK);

    }

}
