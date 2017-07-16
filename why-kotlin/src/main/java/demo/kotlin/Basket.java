package demo.kotlin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gemhuang on 2017/7/15.
 */
public class Basket<T> {
    private List<T> basket;

    public Basket() {
        basket = new ArrayList<>();
    }

    public void put(T item) {
        basket.add(item);
    }

    public T take() {
        return basket.get(basket.size() - 1);
    }

    public boolean isEmpty() {
        return basket.isEmpty();
    }

    public void putAll(List<? extends T> items){
        basket.addAll(items);
    }
}
