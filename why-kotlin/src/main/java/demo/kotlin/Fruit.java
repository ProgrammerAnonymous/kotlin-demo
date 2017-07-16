package demo.kotlin;

/**
 * Created by gemhuang on 2017/7/15.
 */
public class Fruit {

    private String color;

    public Fruit(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        return "color: " + this.color;
    }
}
