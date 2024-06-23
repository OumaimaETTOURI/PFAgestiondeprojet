package tp.taskman.services.serviceImpls;

import org.hibernate.engine.jdbc.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tp.taskman.entities.Fichier;
import tp.taskman.exceptions.ResourceNotFoundException;
import tp.taskman.repositories.FichierRepository;
import tp.taskman.services.FichierService;
import java.io.IOException;
import java.util.List;

@Service
public class FichierServiceImpl implements FichierService {

    @Autowired

    FichierRepository fichierRepository;

    @Override
    public Fichier getFichierById(Long id) {
        return fichierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fichier with ID " + id + " not found"));
    }

    @Override
    public Fichier createFichier(Fichier fichier) {
        return fichierRepository.save(fichier);
    }

    @Override
    public Fichier updateFichier(Long id, Fichier updatedFichier) {
        return fichierRepository.findById(id)
                .map(existingFichier -> {
                    existingFichier.setNomFichier(updatedFichier.getNomFichier());
                    existingFichier.setChemin(updatedFichier.getChemin());
                    existingFichier.setContenuFichier(updatedFichier.getContenuFichier());
                    existingFichier.setTailleFichier(updatedFichier.getTailleFichier());
                    existingFichier.setTypeFichier(updatedFichier.getTypeFichier());
                    return fichierRepository.save(existingFichier);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Fichier with ID " + id + " not found"));
    }

    @Override
    public boolean deleteFichier(Long id) {
        return fichierRepository.findById(id)
                .map(existingFichier -> {
                    fichierRepository.delete(existingFichier);
                    return true;
                })
                .orElseThrow(() -> new ResourceNotFoundException("Fichier with ID " + id + " not found"));
    }

    @Override
    public List<Fichier> getAllFichiers() {
        return fichierRepository.findAll();
    }

    @Override
    public Fichier uploadFile(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            String fileContent = new String(file.getBytes());
            String fileType = file.getContentType();
            long fileSize = file.getSize();

            Fichier fichier = new Fichier();
            fichier.setNomFichier(fileName);
            fichier.setContenuFichier(fileContent);
            fichier.setTypeFichier(fileType);
            fichier.setTailleFichier(Size.length(fileSize));

            return fichierRepository.save(fichier);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file: " + e.getMessage());
        }
    }
}
