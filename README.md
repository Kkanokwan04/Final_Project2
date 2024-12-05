# CISC191
Intermediate Java Programming Final Project Template
## Prerequisites
1. Maven
2. Git
3. JDK 1.8
## Building
mvn clean install
## Server Module
The server application that handles multiple operations.

## Module 7 
Generics and Collections: The program uses an ArrayList<> to retrieve all books 
from the database efficiently.
## Module 8
Linked Data Structures and Recursion: A LinkedList is utilized to manage books 
dynamically, allowing the addition of multiple books for reading and the removal
of books when no longer needed.
## Module 9
Searching and Sorting: Book names can be sorted alphabetically to improve organization
and accessibility.
## Module 10
Database: SQL is employed for data persistence, ensuring reliable storage and 
retrieval of book records.
## Module 11
Concurrency: The loadBooksConcurrently() method leverages javafx.concurrent.Task() 
to create new threads, enabling data loading without freezing the UI.
## Module 12
Stream API and Lambdas: The sortBookByName() method utilizes the Stream API for 
efficient sorting, and lambda expressions are used extensively throughout the program
for concise and readable code.