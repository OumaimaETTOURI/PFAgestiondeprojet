package tp.taskman.services.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.taskman.entities.Commentaire;
import tp.taskman.exceptions.ResourceNotFoundException;
import tp.taskman.repositories.CommentaireRepository;
import tp.taskman.services.CommentaireService;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaireServiceImpl implements CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Override
    public List<Commentaire> getAllCommentaires() {
        return commentaireRepository.findAll();
    }

    @Override
    public Commentaire getCommentaireById(Long id) {
        Optional<Commentaire> optionalCommentaire = commentaireRepository.findById(id);
        return optionalCommentaire.orElseThrow(() -> new ResourceNotFoundException("Commentaire with ID " + id + " not found"));
    }

    @Override
    public Commentaire createCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }
    @Override
    public Commentaire updateCommentaire(Long id, Commentaire updatedCommentaire) {
        Optional<Commentaire> optionalCommentaire = commentaireRepository.findById(id);
        if (optionalCommentaire.isPresent()) {
            Commentaire existingCommentaire = optionalCommentaire.get();
            existingCommentaire.setContenuCommentaire(updatedCommentaire.getContenuCommentaire());
            existingCommentaire.setDateCommentaire(updatedCommentaire.getDateCommentaire());
            existingCommentaire.setAuteur(updatedCommentaire.getAuteur());
            return commentaireRepository.save(existingCommentaire);
        } else {
            throw new ResourceNotFoundException("Commentaire with ID " + id + " not found");
        }
    }

    @Override
    public void deleteCommentaire(Long id) {
        commentaireRepository.deleteById(id);
    }
}
