package RunProgram;

import CaesarCipher.BrudeForce;
import FileReaderOrWriter.FileToDecrypt;
import FileReaderOrWriter.FileToEncrypt;
import java.nio.file.Path;
import java.util.Scanner;

public class GuiInConsole {

    public GuiInConsole() {
        Menu();
    }

    public GuiInConsole(String[] args){
        switch (args[0]) {
            case "ENCRYPT" -> MenuIfArgsENCRYPT(args);
            case "DECRYPT" -> MenuIfArgsDECRYPT(args);
            case "BRUTE_FORCE" -> new BrudeForce(Path.of(args[1]));
            default -> System.out.println("Not found command.");
        }
    }

    public void Menu() {
        System.out.println("Hello! It's Caesar's cipher program.");
        boolean run = true;
        while (run) {
            char option = Option();
            if (option == 'e') {
                run = false;
            } else if (option == 'a') {
                run = OptionA();
            } else if (option == 'b') {
                run = OptionB();
            } else {
                System.out.println("Sorry, you write wrong option, try again.");
            }
        }
    }

    public boolean Exit(){
        System.out.println("Do you want to continue? | [a]Yes | [b]No |");
        return new Scanner(System.in).next().charAt(0) == 'a';
    }

    public boolean OptionA(){
        System.out.println("Enter your path to file with text which you need to encrypt: ");
        Path path = Path.of(new Scanner(System.in).nextLine());
        System.out.println("Enter your key to encrypt: ");
        int key = new Scanner(System.in).nextInt();
        FileToEncrypt file = new FileToEncrypt(path, key);
        if (file.GetAlphabet().equals("UK")) {
            file.EncrytpFileUA();
        } else if (file.GetAlphabet().equals("ENG")) {
            file.EncrytpFileENG();
        }
        return Exit();
    }

    public boolean OptionB(){
        System.out.println("Enter your path to file with text which you need to decrypt: ");
        Path path = Path.of(new Scanner(System.in).nextLine());
        System.out.println("Enter your key to decrypt: ");
        int key = new Scanner(System.in).nextInt();
        FileToDecrypt file = new FileToDecrypt(path, key);
        if (file.GetAlphabet().equals("UK")) {
            file.DecrytpFileUA();
        } else if (file.GetAlphabet().equals("ENG")) {
            file.DecrytpFileENG();
        }
        return Exit();
    }

    public char Option(){
        System.out.println("Choose your option:\n[a] Encrypt text | [b] Decrypt text | [e] Exit program");
        return new Scanner(System.in).next().charAt(0);
    }

    public void MenuIfArgsENCRYPT(String[] args){
        if (args[0].equals("ENCRYPT")){
            FileToEncrypt file = new FileToEncrypt(Path.of(args[1]), Integer.parseInt(args[2]));
            if (file.GetAlphabet().equals("UK")) {
                file.EncrytpFileUA();
            } else if (file.GetAlphabet().equals("ENG")) {
                file.EncrytpFileENG();
            }
        }
    }

    public void MenuIfArgsDECRYPT(String[] args){
        if (args[0].equals("DECRYPT")){
            FileToDecrypt file = new FileToDecrypt(Path.of(args[1]), Integer.parseInt(args[2]));
            if (file.GetAlphabet().equals("UK")) {
                file.DecrytpFileUA();
            } else if (file.GetAlphabet().equals("ENG")) {
                file.DecrytpFileENG();
            }
        }
    }
}