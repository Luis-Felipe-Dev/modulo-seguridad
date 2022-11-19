package pe.isil.moduloseguridad.auth;

public interface UserSecurityService {

    UserSecurity findUserSecurity(String email, String password);

    UserSecurity addUserSecurity(UserSecurity user);

}
