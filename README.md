# CourseRegistration-java

You will be completing and writing classes that could be used as part of a course registration system.
Part A: The Student Class

Review the provided Student.java class.

(10 points) Complete the class by writing an equals method to override the equals method inherited from Object. Two students should be considered logically equivalent if they have the same id, first name (ignoring capitalization), last name (ignoring capitalization), and tuition paid status.
Part B: The Course Class

You will write a Course class. A Course keeps track of Students enrolled in the Course (on the roster) and on the waitlist for the Course. Include:

    (5 points) Instance data variables
        a course name
        two Student[] objects- one for roster, one for waitlist
        the maximum number of students allowed on the waitlist and roster
        any other variables you think are helpful
    (5 points) A constructor
        A Course object is initially created by specifying the maximum number of students allowed on the roster and on the waitlist
        The roster and waitlist are initially empty
    (5 points) Getters and setters
        Carefully consider which variables should have setters.
        Include validity checks in setters when appropriate.
    (15 points) A toString method whose text representation includes
        the name of the course
        the number of students enrolled in the course and the maximum number that can be enrolled
        the roster of enrolled students (all student data for all enrolled students should be included)
        the number of students on the waitlist and the maximum number that can be on the waitlist
        the students on the waitlist (all student data for all waitlisted students should be included)
         make sure that there are no "nulls" printed with the arrays
    (20 points) An addStudent method
        method header: public boolean addStudent(Student student)
        if the student has paid their tuition and are not already enrolled on the roster or waitlist, the student is eligible to be added to the class
            if there is room on the roster, add the student to the roster
            if the roster is full but there is room on the waitlist, add the student to the waitlist
            if there is no room on the roster or waitlist, do not add the student
        if the student has not paid their tuition or is already on the roster or waitlist, do not add the student
        return true or false based on whether the student is added or not
    (25 points) A dropStudent method
        method header: public boolean dropStudent(Student student)
        if the student is not on the roster or waitlist, the student cannot be removed
        if the student is on the roster, remove the student from the roster
            since there is now one more space in the class, if the waitlist is not empty, take the first person off the waitlist and add them to the roster
        if the student is on the waitlist, remove the student from the waitlist
        return true or false based on whether the student is removed or not


Part C: Interactive Driver Program

(15 points) Write an interactive driver program that creates a Course object (you can decide the name and roster/waitlist sizes). Then, use a loop to interactively allow the user to add students, drop students, or view the course. Display the result (success/failure) of each add/drop.

Extra Credit (15 points)

Write a class called CourseAL. This class has the same methods as Course (listed above). Instead of using a Student[] to store the roster and waitlist, use an ArrayList<Student>. For full credit, take advantage of the methods in the ArrayList class to implement the methods. Do not just swap out the array for an ArrayList- use the methods from the ArrayList class! You might be able to significantly streamline your code!

Note: If completing the extra credit, you must submit both the Course and CourseAL classes.
