package pe.isil.moduloseguridad.service;

import pe.isil.moduloseguridad.model.User;
import java.util.List;

public interface UserService {
    List<User> getUsers();
}