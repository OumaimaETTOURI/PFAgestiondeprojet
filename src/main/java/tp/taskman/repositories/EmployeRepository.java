package tp.taskman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.taskman.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    @Override
    boolean existsById(Long aLong);
}
