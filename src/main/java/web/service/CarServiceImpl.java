package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> cars;

    public CarServiceImpl() {
        cars = new ArrayList<>();
        cars.add(new Car("BMW", 5, "Black"));
        cars.add(new Car("Mercedes", 6, "White"));
        cars.add(new Car("Audi", 3, "Red"));
        cars.add(new Car("Toyota", 7, "Blue"));
        cars.add(new Car("Honda", 4, "Silver"));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count >= 5) {
            return cars;
        }
        return cars.subList(0, count);
    }
}
