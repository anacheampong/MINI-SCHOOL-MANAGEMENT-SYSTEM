public class Student {
    private static int idCounter = 1;
    private static String StudentID;
    String name;
    int dateOfBirth;
    String programOfStudy;
    String[] courses;
    double[] scores;

    public Student(String name, int dateOfBirth, String programOfStudy, String[] courses) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name.trim();
        this.dateOfBirth = dateOfBirth;
        this.programOfStudy = programOfStudy;
        this.courses = courses;
        this.StudentID = "STU - %04d".formatted(idCounter);
        idCounter++;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void displayStudentInfo() {
        System.out.println("Student ID: " + StudentID);
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Program of Study: " + programOfStudy);
        System.out.print("Courses: ");
        for (String course : courses) {
            System.out.println(course);
        }
        System.out.println();
    }

    public void setScores(double[] scores) {
        if (scores == null || scores.length != courses.length) {
            throw new IllegalArgumentException("Scores array must match the number of courses.");
        }
        for (double score : scores) {
            if (score < 0 || score > 100) {
                throw new IllegalArgumentException("Scores must be between 0 and 100.");
            }
            this.scores = scores;
        }
    }

    public double calculateAverageScore() {
        if (scores == null || scores.length == 0) {
            throw new IllegalStateException("Scores have not been set.");
        }
        double total = 0;
        for (double score : scores) {
            total += score;
        }
        return total / scores.length;
    }
}
