package pe.isil.moduloseguridad.application;

import java.util.List;

public interface ApplicationService {

    ApplicationDTO addApplication(Application application);

    Application findApplicationByName(String name);

    List<Application> findAll();

    ApplicationDTO updateApplication(Application application, Long id);

    void deleteApplication(Long id);

    Application findApplicationById(Long id);
}
