package pl.krysinski;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Application app = new Application();
            app.run();
        } catch (InputMismatchException e) {
            System.err.println("Input is not a integer value.");
        }
    }
}



