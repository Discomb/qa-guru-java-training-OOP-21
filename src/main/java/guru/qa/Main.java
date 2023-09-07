package guru.qa;

import guru.qa.data.NoteRepository;
import guru.qa.data.UserRepository;
import guru.qa.service.Session;
import guru.qa.view.AuthFrontend;
import guru.qa.view.FrontendContainer;
import guru.qa.view.NotesFrontend;

public class Main {
    public static void main(String[] args) {

        new FrontendContainer(
                new AuthFrontend(
                        new UserRepository.MockUserRepository(),
                        new NotesFrontend(
                                new NoteRepository.MockNoteRepository()
                        )
                )
        ).render(new Session.MockSession());

    }
}
