package HomeWork.Demo02;

public class OrderDetail {
    private int id;
    private String name;
    private int orderId;
    private int number;
    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderId=" + orderId +
                ", number=" + number +
                ", amount=" + amount +
                '}';
    }
}
