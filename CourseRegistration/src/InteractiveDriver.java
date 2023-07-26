import java.util.Scanner;

public class InteractiveDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Course Management System!");
        System.out.print("Enter the maximum number of students allowed on the roster: ");
        int maxRosterSize = scanner.nextInt();
        System.out.print("Enter the maximum number of students allowed on the waitlist: ");
        int maxWaitlistSize = scanner.nextInt();
        scanner.nextLine();

        Course course = new Course("Media Studies", maxRosterSize, maxWaitlistSize);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add student");
            System.out.println("2. Drop student");
            System.out.println("3. View course details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1/2/3/4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student's first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter student's last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter student's ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Has the student paid the tuition? (true/false): ");
                    boolean tuitionPaid = scanner.nextBoolean();
                    scanner.nextLine();

                    Student studentToAdd = new Student(firstName, lastName, id, tuitionPaid);
                    boolean added = course.addStudent(studentToAdd);
                    System.out.println(studentToAdd + (added ? " added successfully." : " not added."));
                    break;
                case 2:
                    System.out.print("Enter student's ID to drop: ");
                    String idToDrop = scanner.nextLine();
                    Student studentToDrop = new Student("", "", idToDrop, false);
                    boolean dropped = course.dropStudent(studentToDrop);
                    System.out.println(studentToDrop + (dropped ? " dropped successfully." : " not dropped."));
                    break;
                case 3:
                    System.out.println(course);
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
