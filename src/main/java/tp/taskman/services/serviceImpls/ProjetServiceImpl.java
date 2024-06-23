package tp.taskman.services.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.taskman.entities.Projet;
import tp.taskman.exceptions.ResourceNotFoundException;
import tp.taskman.repositories.ProjetRepository;
import tp.taskman.services.ProjetService;

import java.util.List;

@Service
public class ProjetServiceImpl implements ProjetService {

    @Autowired
    private ProjetRepository projetRepository;

    @Override
    public List<Projet> getAllProjects() {
        return projetRepository.findAll();
    }

    @Override
    public Projet getProjectById(Long id) {
        return projetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projet with ID " + id + " not found"));
    }

    @Override
    public Projet createProject(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public Projet updateProject(Long id, Projet updatedProjet) {
        return projetRepository.findById(id)
                .map(existingProjet -> {
                    existingProjet.setNomProjet(updatedProjet.getNomProjet());
                    existingProjet.setDescriptionProjet(updatedProjet.getDescriptionProjet());
                    existingProjet.setDateDebutProjet(updatedProjet.getDateDebutProjet());
                    existingProjet.setDateFinProjet(updatedProjet.getDateFinProjet());
                    existingProjet.setEtatProjet(updatedProjet.getEtatProjet());
                    return projetRepository.save(existingProjet);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Projet with ID " + id + " not found"));
    }

    @Override
    public void deleteProject(Long id) {
        projetRepository.findById(id).ifPresentOrElse(
                projetRepository::delete,
                () -> {
                    throw new ResourceNotFoundException("Projet with ID " + id + " not found");
                }
        );
    }
}
