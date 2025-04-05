package FileReaderOrWriter;

import CaesarCipher.CaesarCipher;
import java.io.*;
import java.nio.file.Path;

public class FileToDecrypt {

    private final Path from;
    private final Path to;
    private final CaesarCipher decrypter;


    public FileToDecrypt(Path path, int key) {
        this.from = path;
        to = GetNameForFile();
        decrypter = new CaesarCipher(key);
    }

    public void DecrytpFileUA() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(from.toString()));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(to.toString(), false))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(decrypter.DecryptUA(line));
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void DecrytpFileENG() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(from.toString()));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(to.toString(), false))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(decrypter.DecryptENG(line));
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Path GetNameForFile() {
        String pathString = from.toString();
        pathString = pathString.contains("[ENCRYPTED]") ? pathString.replace("[ENCRYPTED]", "") : pathString;
        int lastIndex = pathString.lastIndexOf('.');
        return Path.of(pathString.substring(0, lastIndex) + "[DECRYPTED]" + pathString.substring(lastIndex));
    }

    public String GetAlphabet(){
        try (FileReader reader = new FileReader(String.valueOf(from))) {
            int in;
            while ((in = reader.read()) != -1) {
                char letter = (char) in;
                if (Character.isLetter(letter)){
                    if (decrypter.inUK(letter)){
                        return "UK";
                    } else if (decrypter.inENG(letter)) {
                        return "ENG";
                    } else {
                        return "Unknown";
                    }
                }
            }
            return "Літер не знайдено";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
