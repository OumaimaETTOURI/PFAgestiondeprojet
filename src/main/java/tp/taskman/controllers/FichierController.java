package tp.taskman.controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tp.taskman.entities.Fichier;
import tp.taskman.services.FichierService;

import java.io.ByteArrayInputStream;

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
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) {
        Fichier fichier = fichierService.getFichierById(id);
        if (fichier != null) {
            String content = fichier.getContenuFichier(); // Supposons que getContent() renvoie le contenu du fichier sous forme de tableau de bytes

            // Convertir le contenu en InputStreamResource
            InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(content.getBytes()));

            // Créer les en-têtes de la réponse
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fichier.getNomFichier());
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            // Renvoyer la réponse avec le fichier en tant que flux
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(content.length())
                    .body((Resource) resource);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Long id) {
        boolean deleted = fichierService.deleteFichier(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
