package brands.core.service;

import brands.core.entity.Address;
import brands.core.entity.User;
import brands.core.model.UserCreateRequest;
import brands.core.model.UserEditRequest;
import brands.core.model.UserSearchRequest;
import brands.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public List<User> searchUsers(UserSearchRequest request) {
        return userRepository.search(request);
    }

    public User searchUser(long id) {
        return userRepository.findById(id);
    }

    public User create(UserCreateRequest request) {
        User user = User.generateUser(request);
        return userRepository.saveAndFlush(user);
    }

    public User edit(UserEditRequest request, long id) {
        User user = userRepository.findById(id);
        user.setName(request.getName());
        user.setAge(request.getAge());
        user.setGender(request.getGender());

        if (request.getAddress() != null) {
            Address address = new Address();
            address.setZip(request.getAddress().getZip());
            address.setPrefecture(request.getAddress().getPrefecture());
            user.setAddress(address);
        }

        return userRepository.saveAndFlush(user);
    }

    public String deleteUser(Long id){
        User user = userRepository.findById(id);
        userRepository.delete(user);
        return user.getName();
    }
}
