package RunProgram;

import CaesarCipher.BrudeForce;
import FileReaderOrWriter.FileToDecrypt;
import FileReaderOrWriter.FileToEncrypt;
import java.nio.file.Path;
import java.util.Scanner;

public class GuiInConsole {

    private char option;

    public GuiInConsole() {
        Menu();
    }

    public GuiInConsole(String[] args){
        switch (args[0]) {
//            case "ENCRYPT" -> MenuIfArgsENCRYPT(args);
//            case "DECRYPT" -> MenuIfArgsDECRYPT(args);
            case "BRUTE_FORCE" -> new BrudeForce(Path.of(args[1]));
            default -> System.out.println("Not found command.");
        }
    }

    public void Menu() {
        System.out.println("Hello! It's Caesar's cipher program.");
        boolean run = true;
        while (run) {
//            option = Option();
            if (option == 'e') {
                run = false;
            } else if (option == 'a') {
//                run = OptionA();
            } else if (option == 'b') {
//                run = OptionB();
            } else {
                System.out.println("Sorry, you write wrong option, try again.");
            }
        }
    }
}