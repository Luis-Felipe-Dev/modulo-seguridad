package pe.isil.moduloseguridad.user;

import java.util.List;

public interface UserService {

    UserDTO addUser(User user);

    User findUserByEmail(String email);

    List<User> findAll();

    UserDTO updateUser(User user, Long id);

    void deleteUser(Long id);

    User findUserById(Long id);
}
