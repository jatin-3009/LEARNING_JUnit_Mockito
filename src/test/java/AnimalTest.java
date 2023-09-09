import com.mockito.pojo.ZooKeeper;
import com.mockito.service.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {

    @Test
    public void testAnimal() {

        System.out.println("========== Returns Defaults ==========");

        Animal lion = mock(Animal.class);
        System.out.println(lion.getZooKeeper());
        System.out.println(lion.age);

        Animal lion2 = mock(Animal.class, RETURNS_DEFAULTS);
        System.out.println(lion2.getZooKeeper());
        System.out.println(lion2.age);

        System.out.println("========== Returns Smart Nulls ==========");

        Animal lion3 = mock(Animal.class, RETURNS_SMART_NULLS);
        System.out.println(lion3.getZooKeeper());
        System.out.println(lion3.age);

        System.out.println("========== Stubbed the getZooKeeper method ==========");

        ZooKeeper zooKeeperMock = new ZooKeeper("Escanor");
        Animal lion4 = mock(Animal.class, RETURNS_SMART_NULLS);
        when(lion4.getZooKeeper()).thenReturn(zooKeeperMock);
        System.out.println(lion4.getZooKeeper());
        System.out.println(lion4.getZooKeeper().getName());

        System.out.println("========== Returns Mocks ==========");

        Animal lion5 = mock(Animal.class, RETURNS_MOCKS);
        System.out.println(lion5.getZooKeeper());
        System.out.println(lion5.age);
        System.out.println("Name: " + lion5.getZooKeeper().getName());

        System.out.println("========== Returns Deep Stubs ==========");

        Animal lion6 = mock(Animal.class, RETURNS_DEEP_STUBS);
        when(lion6.getZooKeeper().getName()).thenReturn("Meliodas");
        System.out.println("Name: " + lion6.getZooKeeper().getName());

    }
}
