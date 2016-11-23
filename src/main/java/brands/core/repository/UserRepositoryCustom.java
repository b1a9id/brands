package brands.core.repository;

import brands.core.entity.User;
import brands.core.model.UserSearchRequest;

import java.util.List;

public interface UserRepositoryCustom {

	List<User> search(UserSearchRequest request);
}
