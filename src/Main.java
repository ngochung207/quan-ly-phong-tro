import java.time.ZoneId;
import java.util.Scanner;

public class Main {
    // Khởi tạo một nhà trọ có tên là ZoZo
    static Hotel ZoZo = new Hotel();

    public static void main(String[] args) {
        Integer chose = 0;
        String id = "";
        Scanner sc = new Scanner(System.in);
        do {
            showMenu();
            chose = Integer.parseInt(sc.nextLine());
            switch (chose) {
                case 1:
                    addNewCustomers();
                    break;
                case 2:
                    System.out.println("Nhập vào số CMT của khách: ");
                    id = sc.nextLine();
                    showInfoCustomersByID(id);
                    break;
                case 3:
                    showInfoAllCustomers();
                    break;
                case 4:
                    System.out.println("Nhập vào số CMT của khách: ");
                    id = sc.nextLine();
                    deleteInfoCustomers(id);
                    break;
                case 5:
                    payMent();
                    break;
                case 6:
                    System.out.println("Thoát khỏi chương trình");
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    static void showMenu() {
        System.out.println("------- Quản lý phòng trọ -------");
        System.out.println("01. Thêm mới khách trọ");
        System.out.println("02. Hiện thị thông tin khách trọ");
        System.out.println("03. Hiện thị toàn bộ thông tin khách trọ");
        System.out.println("04. Xóa thông tin khách trọ");
        System.out.println("05. Tính tiền phải thu khách trọ");
        System.out.println("06. Exit");
    }

    static void addNewCustomers() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tên khách: ");
        String name = sc.nextLine();
        System.out.println("Nhập vào năm sinh");
        String birth = sc.nextLine();
        System.out.println("Nhập vào CMT: ");
        String id = sc.nextLine();
        System.out.println("Nhập vào số ngày lưu trú: ");
        int countDays = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào loại phòng: ");
        String type = sc.nextLine();
        Customer newCustomer = new Customer(name, birth, id, countDays, type);
        // Thêm mới khách vào dữ liệu khách sạn
        ZoZo.addCustomer(newCustomer);
        sc.nextLine();
    }

    static void deleteInfoCustomers(String id) {
        showInfoCustomersByID(id);
        System.out.println("-----");
        ZoZo.deleteCustomer(id);
        System.out.println("Delete is Done");
    }

    static void payMent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số CMT của khách: ");
        String ID = sc.nextLine();
        System.out.println("Số tiền phải thanh toán: " + ZoZo.getPay(ID));
    }

    static void showInfoCustomersByID(String id) {
        // Lấy ra thông tin của một khách trọ dựa vào thông tin.
        System.out.println(ZoZo.toString(id));
    }

    static void showInfoAllCustomers() {
        // Lấy ra toàn bộ thông tin của khách trọ.
        System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s"
                , "Tên khách thuê"
                , "Ngày sinh"
                , "Số chứng minh thư"
                , "Ngày trọ"
                , "Loại phòng"
                , "Giá phòng");
        for (int i = 0; i < ZoZo.getSize(); i++) {
            Customer element = ZoZo.getElement(i);
            System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s",
                    element.getName(),
                    element.getBirth(),
                    element.getId(),
                    String.valueOf(element.getCountDays()),
                    element.getType(),
                    ZoZo.getPrice(element.getType()));
        }

        System.out.println("");
    }

}
