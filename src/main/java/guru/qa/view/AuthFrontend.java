package guru.qa.view;

import guru.qa.data.UserRepository;
import guru.qa.domain.User;
import guru.qa.service.Session;
import guru.qa.service.UserSession;

import javax.swing.*;
import java.util.Optional;

public class AuthFrontend implements Frontend{

    private final UserRepository userRepository;
    private final Frontend[] onAuthRenderFrontends;

    public AuthFrontend(UserRepository userRepository, Frontend... onAuthRenderFrontends) {
        this.userRepository = userRepository;
        this.onAuthRenderFrontends = onAuthRenderFrontends;
    }

    @Override
    public void render(Session session) {
        String username = JOptionPane.showInputDialog("Login:");
        String password = JOptionPane.showInputDialog("Password:");

        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (username.isEmpty()) {
            showAuthError();
            render(session);
        } else {
            User user = optionalUser.get();
            if (!user.isPasswordEquals(password)) {
                showAuthError();
                render(session);
            }

            Session userSession = new UserSession(user);

            for (Frontend onAuthRenderFrontend : onAuthRenderFrontends) {
                onAuthRenderFrontend.render(userSession);
            }
        }
    }

    private void showAuthError() {
        JOptionPane.showMessageDialog(
                null,
                "Bad credentials",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
