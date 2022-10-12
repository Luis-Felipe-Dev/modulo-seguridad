package pe.isil.moduloseguridad.service;

import org.springframework.stereotype.Service;
import pe.isil.moduloseguridad.model.User;

import java.time.LocalDate;
import java.util.List;

@Service("userServiceLocal")
public class UserServiceImpl implements UserService{
    @Override
    public List<User> getUsers() {
        User user1 = new User(
                1,
                "Andrea",
                "Zuñiga",
                "andre@isil.pe",
                "123456",
                LocalDate.of(1990,05,4)
        );
        User user2 = new User(
                2,
                "Jose",
                "Garcia",
                "jose@isil.pe",
                "123456",
                LocalDate.of(1978,12,18)
        );
        User user3 = new User(
                3,
                "Mariana",
                "Guardiola",
                "mariana@isil.pe",
                "123456",
                LocalDate.of(1992,9,5)
        );
        User user4 = new User(
                4,
                "Joey",
                "Soto",
                "joey@isil.pe",
                "123456",
                LocalDate.of(2000,1,18)
        );

        return List.of(user1,user2,user3,user4);
    }
}