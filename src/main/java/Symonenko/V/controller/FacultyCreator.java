package Symonenko.V.controller;

import Symonenko.V.model.Faculty;
import Symonenko.V.model.Human;

public class FacultyCreator {
    public Faculty createFaculty(String name, Human head) {
        return new Faculty(name, head);
    }
}
