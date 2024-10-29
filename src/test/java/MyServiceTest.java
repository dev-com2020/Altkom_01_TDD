import org.codehaus.plexus.util.cli.Arg;
import org.eclipse.aether.graph.Dependency;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class MyServiceTest {
    @Test
    public void testExample(){
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        Dependency dependencyMock = mock(Dependency.class);

        when(dependencyMock.getScope()).thenReturn(null);
//        when(dependencyMock.getScope()).thenThrow(new RuntimeException("error!"));


        String result = dependencyMock.getScope();

//        verify(dependencyMock, times(1)).getScope();
//        verify(dependencyMock).getScope(captor.capture());

        assertNull(result);
        assertEquals("test", captor.getValue());
    }
}
