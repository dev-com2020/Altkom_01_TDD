import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderSteps {

    private Order2 order;
    private OrderService2 orderService = new OrderService2();

//    @Given("a customer with {string} membership")
//    public void aCustomerWithMembership(String membership){
//        order = new Order2(100.0, membership);
//    }

    @Given("a customer with {string} membership")
    public void aCustomerWithMembershipMembership(String membership) {
        order = new Order2(100.0, membership);
    }

    @When("the customer places an order worth {double}")
    public void theCustomerPlacesAnOrderWorth(double total){
        order.setTotal(total);
    }
    @Then("the total price should be {double}")
    public void theTotalPriceShouldBe(double expectedTotal){
        orderService.applyDiscount(order);
        assertEquals(expectedTotal, order.getTotal(), 0.01);
    }


}
