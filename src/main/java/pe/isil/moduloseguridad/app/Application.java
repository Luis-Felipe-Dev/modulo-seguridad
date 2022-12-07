package pe.isil.moduloseguridad.app;

import lombok.Data;
import pe.isil.moduloseguridad.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tbl_app")
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String db_description;

    private String language_description;

    private Date createdAt;

    private String createdBy;


    @ManyToMany
    @JoinTable(name = "tbl_app_user",
            joinColumns = @JoinColumn(name = "app_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();


    @PostPersist
    public void updateCreatedAt(){
        createdAt = new Date();
        createdBy = "admin";
    }

}