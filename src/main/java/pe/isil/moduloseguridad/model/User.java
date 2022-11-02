package pe.isil.moduloseguridad.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "tbl_user",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}, name = "user_email_unique")
        })
@Entity
public class User {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    @Column(name = "lastname", nullable = true, length = 200)
    private String lastname;
    @Column(name = "email", nullable = false, length = 200)
    private String email;
    @Column(name = "photo_url", nullable = true, length = 500)
    private String photoUrl;

    @OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserApplication> userApplications;

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}