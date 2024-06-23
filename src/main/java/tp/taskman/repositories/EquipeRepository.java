package tp.taskman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.taskman.entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    @Override
    boolean existsById(Long aLong);
}
