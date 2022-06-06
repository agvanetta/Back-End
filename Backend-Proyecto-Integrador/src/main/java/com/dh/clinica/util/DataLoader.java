package com.dh.clinica.util;
import com.dh.clinica.persistence.entity.Paciente;
import com.dh.clinica.persistence.entity.users.User;
import com.dh.clinica.persistence.entity.users.UserRoles;
import com.dh.clinica.persistence.repository.IPacienteRepository;
import com.dh.clinica.persistence.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;


@Component
public class DataLoader implements ApplicationRunner {
    private IUserRepository userRepository;

    @Autowired
    public DataLoader(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("user");
        String password2 = passwordEncoder.encode("admin");

        userRepository.save(new User("user", "user","user@gmail.com",password, UserRoles.USER));
        userRepository.save(new User("admin", "admin","admin@example.com",password2, UserRoles.ADMIN));

    }
}
