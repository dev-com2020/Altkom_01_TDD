import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankAccountServiceTest2 {

    @Mock
    BankAccountService bankAccountService;

    @Test
    public void should_change_balance_based_on_transacions(){

        when(bankAccountService.getBalance())
                .thenReturn(100.0)
                .thenReturn(150.0);


        assertThat(bankAccountService.getBalance()).isEqualTo(100.0);
        assertThat(bankAccountService.getBalance()).isEqualTo(150.0);


    }
}
