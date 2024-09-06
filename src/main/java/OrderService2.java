public class OrderService2 {

    public void applyDiscount(Order2 order) {
        switch (order.getMembership()){
            case "Bronze":
                order.setTotal(order.getTotal() * 0.9);
                break;
            case "Silver":
                order.setTotal(order.getTotal() * 0.8);
                break;
            case "Gold":
                order.setTotal(order.getTotal() * 0.7);
                break;
                default:
                    throw new IllegalArgumentException("Invalid membership type");
        }
    }
}
