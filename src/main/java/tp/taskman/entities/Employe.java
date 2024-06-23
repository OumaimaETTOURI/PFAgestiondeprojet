package tp.taskman.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tp.taskman.enums.TypeEmploye;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "employes")
@Getter
@Setter
public class Employe implements Serializable {

    @Id
    @GeneratedValue(generator = "EMPLOYE_GENERATOR")
    @SequenceGenerator(
            name = "EMPLOYE_GENERATOR",
            sequenceName = "EMPLOYE_ID_SEQ",
            allocationSize = 1)
    @Column(name = "employe_id")
    private Long idEmploye;

    @Column(nullable = false)
    private String nomEmploye;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String motDePasse;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeEmploye typeEmploye;

    @OneToMany(mappedBy = "employe")
    private List<Tache> taches;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

    @ManyToOne
    @JoinColumn(name = "projet_id")
    private Projet projet;

    // Constructeur sans paramètres
    public Employe() {
    }
}
