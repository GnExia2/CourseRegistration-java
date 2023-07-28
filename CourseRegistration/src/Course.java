import java.util.Arrays;

public class Course {
    private String courseName;
    private Student[] roster;
    private Student[] waitlist;
    private int rosterSize;
    private int waitlistSize;
    private int maxRosterSize;
    private int maxWaitlistSize;

    // Constructor
    public Course(String courseName, int maxRosterSize, int maxWaitlistSize) {
        this.courseName = courseName;
        this.roster = new Student[maxRosterSize];
        this.waitlist = new Student[maxWaitlistSize];
        this.rosterSize = 0;
        this.waitlistSize = 0;
        this.maxRosterSize = maxRosterSize;
        this.maxWaitlistSize = maxWaitlistSize;
    }

    // Getters
    public String getCourseName() {
        return courseName;
    }

    public Student[] getRoster() {
        return Arrays.copyOf(roster, rosterSize);
    }

    public Student[] getWaitlist() {
        return Arrays.copyOf(waitlist, waitlistSize);
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(courseName).append("\n");
        result.append(rosterSize).append(" enrolled (maximum allowed ").append(maxRosterSize).append(")\n");
        for (int i = 0; i < rosterSize; i++) {
            result.append("\t").append(roster[i]).append("\n");
        }
        result.append(waitlistSize).append(" on waitlist (maximum allowed ").append(maxWaitlistSize).append(")\n");
        for (int i = 0; i < waitlistSize; i++) {
            result.append("\t").append(waitlist[i]).append("\n");
        }
        return result.toString();
    }

    // Add a student to the course
    public boolean addStudent(Student student) {
        if (student.isTuitionPaid() && !containsStudent(roster, rosterSize, student) && !containsStudent(waitlist, waitlistSize, student)) {
            if (rosterSize < maxRosterSize) {
                roster[rosterSize++] = student;
            } else if (waitlistSize < maxWaitlistSize) {
                waitlist[waitlistSize++] = student;
            } else {
                return false;
            }
            return true;
        }
        return false;
    }

    // Drop a student from the course
    public boolean dropStudent(Student student) {
        for (int i = 0; i < rosterSize; i++) {
            if (roster[i].equals(student)) {
                // Shift students in the waitlist to the roster if there's space
                if (waitlistSize > 0) {
                    roster[i] = waitlist[0];
                    for (int j = 0; j < waitlistSize - 1; j++) {
                        waitlist[j] = waitlist[j + 1];
                    }
                    waitlist[waitlistSize - 1] = null;
                    waitlistSize--;
                } else {
                    roster[i] = null;
                }
                rosterSize--;
                return true;
            }
        }
        for (int i = 0; i < waitlistSize; i++) {
            if (waitlist[i].equals(student)) {
                waitlist[i] = null;
                waitlistSize--;
                return true;
            }
        }
        return false;
    }

    // Helper method to check if a student is in a student array
    private boolean containsStudent(Student[] students, int size, Student student) {
        for (int i = 0; i < size; i++) {
            if (students[i].equals(student)) {
                return true;
            }
        }
        return false;
    }
}
