package tp.taskman.services.serviceImpls;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.taskman.entities.Notification;
import tp.taskman.exceptions.ResourceNotFoundException;
import tp.taskman.repositories.NotificationRepository;
import tp.taskman.services.NotificationService;

import java.util.List;
@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired

    NotificationRepository notificationRepository;


    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification with ID " + id + " not found"));
    }

    @Override
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification updateNotification(Long id, Notification updatedNotification) {
        return notificationRepository.findById(id)
                .map(existingNotification -> {
                    existingNotification.setContenuNotification(updatedNotification.getContenuNotification());
                    existingNotification.setDateNotification(updatedNotification.getDateNotification());
                    existingNotification.setDestinataire(updatedNotification.getDestinataire());
                    existingNotification.setTypeNotification(updatedNotification.getTypeNotification());
                    return notificationRepository.save(existingNotification);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Notification with ID " + id + " not found"));
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.findById(id).ifPresentOrElse(
                notificationRepository::delete,
                () -> {
                    throw new ResourceNotFoundException("Notification with ID " + id + " not found");
                }
        );
    }
}
