package org.moldavets.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierLambda {
    public static void main(String[] args) {

        List<Car> cars = testSupplier.createThreeCars(() ->
            new Car("VW","Black",2.0)
        );

        System.out.println(cars);
    }
}

class testSupplier {
    public static List<Car> createThreeCars(Supplier<Car> carSupplier) {
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            cars.add(carSupplier.get());
        }

        return cars;
    }
}