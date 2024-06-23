package tp.taskman.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import tp.taskman.entities.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    @Override
    boolean existsById(Long aLong);
}
