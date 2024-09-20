package course;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

import course.entity.Student;
import course.entity.User;
import course.repository.StudentRepository;
import course.repository.UserRepository;


@DataJpaTest
public class CrudbootApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void addUser() {
        User user = new User("testuser", "testuser", "USER");

        assertNull(user.getId());
        userRepository.save(user);
        assertNotNull(user.getId());
    }

    @Test
    public void addStudent() {
        Student student = new Student("Test", "Student", "IT", "test@test.com");

        studentRepository.save(student);
        Optional<Student> findStudent = studentRepository.findById(student.getId());
        assertTrue(findStudent.isPresent());
    }
}
