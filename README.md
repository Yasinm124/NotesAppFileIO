# NotesAppFileIO

Text-based Notes App using FileReader/FileWriter — Internship Task 4

## Features

- Add note (appends to file)
- View notes (reads file)
- Update a note (rewrites file)
- Delete a note (rewrites file)

## Project Structure

NotesAppFileIO/
├─ NotesManager.java
├─ NotesApp.java
├─ notes.txt # created automatically when you add notes
├─ README.md
└─ .gitignore

## How to Run
1. Open terminal in project folder.
2. Compile:
    javac NotesManager.java NotesApp.java
3. Run:
    java NotesApp

## Example Run:-

===== Notes App (File I/O) =====
1. Add Note
2. View Notes
3. Update Note
4. Delete Note
5. Exit
Enter your choice: 1
--- Add Note ---
Enter note text: buy groceries 
Note saved.

1. Add Note
2. View Notes
3. Update Note
4. Delete Note
5. Exit
Enter your choice: 2
--- All Notes ---
1. buy groceries

1. Add Note
2. View Notes
3. Update Note
4. Delete Note
5. Exit
Enter your choice: 3
--- Update Note ---
--- All Notes ---
1. buy groceries
Enter note number to update: 1
Enter new text: buy shoes
Note updated.

1. Add Note
2. View Notes
3. Update Note
4. Delete Note
5. Exit
Enter your choice: 4 
--- Delete Note ---
--- All Notes ---
1. buy shoes
Enter note number to delete: 1
Note deleted.

1. Add Note
2. View Notes
3. Update Note
4. Delete Note
5. Exit
Enter your choice: 5
Exiting... Goodbye!