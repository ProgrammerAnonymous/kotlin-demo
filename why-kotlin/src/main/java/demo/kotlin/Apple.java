package demo.kotlin;

/**
 * Created by gemhuang on 2017/7/15.
 */
public class Apple extends Fruit {
    private Integer sweetness;

    public Apple(String color, Integer sweetness) {
        super(color);

        this.sweetness = sweetness;
    }

    public Integer getSweetness() {
        return sweetness;
    }

    public void setSweetness(Integer sweetness) {
        this.sweetness = sweetness;
    }

    public String toString() {
        return super.toString() + "; sweetness: " + this.sweetness;
    }
}
