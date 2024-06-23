package tp.taskman.services;

import org.springframework.stereotype.Service;
import tp.taskman.entities.Equipe;
@Service
public interface EquipeService {
    boolean deleteEquipe(Long id);

    Equipe updateEquipe(Long id, Equipe equipe);

    Equipe createEquipe(Equipe equipe);

    Equipe getEquipeById(Long id);
}
