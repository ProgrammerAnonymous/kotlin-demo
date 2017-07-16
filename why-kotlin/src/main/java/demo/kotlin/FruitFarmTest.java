package demo.kotlin;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by gemhuang on 2017/7/16.
 */
public class FruitFarmTest {
    public static void main(String[] args) {
        FruitFarm<Apple> appleFarm = new FruitFarm<>();

        Collection<Apple> appleSeeds = new ArrayList<>();

        appleSeeds.add(new Apple("red", 15));
        appleSeeds.add(new GreenApple("green", 9, 12));

        appleFarm.plantAllSeeds(appleSeeds);

        Collection<Apple> appleContainer = new ArrayList<>();

        appleFarm.harvestAllFruits(appleContainer);

        appleContainer.forEach(apple -> System.out.println(apple));
    }
}
