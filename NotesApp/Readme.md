# 📝 Java Notes Application

A simple console-based Java Notes Manager that allows users to create and view notes using **File I/O** with `FileWriter` and `BufferedReader`.

---

## 📌 Features

- Add notes to a `.txt` file.
- View notes from any existing file.
- Automatically appends `.txt` extension to filenames.
- Simple menu-driven console interface.

---

## 🛠️ Tools & Technologies

| Tool                        | Purpose                          |
|-----------------------------|----------------------------------|
| Java                        | Programming Language             |
| **Intellij Idea**               | Code Editor                      |
| Terminal                    | Running the application          |
| FileWriter                  | Writing notes to a file          |
| FileReader + BufferedReader | Reading notes from file |

---

## 📂 Project Structure

```
NotesApp/
├── AddNotes.java       // Handles writing notes to file
├── ViewNotes.java      // Handles reading notes from file
├── Main.java           // Menu logic and user interface
├── README.md           // You're here :)
```

---

## 🚀 How It Works

### ➕ Add Notes
1. User selects **Add Notes**.
2. Enters a file name (no need to add `.txt`).
3. Enters the note text.
4. Appends the note to `<filename>.txt`.

### 📖 View Notes
1. User selects **View Notes**.
2. Enters the file name.
3. App prints the content of `<filename>.txt` line by line.

---

## 🧪 Example

```
Welcome to Java Notes Application.
Choose Options:
1. Add Notes
2. View Notes
3. Exit

Enter your choice: 1
Enter New File Name: mynotes
Enter your Notes:
Today I learned Java File I/O!
```

---

## ⚠️ Notes

- The application assumes files are stored in the current directory.
- Make sure to give proper permission for file read/write if needed.
- If the file doesn't exist while viewing, Java will throw an exception (can be handled via try-catch).

---

## 🧑‍💻 Author

Created as part of a **Java learning task** focusing on File Handling and basic OOP concepts.

---
