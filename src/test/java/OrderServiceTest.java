import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    User2Service user2Service;

    @Mock
    PaymentService paymentService;

    @InjectMocks
    OrderService orderService;

    @Test
    public void should_create_order_when_payment_is_successful(){
        User user = new User("Jan Kowalski");
        when(user2Service.getUserById(1L)).thenReturn(user);
        when(paymentService.processPayment(user,100.0)).thenReturn(true);

        Order order = (Order) orderService.createOrder(1L,100.0);

        assertThat(order).isNotNull();
        assertThat(order.getUser()).isEqualTo(user);
        assertThat(order.getAmmount()).isEqualTo(100.0);
    }

}