package CaesarCipher;

import static CaesarCipher.ConstantsForAlphabet.UK;
import static CaesarCipher.ConstantsForAlphabet.ENG;
import java.io.IOException;
import java.nio.file.Path;

import static CaesarCipher.ConstantsForAlphabet.ENG;
import static CaesarCipher.ConstantsForAlphabet.UK;

public class BrudeForce {

    public BrudeForce(){

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
