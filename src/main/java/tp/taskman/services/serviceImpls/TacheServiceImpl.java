package tp.taskman.services.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.taskman.entities.Tache;
import tp.taskman.exceptions.ResourceNotFoundException;
import tp.taskman.repositories.TacheRepository;
import tp.taskman.services.TacheService;

import java.util.List;

@Service
public class TacheServiceImpl implements TacheService {

    @Autowired
    private TacheRepository tacheRepository;

    @Override
    public List<Tache> getAllTasks() {
        return tacheRepository.findAll();
    }

    @Override
    public Tache getTaskById(Long id) {
        return tacheRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID " + id + " not found"));
    }

    @Override
    public Tache createTask(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public Tache updateTask(Long id, Tache updatedTache) {
        return tacheRepository.findById(id)
                .map(existingTache -> {
                    existingTache.setNomTache(updatedTache.getNomTache());
                    existingTache.setDescriptionTache(updatedTache.getDescriptionTache());
                    existingTache.setPriorite(updatedTache.getPriorite());
                    existingTache.setEtatTache(updatedTache.getEtatTache());
                    existingTache.setDateDebutTache(updatedTache.getDateDebutTache());
                    existingTache.setDateEcheanceTache(updatedTache.getDateEcheanceTache());
                    return tacheRepository.save(existingTache);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID " + id + " not found"));
    }

    @Override
    public void deleteTask(Long id) {
        tacheRepository.findById(id).ifPresentOrElse(
                tacheRepository::delete,
                () -> {
                    throw new ResourceNotFoundException("Task with ID " + id + " not found");
                }
        );
    }
}
