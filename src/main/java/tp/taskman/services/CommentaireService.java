package tp.taskman.services;

import org.springframework.stereotype.Service;
import tp.taskman.entities.Commentaire;

import java.util.List;
@Service
public interface CommentaireService {
    List<Commentaire> getAllCommentaires();

    Commentaire getCommentaireById(Long id);

    Commentaire createCommentaire(Commentaire commentaire);

    Commentaire updateCommentaire(Long id, Commentaire commentaire);

    void deleteCommentaire(Long id);
}
