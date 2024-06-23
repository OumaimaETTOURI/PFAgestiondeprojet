package tp.taskman.services.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.taskman.entities.Employe;
import tp.taskman.exceptions.ResourceNotFoundException;
import tp.taskman.repositories.EmployeRepository;
import tp.taskman.services.EmployeService;

@Service
public class EmployeServiceImpl implements EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employe with ID " + id + " not found"));
    }

    @Override
    public Employe createEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe updateEmploye(Long id, Employe updatedEmploye) {
        return employeRepository.findById(id)
                .map(existingEmploye -> {
                    existingEmploye.setNomEmploye(updatedEmploye.getNomEmploye());
                    existingEmploye.setEmail(updatedEmploye.getEmail());
                    existingEmploye.setMotDePasse(updatedEmploye.getMotDePasse());
                    existingEmploye.setTypeEmploye(updatedEmploye.getTypeEmploye());
                    return employeRepository.save(existingEmploye);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Employe with ID " + id + " not found"));
    }

    @Override
    public boolean deleteEmploye(Long id) {
        return employeRepository.findById(id)
                .map(existingEmploye -> {
                    employeRepository.delete(existingEmploye);
                    return true;
                })
                .orElseThrow(() -> new ResourceNotFoundException("Employe with ID " + id + " not found"));
    }
}
