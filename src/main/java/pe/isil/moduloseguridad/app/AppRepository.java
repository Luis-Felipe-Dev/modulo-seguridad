package pe.isil.moduloseguridad.app;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<Application,Long> {
}