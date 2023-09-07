package guru.qa.data;

import guru.qa.domain.Note;

import java.util.*;

public interface NoteRepository {

    List<Note> getAllByUsername(String username);

    void saveNote(Note note);

    class MockNoteRepository implements NoteRepository {

        private final List<Note> stored = new ArrayList<>(
                List.of(
                        new Note("name", "First mock note"),
                        new Note("name", "Second mock note")
                        )
        );

        @Override
        public List<Note> getAllByUsername(String username) {

            if ("name".equals(username)) {
                return stored;
            }
            return Collections.emptyList();
        }

        @Override
        public void saveNote(Note note) {
            if ("name".equals(note.getUsername())) {
                stored.add(note);
            }
        }
    }
}
