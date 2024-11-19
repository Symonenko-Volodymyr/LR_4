package Symonenko.V.controller;

import Symonenko.V.model.Student;
import Symonenko.V.model.Sex;

public class StudentCreator {
    public Student createStudent(String firstName, String lastName, String middleName, Sex gender) {
        return new Student(firstName, lastName, middleName, gender);
    }
}
