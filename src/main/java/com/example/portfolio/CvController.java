package com.example.portfolio;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Controller
public class CvController {

    @GetMapping("/cv/{lang}")
    public ResponseEntity<Resource> downloadCv(@PathVariable("lang") String lang) throws IOException {
        String filename = switch (lang.toLowerCase()) {
            case "en" -> "CV_Stiliyan_Georgiev_EN.pdf";
            case "de" -> "CV_Stiliyan_Georgiev_DE.pdf";
            default -> null;
        };

        if (filename == null) {
            return ResponseEntity.notFound().build();
        }

        // PDFs must be located under: src/main/resources/files/
        ClassPathResource resource = new ClassPathResource("files/" + filename);
        if (!resource.exists() || !resource.getFile().exists()) {
            System.out.println("❌ File not found: " + filename);
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .body(resource);
    }
}
