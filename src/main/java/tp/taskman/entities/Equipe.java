package tp.taskman.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "equipes")
@Getter
@Setter
public class Equipe implements Serializable {

    @Id
    @GeneratedValue(generator = "EQUIPE_GENERATOR")
    @SequenceGenerator(
            name = "EQUIPE_GENERATOR",
            sequenceName = "EQUIPE_ID_SEQ",
            allocationSize = 1)

    @Column(name = "equipe_id")
    private Long idEquipe;


    @Column(nullable = false)
    private String nomEquipe;

    @Column
    private String descriptionEquipe;

    @OneToMany(mappedBy = "equipe")
    private List<Employe> employes;

    @OneToMany(mappedBy = "equipe")
    private List<Projet> projets;

    public Equipe() {}
}
