package tp.taskman.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "notemps")
@Getter
@Setter
public class NotEmp implements Serializable {

    @Id
    @GeneratedValue(generator = "NOTEMP_GENERATOR")
    @SequenceGenerator(
            name = "NOTEMP_GENERATOR",
            sequenceName = "NOTEMP_ID_SEQ",
            allocationSize = 1)
    @Column(name = "notemp_id")
    private Long idNotEmp;

    @Column(nullable = false)
    private String etatNotEmp;

    // Constructeur sans paramètre
    public NotEmp() {
    }
}
