package tp.taskman.services;

import org.springframework.stereotype.Service;
import tp.taskman.entities.Tache;

import java.util.List;
@Service
public interface TacheService {
    List<Tache> getAllTasks();

    Tache getTaskById(Long id);

    Tache createTask(Tache tache);

    Tache updateTask(Long id, Tache tache);

    void deleteTask(Long id);
}
