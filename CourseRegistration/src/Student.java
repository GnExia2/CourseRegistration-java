public class Student {
    private String firstName;
    private String lastName;
    private String id;
    private boolean tuitionPaid;

    public Student(String firstName, String lastName, String id, boolean tuitionPaid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.tuitionPaid = tuitionPaid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isTuitionPaid() {
        return tuitionPaid;
    }

    public void setTuitionPaid(boolean tuitionPaid) {
        this.tuitionPaid = tuitionPaid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Student student = (Student) obj;

        return id.equals(student.id) &&
               firstName.equalsIgnoreCase(student.firstName) &&
               lastName.equalsIgnoreCase(student.lastName) &&
               tuitionPaid == student.tuitionPaid;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + (tuitionPaid ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + id + ")";
    }
}
