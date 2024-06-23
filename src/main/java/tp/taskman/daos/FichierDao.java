package tp.taskman.daos;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.jdbc.Size;
import tp.taskman.entities.Projet;
import tp.taskman.entities.Tache;

@Getter
@Setter
public class FichierDao {
    private Long idFichier;
    private String nomFichier;
    private String typeFichier;
    private Size tailleFichier;
    private String contenuFichier;
    private String chemin;
    private Projet projet;
    private Tache tache;
    private FichierDao() {}
}
