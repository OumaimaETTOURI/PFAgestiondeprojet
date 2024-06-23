package tp.taskman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.taskman.entities.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
    @Override
    boolean existsById(Long aLong);
}
