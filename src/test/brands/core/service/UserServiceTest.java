package brands.core.service;

import brands.core.entity.Address;
import brands.core.entity.Gender;
import brands.core.entity.User;
import brands.core.model.UserEditRequest;
import brands.core.repository.UserRepository;
import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(HierarchicalContextRunner.class)
public class UserServiceTest {
    protected static class Prepare {
        @InjectMocks
        protected UserService userService;

        @Mock
        protected UserRepository userRepository;

        @Captor
        public ArgumentCaptor<User> userCaptor;

        @Before
        public void setup() {
            initMocks(this);
        }
    }

    public User generateUser() {
        User user = new User();
        return user;
    }

    public Address generateAddress(String zip, String prefecture) {
        Address address = new Address(zip, prefecture);
        return address;
    }

    public class edit extends Prepare {
        private UserEditRequest generateUserEditRequest(String name, Integer age, Gender gender, Address address) {
            UserEditRequest request = new UserEditRequest(name, age, gender, address);
            return request;
        }

        /**
         * 住所が未入力のとき
         */
        @Test
        public void addressNull() {
            User user = generateUser();
            UserEditRequest request = generateUserEditRequest("ryo", 26, Gender.FREE, null);

            when(userRepository.findById(anyLong())).thenReturn(user);

            userService.edit(request, 1L);
            verify(userRepository).saveAndFlush(userCaptor.capture());

            User savedUser = userCaptor.getValue();
            assertThat(savedUser)
                    .extracting(User::getName, User::getAge, User::getGender)
                    .contains("ryo", 26, Gender.FREE);
            assertThat(savedUser.getAddress().getZip())
                    .isNull();
            assertThat(savedUser.getAddress().getPrefecture())
                    .isNull();
        }

        /**
         * 住所が入力されているとき
         */
        @Test
        public void addressNotNull() {
            User user = generateUser();
            Address address = generateAddress("100-0001", "神奈川県");
            UserEditRequest request = generateUserEditRequest("ryo", 26, Gender.FREE, address);

            when(userRepository.findById(anyLong())).thenReturn(user);

            userService.edit(request, 1L);
            verify(userRepository).saveAndFlush(userCaptor.capture());

            User savedUser = userCaptor.getValue();
            assertThat(savedUser)
                    .extracting(User::getName, User::getAge, User::getGender)
                    .contains("ryo", 26, Gender.FREE);
            assertThat(savedUser.getAddress())
                    .extracting(Address::getZip, Address::getPrefecture)
                    .contains("100-0001", "神奈川県");
        }
    }
}