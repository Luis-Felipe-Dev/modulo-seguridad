package pe.isil.moduloseguridad.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSecurityServiceImpl implements UserSecurityService {

    @Autowired
    private UserSecurityRepository userSecurityRepository;

    @Override
    public UserSecurity findUserSecurity(String email, String password) {

        Optional<UserSecurity> userToFind = userSecurityRepository.findUserSecurityByEmailAndPassword(email, password);

        if (userToFind.isPresent()) {
            return userToFind.get();
        } else {
            return null;
        }
    }

    @Override
    public UserSecurity addUserSecurity(UserSecurity user) {

        userSecurityRepository.save(user);
        return user;
    }
}
