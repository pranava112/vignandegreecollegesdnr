package com.vdc.vignan.degree.college.Controller;

import com.vdc.vignan.degree.college.Entity.Image;
import com.vdc.vignan.degree.college.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vignan/images")
@CrossOrigin(origins = "*") // Enable CORS for development
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Image image = new Image();
            image.setName(file.getOriginalFilename());
            image.setData(file.getBytes());
            imageRepository.save(image);

            Map<String, Object> response = new HashMap<>();
            response.put("id", image.getId());
            response.put("name", image.getName());
            response.put("message", "Image uploaded successfully");

            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to upload image: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllImages() {
        try {
            List<Image> images = imageRepository.findAll();
            List<Map<String, Object>> response = images.stream()
                    .map(image -> {
                        Map<String, Object> imageData = new HashMap<>();
                        imageData.put("id", image.getId());
                        imageData.put("name", image.getName());
                        imageData.put("data", Base64.getEncoder().encodeToString(image.getData()));
                        return imageData;
                    })
                    .collect(Collectors.toList());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonList(Map.of("message", "Failed to fetch images: " + e.getMessage())));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getImageById(@PathVariable Long id) {
        try {
            Optional<Image> image = imageRepository.findById(id);
            if (image.isPresent()) {
                Map<String, Object> response = new HashMap<>();
                response.put("id", image.get().getId());
                response.put("name", image.get().getName());
                response.put("data", Base64.getEncoder().encodeToString(image.get().getData()));
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found with id: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to fetch image: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable Long id) {
        Optional<Image> image = imageRepository.findById(id);
        if (image.isPresent()) {
            imageRepository.deleteById(id);
            return ResponseEntity.ok(Map.of("message", "Image deleted successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found with id: " + id);
        }
    }
}
