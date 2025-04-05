package FileReaderOrWriter;
import CaesarCipher.CaesarCipher;

import java.io.*;
import java.nio.file.Path;

public class FileToEncrypt {

    private final Path from;
    private final Path to;
    private final CaesarCipher encrypter;

    public FileToEncrypt(Path path, int key) {
        this.from = path;
        to = GetNameForFile();
        encrypter = new CaesarCipher(key);
    }

    public void EncrytpFileUA() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(from.toString()));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(to.toString(), false))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(encrypter.EncryptUA(line));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void EncrytpFileENG() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(from.toString()));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(to.toString(), false))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(encrypter.EncryptENG(line));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Path GetNameForFile(){
        String pathString = from.toString();
        int lastIndex = pathString.lastIndexOf('.');
        return Path.of(pathString.substring(0, lastIndex) + "[ENCRYPTED]" + pathString.substring(lastIndex));
    }

    public String GetAlphabet(){
        try (FileReader reader = new FileReader(String.valueOf(from))) {
            int in;
            while ((in = reader.read()) != -1) {
                char letter = (char) in;
                if (Character.isLetter(letter)){
                    if (encrypter.inUK(letter)){
                        return "UK";
                    } else if (encrypter.inENG(letter)) {
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
