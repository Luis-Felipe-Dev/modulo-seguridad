package pe.isil.moduloseguridad.user;

import lombok.Data;
import pe.isil.moduloseguridad.app.Application;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name="email", length = 100)
    private String email;

    private String urlPhoto;

    @ManyToMany(mappedBy = "users")
    private Set<Application> applications = new HashSet<>();
}
