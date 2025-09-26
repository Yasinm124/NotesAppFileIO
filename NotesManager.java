import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NotesManager {
    private final String filePath;

    // Constructor takes file path (e.g., "notes.txt")
    public NotesManager(String filePath) {
        this.filePath = filePath;
    }

    // Append a note to the file (creates file if it does not exist)
    public void addNote(String note) throws IOException {
        try (FileWriter fw = new FileWriter(filePath, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(note);
            bw.newLine();
        }
    }

    // Read all notes (returns empty list if file not found)
    public List<String> getAllNotes() throws IOException {
        List<String> notes = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return notes; // no notes yet
        }
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                notes.add(line);
            }
        }
        return notes;
    }

    // Delete a note by 1-based index; returns true if deleted
    public boolean deleteNote(int index) throws IOException {
        List<String> notes = getAllNotes();
        if (index < 1 || index > notes.size()) {
            return false;
        }
        notes.remove(index - 1);
        // overwrite file with remaining notes
        try (FileWriter fw = new FileWriter(filePath, false);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (String note : notes) {
                bw.write(note);
                bw.newLine();
            }
        }
        return true;
    }

    // Update a note by 1-based index; returns true if updated
    public boolean updateNote(int index, String newText) throws IOException {
        List<String> notes = getAllNotes();
        if (index < 1 || index > notes.size()) {
            return false;
        }
        notes.set(index - 1, newText);
        // overwrite file
        try (FileWriter fw = new FileWriter(filePath, false);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (String note : notes) {
                bw.write(note);
                bw.newLine();
            }
        }
        return true;
    }
}
