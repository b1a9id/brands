package brands.core.service;

import brands.core.entity.User;
import brands.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> allUsers() {
        return userRepository.findAll();
    }

}
