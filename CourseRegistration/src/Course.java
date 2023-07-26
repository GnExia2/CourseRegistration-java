public class Course {
   private String courseName;
   private Student[] students;
   private Student[] waitListStudents;
   private int maxStudents;
   private int numStudents;

   public Course(String courseName, int maxStudents) {
      this.courseName = courseName;
      this.maxStudents = maxStudents;
      this.students = new Student[maxStudents];
      this.numStudents = 0;
   }

   public boolean addStudent(Student student) {
      if (numStudents < maxStudents) {
         students[numStudents] = student;
         numStudents++;
         return true;
      }
      return false;
   }

   public boolean dropStudent(Student student) {
      for (int i = 0; i < numStudents; i++) {
         if (students[i].equals(student)) {
            // Shift remaining students to fill the gap
            for (int j = i; j < numStudents - 1; j++) {
               students[j] = students[j + 1];
            }
            students[numStudents - 1] = null;
            numStudents--;
            return true;
         }
      }
      return false;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append(courseName).append("\n");
      sb.append(numStudents).append(" Enrolled (maximum allowed 5) ").append("\n");
      sb.append(numStudents).append(" on waitlist (maximum allowed 5) ").append("\n");
      for (int i = 0; i < numStudents; i++) {
         sb.append(students[i].toString()).append("\n");
      }
      return sb.toString();
   }
}