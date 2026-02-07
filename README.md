Student Records Console Application

Description:
This application is a Java console program designed to manage student records.
It allows users to add students, view all records, search by student ID, and
calculate average scores while handling invalid input safely.

Features:
- Add a new student
- View all students
- Search student(by name or by id)
- Calculate average score
- Exit application safely

Data Rules:
- Student ID must be a unique number
- Student name must not be empty
- Student score must be between 0 and 100

Error Handling:
- The program must not crash on invalid input
- Clear error messages are displayed to the user
- The program continues running after errors

Technical Requirements:
- Java (console-based)
- No database or GUI
- Data stored in memory
- Proper use of exception handling

How to Run:
1. Compile the program
2. Run the main class
3. Follow on-screen instructions



System.out.println("SCHOOL MANAGEMENT SYSTEM");
        System.out.println("------------------------");

        Student student1 = new Student("Alice", 2000, "Computer Science", new String[]{"Math", "Science"});
        student1.displayStudentInfo();
        student1.setScores(new double[]{85.5, 92.0});
        System.out.println("Average Score: " + student1.calculateAverageScore());

        Student student2 = new Student("Bob", 1999, "Engineering", new String[]{"Physics", "Chemistry"});   
        student2.displayStudentInfo();
        student2.setScores(new double[]{78.0, 88.5});
        System.out.println("Average Score: " + student2.calculateAverageScore());