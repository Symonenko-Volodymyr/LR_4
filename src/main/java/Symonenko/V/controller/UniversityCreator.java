package Symonenko.V.controller;

import Symonenko.V.model.University;
import Symonenko.V.model.Human;

public class UniversityCreator {
    public University createUniversity(String name, Human head) {
        return new University(name, head);
    }
}
