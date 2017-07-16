package demo.kotlin;

/**
 * Created by gemhuang on 2017/7/16.
 */
public class GreenApple extends Apple {

    private Integer acidness;

    public GreenApple(String color, Integer sweetness, Integer acidness) {
        super(color, sweetness);

        this.acidness = acidness;
    }

    public Integer getAcidness() {
        return acidness;
    }

    public void setAcidness(Integer acidness) {
        this.acidness = acidness;
    }

    public String toString() {
        return super.toString() + "; acidness: " + acidness;
    }
}
