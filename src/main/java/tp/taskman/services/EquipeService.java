package tp.taskman.services;

import tp.taskman.entities.Equipe;

public interface EquipeService {
    boolean deleteEquipe(Long id);

    Equipe updateEquipe(Long id, Equipe equipe);

    Equipe createEquipe(Equipe equipe);

    Equipe getEquipeById(Long id);
}
