import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
    public void displayMenu() {
        System.out.println("""
            1. Add Student
            2. View Students
            3. Calculate average score
            4. Search for student
            5. Exit application
            """);
    }
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            Main mainMenu = new Main();
            ArrayList<Student> allStudents = new ArrayList<>();

            while (true) {
            mainMenu.displayMenu();
            int choice = input.nextInt();

            switch (choice) {
            case 1: {
            // first option
            System.out.println("Enter your name");
            input.nextLine();
            String name = input.nextLine();
            System.out.flush();

            System.out.println("Enter your date of birth (eg 2000 - 01 - 01)");
            String dobStr = input.nextLine();
            LocalDate DOB = LocalDate.parse(dobStr, DateTimeFormatter.ISO_DATE);

            System.out.println("Program of study");
            String programOfStudy = input.nextLine();
            System.out.println("Enter number of courses");
            int numberOfCourses = input.nextInt();
            input.nextLine();
            System.out.println("Enter your courses");
            String[] courses = new String[numberOfCourses];
            for (int i = 0; i < numberOfCourses; i++) {
            System.out.println("Course " + (i + 1));
            courses[i] = input.nextLine();
            } 

            Student student = new Student(name, DOB, programOfStudy, courses);
            allStudents.add(student);

            break;
            }
            case 2: {
            // second 

            if (allStudents == null) {
            System.out.println("Student list is empty");
            }
            else {
            allStudents.forEach(student -> student.displayStudentInfo());
            }
            break;
            }
            case 3: {
            // third option
            break;
            }
            case 4: {
            // fourth option
            break;
            }
            case 5: {
            // fifth option
            break;
            }
            default: {
            // invalid option
            break;
            }
            }
}
        }
        catch (Exception e) {
            System.out.println("Something went wrong...");
        }

        finally {
            System.out.println();
        }
    }

}