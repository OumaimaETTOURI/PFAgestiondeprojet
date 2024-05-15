package tp.taskman.services;

import tp.taskman.entities.NotEmp;

import java.util.List;

public interface NotEmpService {
    List<NotEmp> getAllNotEmp();

    NotEmp getNotEmpById(Long id);

    NotEmp createNotEmp(NotEmp notEmployee);

    NotEmp updateNotEmp(Long id, NotEmp notEmployee);

    void deleteNotEmp(Long id);
}
