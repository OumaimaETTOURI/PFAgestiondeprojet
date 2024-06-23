package tp.taskman.services.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.taskman.entities.Equipe;
import tp.taskman.exceptions.ResourceNotFoundException;
import tp.taskman.repositories.EquipeRepository;
import tp.taskman.services.EquipeService;

import java.util.Optional;

@Service
public class EquipeServiceImpl implements EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    @Override
    public Equipe getEquipeById(Long id) {
        return equipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipe with ID " + id + " not found"));
    }

    @Override
    public Equipe createEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public Equipe updateEquipe(Long id, Equipe updatedEquipe) {
        return equipeRepository.findById(id)
                .map(existingEquipe -> {
                    existingEquipe.setNomEquipe(updatedEquipe.getNomEquipe());
                    existingEquipe.setDescriptionEquipe(updatedEquipe.getDescriptionEquipe());
                    return equipeRepository.save(existingEquipe);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Equipe with ID " + id + " not found"));
    }

    @Override
    public boolean deleteEquipe(Long id) {
        return equipeRepository.findById(id)
                .map(existingEquipe -> {
                    equipeRepository.delete(existingEquipe);
                    return true;
                })
                .orElseThrow(() -> new ResourceNotFoundException("Equipe with ID " + id + " not found"));
    }
}
