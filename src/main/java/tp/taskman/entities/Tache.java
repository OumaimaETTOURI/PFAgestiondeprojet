package tp.taskman.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tp.taskman.enums.EtatTache;
import tp.taskman.enums.Priorite;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "taches")
@Getter
@Setter
public class Tache implements Serializable {

    @Id
    @GeneratedValue(generator = "TACHE_GENERATOR")
    @SequenceGenerator(
            name = "TACHE_GENERATOR",
            sequenceName = "TACHE_ID_SEQ",
            allocationSize = 1)
    @Column(name = "tache_id")
    private Long idTache;

    @Column(nullable = false)
    private String nomTache;

    @Column(nullable = false)
    private String descriptionTache;

    @Column(nullable = false)
    private Priorite priorite;

    @Column(nullable = false)
    private EtatTache etatTache;

    @Column(nullable = false)
    private Date dateDebutTache;

    @Column(nullable = false)
    private Date dateEcheanceTache;

    @OneToMany(mappedBy = "tache")
    private List<Commentaire> commentaires;

    @OneToMany(mappedBy = "tache")
    private List<Fichier> fichiers;

    @ManyToOne
    @JoinColumn(name = "projet_id", nullable = false)
    private Projet projet;

    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;

    // Constructeur sans paramètres
    public Tache() {
    }
}
