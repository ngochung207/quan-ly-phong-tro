public class ListPrice {
    private SetupPrice priceList = new SetupPrice();
    public ListPrice(){
        priceList.addPrice("A",550000d);
        priceList.addPrice("B",450000d);
        priceList.addPrice("C",350000d);
        priceList.addPrice("D",250000d);
    }
    public Double getPrice(String type){
        return priceList.getPrice(type);
    }
}
