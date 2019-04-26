public class Furniture {

    private String product;
    private int weight;
    private long price;

    public Furniture(String product, int weight, long price) {
        this.product = product;
        this.weight = weight;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
