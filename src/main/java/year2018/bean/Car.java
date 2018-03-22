package year2018.bean;

/**
 * @author likun
 * @version V1.0
 * @Title: year2018.bean
 * @date 2018/2/23 11:33
 */
public class Car {

    private String brand;

    private String color;

    public Car(){

    }

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public void introduce(){
        System.out.println("brand:" + brand + ";color:" + color);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
