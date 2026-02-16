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
        Scanner input = new Scanner(System.in);
        try {
            Main mainMenu = new Main();
            ArrayList<Student> allStudents = new ArrayList<>();

            int choice;
            do {
            mainMenu.displayMenu();
            choice = input.nextInt();

            switch (choice) {
            case 1: {
            // first option
            System.out.println("Enter your name");
            input.nextLine();
            String name = input.nextLine();

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
            System.out.println("Student added successfully!\n");

            break;
            }
            case 2: {
                if (allStudents.isEmpty()) {
                System.out.println("Student list is empty");
                }
                else {
                allStudents.forEach(student -> student.displayStudentInfo());
                }
                break;
                }
            case 3: {
            // third option
                for (Student student : allStudents) {
                    if (student.hasScores()) {
                        System.out.println("Student: " + student.getName() + " - Average Score: " + student.calculateAverageScore());
                    } else {
                        System.out.println("Student: " + student.getName() + " - Scores not set.");
                        System.out.println("Enter scores for " + student.getName() + ": ");

                        double [] scores = new double[student.getNumberOfCourses()];
                        for (int i = 0; i < student.getNumberOfCourses(); i++) {
                            System.out.println("Course " + (i + 1) + ": " + student.getCourses().split(" ")[i]);
                            scores[i] = input.nextDouble();
                        }
                        student.setScores(scores);
                        System.out.println("Average Score for " + student.getName() + ": " + student.calculateAverageScore());
                        
                    }
                }
                break;
            }
            case 4: {
                if (allStudents.isEmpty()) {
                    System.out.println("\nList is empty!\n");
                } else {
                    System.out.println("Enter student name or ID: ");
                    String searchName = input.next();
                    for (Student student : allStudents) {
                        if (student.getStudentID().contains(searchName)|| student.getName().contains(searchName)) {
                            student.displayStudentInfo();
                            System.out.println("\nStudent found!");
                            break;
                        }
                        else {
                            System.out.println("\nStudent not found...\n");
                        }
                    }
                }
                break;
            }
            case 5: {
                System.out.println("\nExited sucessfully!\n");
                break;
            }
            default: {
                System.out.println("\nInvalid option. Try again...\n");
                break;
            }
            } 
        } while (choice != 5);
        } 

        catch (Exception e) {
            System.out.println("Something went wrong...");
        }
    

        finally {
            System.out.println();
            input.close();
        }
    }
}
    
