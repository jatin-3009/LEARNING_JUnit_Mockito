import com.mockito.RepositoryManager;
import com.mockito.Student;
import javax.persistence.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryManagerTest {

    @Test
    public void getAllStudents() {
        EntityManager entityManagerMock = mock(EntityManager.class);
        RepositoryManager repositoryManager = new RepositoryManager(entityManagerMock);

        Student student1 = new Student(1, "Axel");
        Student student2 = new Student(2, "Meliodas");
        Student student3 = new Student(3, "Light");
        List<Student> studentList = Arrays.asList(student1, student2, student3);

        Query queryMock = mock(Query.class);
        when(entityManagerMock.createNamedQuery(RepositoryManager.GET_ALL_STUDENTS)).thenReturn(queryMock);
        when(queryMock.getResultList()).thenReturn(studentList);

        List<Student> actualStudents = repositoryManager.getAllStudents();
        assertThat(actualStudents, is(studentList));
    }
}
