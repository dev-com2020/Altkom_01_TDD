import org.eclipse.aether.graph.Dependency;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class MySecondServiceTest {

    @Mock
    Dependency dependency;

    @InjectMocks
    MyService service;

    @Captor
    ArgumentCaptor<String> captor;

    @Test
    void exTest(){
        service.someMethod();
//        verify(dependency).getScope(captor.capture());
//        assertEquals("test",captor.getValue());
    }
}
