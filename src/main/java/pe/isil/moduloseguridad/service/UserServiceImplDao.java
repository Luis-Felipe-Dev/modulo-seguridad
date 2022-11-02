package pe.isil.moduloseguridad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.moduloseguridad.dao.UserDao;
import pe.isil.moduloseguridad.model.User;

import java.util.List;

@Service("userServiceDao")
public class UserServiceImplDao implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return null;
    }
}