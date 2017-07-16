package demo.kotlin;

/**
 * Created by gemhuang on 2017/7/15.
 */
public class CovariantArrayTest {
    public static void main(String[] args){
        Fruit[] fruits = new Fruit[3];
        Apple[] apples = new Apple[3];

        apples[0] = new Apple("red", 15);
        apples[1] = new Apple("green", 9);
        apples[2] = new Apple("red", 16);

        // arrays are covariant!
        fruits = apples;
    }
}
