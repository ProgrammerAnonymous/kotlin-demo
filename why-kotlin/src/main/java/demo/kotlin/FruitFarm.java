package demo.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by gemhuang on 2017/7/16.
 */
public class FruitFarm<E> {

    private List<E> farm;

    public FruitFarm() {
        farm = new ArrayList<>();
    }

    public E harvest() {
        return this.farm.remove(this.farm.size() - 1);
    }

    public void plant(E seed) {
        this.farm.add(seed);
    }

    public boolean isEmpty() {
        return this.farm.isEmpty();
    }

    public void plantAllSeeds(Collection<? extends E> seeds) {
        for (E seed : seeds) {
            farm.add(seed);
        }
    }

    public void harvestAllFruits(Collection<? super E> container) {
        for (E fruit : farm) {
            container.add(fruit);
        }
    }
}
