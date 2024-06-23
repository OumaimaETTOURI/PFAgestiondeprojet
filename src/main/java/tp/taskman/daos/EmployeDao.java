package tp.taskman.daos;

import lombok.Getter;
import lombok.Setter;
import tp.taskman.entities.Employe;
import tp.taskman.entities.Projet;
import tp.taskman.entities.Tache;
import tp.taskman.enums.TypeEmploye;
import java.util.List;

@Getter
@Setter
public class EmployeDao {
    private Long idEmploye;
    private String nomEmploye;
    private String email;
    private String motDePasse;
    private TypeEmploye typeEmploye;
    private List<Projet> projets;
    private List<Tache> taches;
    public EmployeDao() {}
}
