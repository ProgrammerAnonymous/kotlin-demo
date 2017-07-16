package demo.kotlin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gemhuang on 2017/7/15.
 */
public class GenericListTest {

    public static void main(String[] args){
        List<Fruit> basket = new ArrayList<>();
        List<? extends Fruit> basket2 = new ArrayList<>();

        List<Apple> apples = new ArrayList<>();

        apples.add(new Apple("red", 15));
        apples.add(new Apple("green", 9));
        apples.add(new Apple("red", 16));

        // failed when bracket: List<? extends Fruit>
        basket.addAll(apples);

        basket2 = apples;

        basket.forEach(fruit -> System.out.println(fruit));

        // failed when bracket: List<Fruit>
        // backet = apples;
    }
}
