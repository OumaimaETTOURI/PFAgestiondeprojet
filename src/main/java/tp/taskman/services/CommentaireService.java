package tp.taskman.services;

import tp.taskman.entities.Commentaire;

import java.util.List;

public interface CommentaireService {
    List<Commentaire> getAllCommentaires();

    Commentaire getCommentaireById(Long id);

    Commentaire createCommentaire(Commentaire commentaire);

    Commentaire updateCommentaire(Long id, Commentaire commentaire);

    void deleteCommentaire(Long id);
}
