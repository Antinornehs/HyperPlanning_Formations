package fr.univtln.mgajovski482.HyperPlanning;

import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.Student;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Maxime on 06/11/2015.
 */
public class StudentFormationInitializer {

    public static void initFormationIntoStudents(){
        List<Student> studentList =
                Arrays.asList(Student.staticStudentMap.values().toArray(new Student[0]));

        for(Student currentStudent : studentList){
            Formation form = Formation.getRandomFormation();
            currentStudent.setFormation(form);
        }
    }
}
