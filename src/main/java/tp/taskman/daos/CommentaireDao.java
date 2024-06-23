package tp.taskman.daos;
import lombok.Getter;
import lombok.Setter;
import tp.taskman.entities.Employe;
import java.util.Date;
@Setter
@Getter
public class CommentaireDao {
    private Long idCommentaire;
    private Employe auteur;
    private String contenuCommentaire;
    private Date dateCommentaire;
public CommentaireDao() {}

}



