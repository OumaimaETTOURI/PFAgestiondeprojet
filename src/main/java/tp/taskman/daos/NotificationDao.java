package tp.taskman.daos;

import lombok.Getter;
import lombok.Setter;
import tp.taskman.entities.Employe;
import java.util.Date;

@Getter
@Setter
public class NotificationDao {
    private Long idNotification;
    private String contenuNotification;
    private Date dateNotification;
    private Employe destinataire;
    private String typeNotification;
    private NotificationDao() {}
}
