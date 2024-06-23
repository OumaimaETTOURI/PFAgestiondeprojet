package tp.taskman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.taskman.entities.Tache;

public interface TacheRepository extends JpaRepository<Tache, Long> {
    @Override
    boolean existsById(Long aLong);
}
