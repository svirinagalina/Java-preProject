package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Ivan", "Ivanov", "ivan@mail.ru");
        user1.setCar(new Car("BMW", 5));

        User user2 = new User("Petr", "Petrov", "petr@mail.ru");
        user2.setCar(new Car("Mercedes", 6));

        User user3 = new User("Anna", "Sidorova", "anna@mail.ru");
        user3.setCar(new Car("Audi", 3));

        // Пользователь без машины
        User user4 = new User("Maria", "Kuznetsova", "maria@mail.ru");

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
            System.out.println();
        }

        User owner = userService.findUserByCar("BMW", 5);
        System.out.println("Владелец BMW 5: " + owner.getFirstName() + " " + owner.getLastName());

        context.close();
    }
}
