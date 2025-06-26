# 📚 Library Management System

## ✅ Objective
A simple Library Management System built using **Java** and **Object-Oriented Programming (OOP)** principles.  
The system allows:
- Managing books and users
- Issuing and returning books
- Displaying all books and users

---

## 🛠 Tools Used

| Tool      | Purpose                        |
|-----------|--------------------------------|
| Java      | Programming language           |
| VS Code   | Code editor / IDE              |
| Terminal  | Compile and run the program    |

---

## 💡 Key Concepts Implemented

- **Abstraction**  
  `Book` and `User` are abstract classes. They define common structure but leave details (like display methods) to subclasses.

- **Inheritance**  
  `PrintedBook` extends `Book`.  
  `StudentUser` extends `User`.

- **Polymorphism**  
  `displayDetails()` and `displayUser()` methods are called dynamically based on the object’s type at runtime.

---

## 🚀 Project Structure

