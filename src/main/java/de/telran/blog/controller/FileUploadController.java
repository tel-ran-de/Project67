package de.telran.blog.controller;

import de.telran.blog.exceptions.StorageException;
import de.telran.blog.service.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    private StorageService storageService;

    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @RequestMapping(value = "/file", method = RequestMethod.POST,
            consumes = {"multipart/form-data"})
    public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile file) {

        storageService.uploadFile(file);

        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
    }

    @ExceptionHandler(StorageException.class)
    public ResponseEntity<Object> handleStorageFileNotFound(StorageException e) {

        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
