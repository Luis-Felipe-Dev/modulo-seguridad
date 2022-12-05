package pe.isil.moduloseguridad.application;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationDTO {

    private String code;
    private String message;
    private Object data;

    public static ApplicationDTO whenApplicationNameAlreadeyExists() {
        return ApplicationDTO.builder()
                .code("500")
                .message("Aplicación ya existe.")
                .build();
    }

    public static ApplicationDTO whenApplicationRegistrationSucced() {
        return ApplicationDTO.builder()
                .code("200")
                .message("Aplicación registrada correctamente")
                .build();
    }

    public static ApplicationDTO whenError(String message) {
        return ApplicationDTO.builder()
                .code("500")
                .message("Ocurrio un error ".concat(message))
                .build();
    }
}
