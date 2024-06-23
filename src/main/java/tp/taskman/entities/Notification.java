package tp.taskman.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "notifications")
@Getter
@Setter
public class Notification implements Serializable {

    @Id
    @GeneratedValue(generator = "NOTIFICATION_GENERATOR")
    @SequenceGenerator(
            name = "NOTIFICATION_GENERATOR",
            sequenceName = "NOTIFICATION_ID_SEQ",
            allocationSize = 1)
    @Column(name = "notification_id")
    private Long idNotification;

    @Column(nullable = false)
    private String contenuNotification;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNotification;

    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe destinataire;

    @Column(nullable = false)
    private String typeNotification;

    // Constructeur sans paramètres
    public Notification() {
    }
}
