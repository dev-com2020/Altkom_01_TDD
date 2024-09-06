public class Order2 {

    private double total;
    private String membership;

    public Order2(double total, String membership) {
        this.total = total;
        this.membership = membership;
    }


    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public String getMembership() {
        return membership;
    }
}
