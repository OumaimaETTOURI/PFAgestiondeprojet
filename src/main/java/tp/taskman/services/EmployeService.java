package tp.taskman.services;

import tp.taskman.entities.Employe;

public interface EmployeService {
    Employe getEmployeById(Long id);

    Employe createEmploye(Employe employe);

    Employe updateEmploye(Long id, Employe employe);

    boolean deleteEmploye(Long id);
}
