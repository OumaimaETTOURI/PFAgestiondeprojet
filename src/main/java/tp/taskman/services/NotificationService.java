package tp.taskman.services;

import org.springframework.stereotype.Service;
import tp.taskman.entities.Notification;

import java.util.List;
@Service
public interface NotificationService {
    List<Notification> getAllNotifications();

    Notification getNotificationById(Long id);

    Notification createNotification(Notification notification);

    Notification updateNotification(Long id, Notification notification);

    void deleteNotification(Long id);
}
