package pe.isil.moduloseguridad.model;

import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;

import javax.persistence.*;
import java.util.List;

@Table(name = "tbl_application")
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @Column(name = "database", nullable = false, length = 250)
    private String database;

    @OneToMany(mappedBy = "application", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserApplication> userApplications;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Column(name = "language", nullable = false, length = 250)
    private String language;
}
