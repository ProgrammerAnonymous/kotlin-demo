package demo.kotlin

/**
 * Created by gemhuang on 2017/7/16.
 */

class KtFarm<T> {
    val farm = mutableListOf<T>()

    fun plant(seed: T) {
        farm.add(seed)
    }

    fun harvest(): T {
        return farm.removeAt(farm.lastIndex)
    }

    fun isEmpty(): Boolean{
        return farm.isEmpty()
    }

    fun plantAll(seeds: Collection<out T>) {
        farm.addAll(seeds)
    }

    fun harvestAll(container: MutableCollection<in T>) {
        container.addAll(farm)
    }
}