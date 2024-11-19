package Symonenko.V.controller;

import Symonenko.V.model.Department;
import Symonenko.V.model.Human;

public class DepartmentCreator {
    public Department createDepartment(String name, Human head) {
        return new Department(name, head);
    }
}
