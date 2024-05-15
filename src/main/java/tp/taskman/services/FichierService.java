package tp.taskman.services;

import org.springframework.web.multipart.MultipartFile;
import tp.taskman.entities.Fichier;

public interface FichierService {
    boolean deleteFile(Long id);

    Fichier getFileById(Long id);

    Fichier uploadFile(MultipartFile file);
}
