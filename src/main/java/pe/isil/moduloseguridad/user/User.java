package pe.isil.moduloseguridad.user;

import lombok.Data;
import pe.isil.moduloseguridad.application.Application;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email", name = "unique_email_user")
})
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    private String email;

    private String urlPhoto;

    @OneToMany(mappedBy = "createUser")
    private List<Application> applications;
}
