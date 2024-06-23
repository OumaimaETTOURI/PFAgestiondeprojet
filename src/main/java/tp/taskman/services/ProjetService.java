package tp.taskman.services;

import org.springframework.stereotype.Service;
import tp.taskman.entities.Projet;

import java.util.List;
@Service
public interface ProjetService {
    List<Projet> getAllProjects();

    Projet getProjectById(Long id);

    Projet createProject(Projet projet);

    Projet updateProject(Long id, Projet projet);

    void deleteProject(Long id);
}
