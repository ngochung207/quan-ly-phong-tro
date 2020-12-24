import java.util.ArrayList;
import java.util.EmptyStackException;

public class Hotel {
    private ArrayList<Customer> database;
    private ListPrice listPrice = new ListPrice();

    public Hotel() {
        database = new ArrayList<>();
    }

    public void addCustomer(Customer element) {
        // Thêm mới khách trọ.
        database.add(element);
        System.out.println("---> " + element.getId() + " - " + element.getName() + " - " + " Thêm mới thành công <---");
    }


    public void deleteCustomer(String id) {
        // Xóa khách theo số chứng minh thư.
        database.remove(this.getID(id));
    }

    public double getPay(String id) {
        // Lấy thông tin thanh toán của người qua ID
        Customer element = getCustomerById(id);
        double result = element.getCountDays() * getPrice(element.getType());
        return result;
    }

    public String toString(String id) {
        // In ra màn hình thông tin của 1 khách hàng, dựa vào số ID truyền vào.
        int index = this.getID(id);
        Customer cus = this.database.get(index);
        String name = cus.getName();
        String birth = cus.getBirth();
        int days = cus.getCountDays();
        String type = cus.getType();
        Double price = getPrice(type);
        return "Tên: " + name + "\nSố CMT: " + id + "\nNgày sinh: " + birth + "\nLoại phòng: " + type + "\nSố ngày ở: " + days + "\nGía phòng: " + price;
    }

    public int getID(String id) {
        // Lấy ra vị trí lưu thông tin của khách trong mảng, dựa vào ID của khách.
        if (database.isEmpty()) {
            throw new EmptyStackException();
        }
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public Customer getCustomerById(String id) {
        // Lấy ra đối tượng dựa vào id trong database
        int index = getID(id);
        if (index != -1) {
            return database.get(index);
        }
        return null;
    }

    public Double getPrice(String type){
        return listPrice.getPrice(type);
    }
    public int getSize(){
        return database.size();
    }

    public Customer getElement(int index){
        if(this.getSize() < index){
            return null;
        }
        return database.get(index);
    }

}
