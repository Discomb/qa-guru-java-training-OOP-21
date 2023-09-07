package guru.qa.data;

import guru.qa.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUsername(String username);

    class MockUserRepository implements UserRepository {
        @Override
        public Optional<User> findByUsername(String username) {

            if ("name".equals(username)) {
                return Optional.of(
                        new User("name", "12345")
                );
            }

            return Optional.empty();
        }
    }
}
