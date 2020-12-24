import java.util.HashMap;
import java.util.Map;

// Chức năng thiết lập giá phòng
public class SetupPrice {
    private Map<String, Double> priceList;

    public SetupPrice() {
        priceList = new HashMap<String, Double>();
    }

    public void addPrice(String key, Double price) {
        priceList.put(key, price);
    }

    public Double getPrice(String type) {
        return priceList.get(type);
    }
}
