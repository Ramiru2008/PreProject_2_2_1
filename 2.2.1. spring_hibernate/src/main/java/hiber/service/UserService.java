package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    @Transactional
    void add(User user, Car car);

    User getUserByCar(String model, int series);
    List<User> listUsers();

}
