package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        userService.add(new User("User1", "Lastname1", "user1@mail.ru"), new Car("BMW", 535));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"), new Car("Mercedes-Benz", 600));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"), new Car("AUDI", 7));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"), new Car("Tesla", 3));


        List<User> users = userService.listUsers();
        users.forEach(user -> System.out.println(user.toString()));
        System.out.println(userService.getUserByCar("AUDI", 7).toString());
        context.close();
    }
}
