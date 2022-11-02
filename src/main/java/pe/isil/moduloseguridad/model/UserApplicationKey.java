package pe.isil.moduloseguridad.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserApplicationKey implements Serializable {

    @Column(name="user_id")
    private Long idUser;

    @Column(name="application_id")
    private Long idApplication;
}
