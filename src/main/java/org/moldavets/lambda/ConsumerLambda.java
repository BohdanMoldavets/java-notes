package org.moldavets.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerLambda {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("BMW", "black", 2.0));
        cars.add(new Car("Honda", "black", 2.0));
        cars.add(new Car("Audi", "black", 2.0));

        testConsumer.changeCar(cars.get(0), (Car car) -> {
            car.setEngine(3.0);
            car.setColor("white");
        });

        System.out.println(cars);

        testConsumer.changeCars(cars, (Car car) -> {
            car.setEngine(4.0);
            car.setColor("red");
        });

        System.out.println(cars);

    }


}
class testConsumer {

    public static void changeCar(Car car, Consumer<Car> consumer) {
        consumer.accept(car);
    }

    public static void changeCars(List<Car> cars, Consumer<Car> consumer) {
        cars.forEach(car -> consumer.accept(car));
//        cars.forEach(consumer);
    }


}