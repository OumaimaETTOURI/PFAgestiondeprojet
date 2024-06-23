package tp.taskman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.taskman.entities.Fichier;

public interface FichierRepository extends JpaRepository<Fichier, Long> {
    @Override
    boolean existsById(Long aLong);
}
