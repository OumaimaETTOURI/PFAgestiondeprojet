package tp.taskman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tp.taskman.entities.Fichier;
import tp.taskman.services.FichierService;

import java.util.List;

@RestController
@RequestMapping("/fichiers")
public class FichierController {

    private final FichierService fichierService;

    @Autowired
    public FichierController(FichierService fichierService) {
        this.fichierService = fichierService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Fichier> uploadFile(@RequestParam("file") MultipartFile file) {
        Fichier uploadedFile = fichierService.uploadFile(file);
        return new ResponseEntity<>(uploadedFile, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fichier> downloadFile(@PathVariable Long id) {
        Fichier fichier = fichierService.getFileById(id);
        if (fichier != null) {
            // Ici, vous pouvez implémenter la logique pour télécharger le fichier
            return new ResponseEntity<>(fichier, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Long id) {
        boolean deleted = fichierService.deleteFile(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
