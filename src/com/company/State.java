package com.company;

import java.util.Random;

public enum State {
    BASE,
    route,
    repair;
     public static  State randomLetter() {
        int pick = new Random().nextInt(State.values().length);
        return State.values()[pick];
    }

}
