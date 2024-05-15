package tp.taskman.services;

import tp.taskman.entities.Tache;

import java.util.List;

public interface TacheService {
    List<Tache> getAllTasks();

    Tache getTaskById(Long id);

    Tache createTask(Tache tache);

    Tache updateTask(Long id, Tache tache);

    void deleteTask(Long id);
}
