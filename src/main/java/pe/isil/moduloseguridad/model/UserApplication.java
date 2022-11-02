package pe.isil.moduloseguridad.model;

import javax.persistence.*;

@Entity
public class UserApplication {
    @EmbeddedId
    private UserApplicationKey id;

    @ManyToOne
    @MapsId("idApllication")
    @JoinColumn(name="application_id")
    private Application application;

    @ManyToOne
    @MapsId("idUser")
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="permission_id")
    private Permission permission;
}
