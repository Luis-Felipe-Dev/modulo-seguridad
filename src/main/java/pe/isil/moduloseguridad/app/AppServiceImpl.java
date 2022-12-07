package pe.isil.moduloseguridad.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.moduloseguridad.user.User;

import java.util.List;
import java.util.Set;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppRepository appRepository;

    @Override
    public List<Application> findAll() {
        return appRepository.findAll();
    }

    @Override
    public void mapUserApp(User user){

        Set<Application> apps = user.getApplications();

        Application app = apps.iterator().next();

    }

}