import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class NotesApp {
    private static final NotesManager manager = new NotesManager("notes.txt");
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("===== Notes App (File I/O) =====");

        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> addNote();
                case 2 -> viewNotes();
                case 3 -> updateNote();
                case 4 -> deleteNote();
                case 5 -> {
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("1. Add Note");
        System.out.println("2. View Notes");
        System.out.println("3. Update Note");
        System.out.println("4. Delete Note");
        System.out.println("5. Exit");
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static void addNote() {
        System.out.println("--- Add Note ---");
        System.out.print("Enter note text: ");
        String note = scanner.nextLine().trim();
        if (note.isEmpty()) {
            System.out.println("Note cannot be empty.");
            return;
        }
        try {
            manager.addNote(note);
            System.out.println("Note saved.");
        } catch (IOException e) {
            System.out.println("Error saving note: " + e.getMessage());
        }
    }

    private static void viewNotes() {
        System.out.println("--- All Notes ---");
        try {
            List<String> notes = manager.getAllNotes();
            if (notes.isEmpty()) {
                System.out.println("No notes found.");
                return;
            }
            int i = 1;
            for (String n : notes) {
                System.out.println(i + ". " + n);
                i++;
            }
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }

    private static void updateNote() {
        System.out.println("--- Update Note ---");
        viewNotes();
        int idx = readInt("Enter note number to update: ");
        System.out.print("Enter new text: ");
        String newText = scanner.nextLine().trim();
        if (newText.isEmpty()) {
            System.out.println("New text cannot be empty.");
            return;
        }
        try {
            boolean ok = manager.updateNote(idx, newText);
            System.out.println(ok ? "Note updated." : "Update failed (invalid index).");
        } catch (IOException e) {
            System.out.println("Error updating note: " + e.getMessage());
        }
    }

    private static void deleteNote() {
        System.out.println("--- Delete Note ---");
        viewNotes();
        int idx = readInt("Enter note number to delete: ");
        try {
            boolean ok = manager.deleteNote(idx);
            System.out.println(ok ? "Note deleted." : "Delete failed (invalid index).");
        } catch (IOException e) {
            System.out.println("Error deleting note: " + e.getMessage());
        }
    }
}
