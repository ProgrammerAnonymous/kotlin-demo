package demo.kotlin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gemhuang on 2017/7/15.
 */
public class CustomContainerTest {

    public static void main(String[] args){
        Basket<Fruit> basket = new Basket<>();

        List<Apple> apples = new ArrayList<>();

        apples.add(new Apple("red", 15));
        apples.add(new Apple("green", 9));
        apples.add(new Apple("red", 16));

        apples.forEach(apple-> basket.put(apple));

        // failed putAll(items: List<T>)
        // basket.putAll(apples);

        // successed putAll(items: List<? extends T>)
        basket.putAll(apples);
    }
}
