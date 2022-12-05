package pe.isil.moduloseguridad.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private String code;
    private String message;
    private Object data;

    public static UserDTO whenUserEmailAlreadeyExists() {
        return UserDTO.builder()
                .code("500")
                .message("Correo ya existe.")
                .build();
    }

    public static UserDTO whenUserRegistrationSucced() {
        return UserDTO.builder()
                .code("200")
                .message("Usuario registrado correctamente")
                .build();
    }

    public static UserDTO whenError(String message) {
        return UserDTO.builder()
                .code("500")
                .message("Ocurrio un error ".concat(message))
                .build();
    }
}
