package tp.taskman.daos;

import lombok.Getter;
import lombok.Setter;
import tp.taskman.entities.Commentaire;
import tp.taskman.entities.Employe;
import tp.taskman.entities.Fichier;
import tp.taskman.enums.EtatTache;
import tp.taskman.enums.Priorite;

import java.util.Date;
import java.util.List;
@Setter
@Getter
public class TacheDao {
    private Long idTache;
    private String nomTache;
    private String descriptionTache;
    private Priorite priorite;
    private EtatTache etatTache;
    private Date dateDebutTache;
    private Date dateEcheanceTache;
    private Employe membreAssigne;
    private List<Commentaire> commentaires;
    private List<Fichier> fichiers;
    private TacheDao(){}
}
