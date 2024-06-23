package tp.taskman.services;

import org.springframework.stereotype.Service;
import tp.taskman.entities.Employe;
@Service
public interface EmployeService {
    Employe getEmployeById(Long id);

    Employe createEmploye(Employe employe);

    Employe updateEmploye(Long id, Employe employe);

    boolean deleteEmploye(Long id);
}
