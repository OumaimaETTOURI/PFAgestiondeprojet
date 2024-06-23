package tp.taskman.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.jdbc.Size;

import java.io.Serializable;

@Entity
@Table(name = "fichiers")
@Getter
@Setter
public class Fichier implements Serializable {

    @Id
    @GeneratedValue(generator = "FICHIER_GENERATOR")
    @SequenceGenerator(
            name = "FICHIER_GENERATOR",
            sequenceName = "FICHIER_ID_SEQ",
            allocationSize = 1)
    @Column(name = "fichier_id")
    private Long idFichier;

    @Column(nullable = false)
    private String nomFichier;

    @Column(nullable = false)
    private String typeFichier;

    @Column(nullable = false)
    private Size tailleFichier;

    @Column(nullable = false)
    private String contenuFichier;

    @Column(nullable = false)
    private String chemin;

    @ManyToOne
    @JoinColumn(name = "projet_id")
    private Projet projet;

    @ManyToOne
    @JoinColumn(name = "tache_id")
    private Tache tache;

    // Constructeur sans paramètres
    public Fichier() {
    }
}
