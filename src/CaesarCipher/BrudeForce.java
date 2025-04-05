package CaesarCipher;
import FileReaderOrWriter.FileBrudeForce;
import static CaesarCipher.ConstantsForAlphabet.UK;
import static CaesarCipher.ConstantsForAlphabet.ENG;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BrudeForce{

    public BrudeForce(Path file) {
        try {
            Path directory = Files.createDirectories(CreateDirectoryPath(file));
            CreateFilesWithDecrypt(new FileBrudeForce(file, directory));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void CreateFilesWithDecrypt(FileBrudeForce decrypt){
        if (decrypt.GetAlphabet().equals("UK")){
            for (int i = 1; i <= UK.size(); i++) {
                decrypt.DecrytpFileUA(i);
            }
        } else if (decrypt.GetAlphabet().equals("ENG")) {
            for (int i = 1; i <= ENG.size(); i++) {
                decrypt.DecrytpFileENG(i);
            }
        }
    }

    public Path CreateDirectoryPath(Path path) throws IOException {
        return CreateNameForDirectory(path);

    }

    private Path CreateNameForDirectory(Path path){
        String fileName = path.getFileName().toString();
        String end = "";
        if (fileName.lastIndexOf('.') != -1){
            end = fileName.substring(fileName.lastIndexOf('.'));
            fileName = fileName.substring(0, fileName.lastIndexOf('.'));
        }
        return path.getParent().resolve(Path.of("[DECRYPTED_FILES_FOR_" + fileName + end + "]"));
    }
}
