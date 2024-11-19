package Symonenko.V.controller;

import Symonenko.V.model.Group;
import Symonenko.V.model.Human;

public class GroupCreator {
    public Group createGroup(String name, Human head) {
        return new Group(name, head);
    }
}
