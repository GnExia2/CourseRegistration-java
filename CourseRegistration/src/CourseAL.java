import java.util.ArrayList;

public class CourseAL {
    private String courseName;
    private ArrayList<Student> roster;
    private ArrayList<Student> waitlist;
    private int maxRosterSize;
    private int maxWaitlistSize;

    public CourseAL(String courseName, int maxRosterSize, int maxWaitlistSize) {
        this.courseName = courseName;
        this.roster = new ArrayList<>();
        this.waitlist = new ArrayList<>();
        this.maxRosterSize = maxRosterSize;
        this.maxWaitlistSize = maxWaitlistSize;
    }

    public String getCourseName() {
        return courseName;
    }

    public ArrayList<Student> getRoster() {
        return new ArrayList<>(roster);
    }

    public ArrayList<Student> getWaitlist() {
        return new ArrayList<>(waitlist);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(courseName).append("\n");
        result.append(roster.size()).append(" enrolled (maximum allowed ").append(maxRosterSize).append(")\n");
        for (Student student : roster) {
            result.append("\t").append(student).append("\n");
        }
        result.append(waitlist.size()).append(" on waitlist (maximum allowed ").append(maxWaitlistSize).append(")\n");
        for (Student student : waitlist) {
            result.append("\t").append(student).append("\n");
        }
        return result.toString();
    }

    public boolean addStudent(Student student) {
        if (student.isTuitionPaid() && !roster.contains(student) && !waitlist.contains(student)) {
            if (roster.size() < maxRosterSize) {
                roster.add(student);
            } else if (waitlist.size() < maxWaitlistSize) {
                waitlist.add(student);
            } else {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean dropStudent(Student student) {
        if (roster.remove(student)) {
            if (!waitlist.isEmpty()) {
                Student firstWaitlistedStudent = waitlist.remove(0);
                roster.add(firstWaitlistedStudent);
            }
            return true;
        } else if (waitlist.remove(student)) {
            return true;
        }
        return false;
    }

    public int getMaxRosterSize() {
        return maxRosterSize;
    }

    public int getMaxWaitlistSize() {
        return maxWaitlistSize;
    }
}
