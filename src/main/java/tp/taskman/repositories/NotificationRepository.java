package tp.taskman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.taskman.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    @Override
    boolean existsById(Long aLong);
}
