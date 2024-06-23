package tp.taskman.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tp.taskman.entities.Fichier;

import java.util.List;

@Service
public interface FichierService {
    Fichier getFichierById(Long id);

    Fichier createFichier(Fichier fichier);

    Fichier updateFichier(Long id, Fichier fichier);

    boolean deleteFichier(Long id);

    List<Fichier> getAllFichiers();

    Fichier uploadFile(MultipartFile file);
}
