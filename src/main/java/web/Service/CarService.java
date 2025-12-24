package web.Service;

import org.springframework.stereotype.Service;
import web.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private List<Car> cars;

    public CarService() {
        cars = new ArrayList<>();
        cars.add(new Car("BMW", 5, "Black"));
        cars.add(new Car("Mercedes", 6, "White"));
        cars.add(new Car("Audi", 3, "Red"));
        cars.add(new Car("Toyota", 7, "Blue"));
        cars.add(new Car("Honda", 4, "Silver"));
    }

    public List<Car> getCars(int count) {
        if (count >= 5) {
            return cars;
        }
        return cars.subList(0, count);
    }
}
