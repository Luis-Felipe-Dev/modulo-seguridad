package pe.isil.moduloseguridad.service;

import org.springframework.stereotype.Service;
import pe.isil.moduloseguridad.model.User;

import java.time.LocalDate;
import java.util.List;

@Service("userServiceLocal")
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getUsers() {
        return null;
    }
}