public class Customer extends Person {
    private int countDays;
    private String type;

    public Customer() {
    }

    public Customer(String name, String birth, String id, int days, String type) {
        super(name, birth, id);
        this.countDays = days;
        this.type = type;
    }

    public int getCountDays() {
        return countDays;
    }

    public void setCountDays(int days) {
        this.countDays = days;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
