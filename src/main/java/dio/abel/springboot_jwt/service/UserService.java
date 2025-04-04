package dio.abel.springboot_jwt.service;

import dio.abel.springboot_jwt.model.User;
import dio.abel.springboot_jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public ResponseEntity<?> createUser(User user) {
        if (this.repository.existsByUsername(user.getUsername()))
            throw new RuntimeException("this user already exists");

        var password = user.getPassword();

        user.setPassword(encoder.encode(password));

        User newUser = this.repository.save(user);

        return ResponseEntity.ok(newUser);
    }
}
