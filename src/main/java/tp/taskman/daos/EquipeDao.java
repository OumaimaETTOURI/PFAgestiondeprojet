package tp.taskman.daos;

import lombok.Getter;
import lombok.Setter;
import tp.taskman.entities.Employe;
import tp.taskman.entities.Projet;

import java.util.List;
@Getter
@Setter
public class EquipeDao {
    private Long idEquipe;
    private String nomEquipe;
    private String descriptionEquipe;
    private Long idEmploye;
    private List<Employe> employes;
    private List<Projet> projets;
    public EquipeDao() {}
}
