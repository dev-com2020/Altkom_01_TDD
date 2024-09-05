import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BankAccountServiceTest {

    @Mock
    BankAccountService bankAccountService; // Mockowanie serwisu

    @Test
    public void should_capture_balance_changes(){
        ArgumentCaptor<Double> depositCaptor = ArgumentCaptor.forClass(Double.class);

        bankAccountService.deposit(100);
        bankAccountService.deposit(50);

        verify(bankAccountService, times(2)).deposit(depositCaptor.capture());

        assertThat(depositCaptor.getAllValues()).containsExactly(100.0,50.0);
    }
}
