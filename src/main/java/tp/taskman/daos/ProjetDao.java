package tp.taskman.daos;

import lombok.Getter;
import lombok.Setter;
import tp.taskman.entities.Employe;
import tp.taskman.entities.Tache;
import tp.taskman.enums.EtatProjet;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class ProjetDao {
    private Long idProjet;
    private Long idEmploye;
    private String nomProjet;
    private String descriptionProjet;
    private Date dateDebutProjet;
    private Date dateFinProjet;
    private EtatProjet etatProjet;
    private List<Employe> membres;
    private List<Tache> taches;
    public ProjetDao() {}
}
