package tp.taskman.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tp.taskman.enums.EtatProjet;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projets")
@Getter
@Setter
public class Projet implements Serializable {

    @Id
    @GeneratedValue(generator = "PROJET_GENERATOR")
    @SequenceGenerator(
            name = "PROJET_GENERATOR",
            sequenceName = "PROJET_ID_SEQ",
            allocationSize = 1)
    @Column(name = "projet_id")
    private Long idProjet;


    @Column(nullable = false)
    private String nomProjet;

    @Column(nullable = false)
    private String descriptionProjet;

    @Column(nullable = false)
    private Date dateDebutProjet;

    @Column(nullable = false)
    private Date dateFinProjet;

    @Column(nullable = false)
    private EtatProjet etatProjet;

    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;

    @OneToMany(mappedBy = "projet")
    private List<Tache> taches;

    @OneToMany(mappedBy = "projet")
    private List<Employe> members;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

    // Constructeur sans paramètres
    public Projet() {
    }
}
