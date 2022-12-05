package pe.isil.moduloseguridad.application;

import lombok.Data;
import pe.isil.moduloseguridad.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_app", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "unique_name_app")
})
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String dataBase;

    private String language;

    private LocalDate createDate = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "create_user")
    private User createUser;
}
