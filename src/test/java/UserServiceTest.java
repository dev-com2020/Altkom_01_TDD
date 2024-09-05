import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Spy
    UserService userService = new UserService();

    @Test
    public void should_override_getUserName_with_spy(){
        doReturn("Mocked User").when(userService).getUserName();

        String result = userService.getUserGreeting();

        assertThat(result).isEqualTo("Hello Mocked User");
    }
}
