package tp.taskman.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "commentaires")
@Getter
@Setter
public class Commentaire implements Serializable {

    @Id
    @GeneratedValue(generator = "COMMENTAIRE_GENERATOR")
    @SequenceGenerator(
            name = "COMMENTAIRE_GENERATOR",
            sequenceName = "COMMENTAIRE_ID_SEQ",
            allocationSize = 1)
    @Column(name = "commentaire_id")
    private Long idCommentaire;

    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe auteur;

    @Column(nullable = false)
    private String contenuCommentaire;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommentaire;

    @ManyToOne
    @JoinColumn(name = "tache_id")
    private Tache tache;

    // Constructeur sans paramètres
    public Commentaire() {
    }
}
