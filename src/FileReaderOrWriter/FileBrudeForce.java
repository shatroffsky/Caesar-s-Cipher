package FileReaderOrWriter;

import CaesarCipher.CaesarCipher;
import java.io.*;
import java.nio.file.Path;

public class FileBrudeForce {

    private final Path from;
    private Path to;
    private final Path directory;
    private final CaesarCipher decrypter;

    public FileBrudeForce(Path path, Path directory) {
        this.from = path;
        this.directory = directory;
        decrypter = new CaesarCipher();
    }

    public void DecrytpFileUA(int key) {
        to = directory.resolve(GetNameForFile(from, key));
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(from.toString()));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(to.toString(), false))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(decrypter.BrudeDecryptUA(line, key));
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void DecrytpFileENG(int key) {
        to = directory.resolve(GetNameForFile(from, key));
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(from.toString()));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(to.toString(), false))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(decrypter.BrudeDecryptENG(line, key));
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Path GetNameForFile(Path path, int key) {
        String name = path.getFileName().toString();
        String end = name.substring(name.lastIndexOf('.'));
        return Path.of(name + "[key=%d]".formatted(key) + end);
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
