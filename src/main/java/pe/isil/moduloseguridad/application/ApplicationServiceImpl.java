package pe.isil.moduloseguridad.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public ApplicationDTO addApplication(Application application) {
        Optional<Application> applicationToAdd = applicationRepository.findApplicationByName(application.getName());
        if (applicationToAdd.isPresent()) {
            return ApplicationDTO.whenApplicationNameAlreadeyExists();
        } else {
            applicationRepository.save(application);
            return ApplicationDTO.whenApplicationRegistrationSucced();
        }
    }

    @Override
    public Application findApplicationByName(String name) {
        Optional<Application> applicationToFind = applicationRepository.findApplicationByName(name);
        return applicationToFind.orElse(null);
    }

    @Override
    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    @Override
    public ApplicationDTO updateApplication(Application application, Long id) {
        try {
            Optional<Application> applicationToUpdate = applicationRepository.findById(id);
            if (applicationToUpdate.isPresent()) {
                applicationToUpdate.get().setName(application.getName() != null ? application.getName() : applicationToUpdate.get().getName());
                applicationToUpdate.get().setDataBase(application.getDataBase() != null ? application.getDataBase() : applicationToUpdate.get().getDataBase());
                applicationToUpdate.get().setLanguage(application.getLanguage() != null ? application.getLanguage() : applicationToUpdate.get().getLanguage());
                applicationToUpdate.get().setCreateUser(application.getCreateUser() != null ? application.getCreateUser() : applicationToUpdate.get().getCreateUser());
                applicationRepository.save(applicationToUpdate.get());
                return ApplicationDTO.whenApplicationRegistrationSucced();
            } else {
                return ApplicationDTO.whenError("Aplicación a actualizar no esta en la base de datos.");
            }
        } catch (Exception e) {
            return ApplicationDTO.whenError(e.getMessage());
        }
    }

    @Override
    public void deleteApplication(Long id) {
        Optional<Application> applicationToDelete = applicationRepository.findById(id);
        applicationToDelete.ifPresent(application -> applicationRepository.delete(application));

    }

    @Override
    public Application findApplicationById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }
}
