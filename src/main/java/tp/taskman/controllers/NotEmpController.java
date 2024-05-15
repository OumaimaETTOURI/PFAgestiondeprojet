package tp.taskman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.taskman.entities.NotEmp;
import tp.taskman.services.NotEmpService;

import java.util.List;

@RestController
@RequestMapping("/not-employees")
public class NotEmpController {

    private final NotEmpService notEmployeeService;

    @Autowired
    public NotEmpController(NotEmpService notEmployeeService) {
        this.notEmployeeService = notEmployeeService;
    }

    @GetMapping("/")
    public ResponseEntity<List<NotEmp>> getAllNotEmployees() {
        List<NotEmp> notEmployees = notEmployeeService.getAllNotEmp();
        return new ResponseEntity<>(notEmployees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotEmp> getNotEmployeeById(@PathVariable Long id) {
        NotEmp notEmployee = notEmployeeService.getNotEmpById(id);
        if (notEmployee != null) {
            return new ResponseEntity<>(notEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<NotEmp> createNotEmployee(@RequestBody NotEmp notEmployee) {
        NotEmp newNotEmployee = notEmployeeService.createNotEmp(notEmployee);
        return new ResponseEntity<>(newNotEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotEmp> updateNotEmployee(@PathVariable Long id, @RequestBody NotEmp notEmployee) {
        NotEmp updatedNotEmployee = notEmployeeService.updateNotEmp(id, notEmployee);
        return new ResponseEntity<>(updatedNotEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNotEmployee(@PathVariable Long id) {
        notEmployeeService.deleteNotEmp(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
