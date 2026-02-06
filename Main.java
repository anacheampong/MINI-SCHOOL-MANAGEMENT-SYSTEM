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
    }
}
