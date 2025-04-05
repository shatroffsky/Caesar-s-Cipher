package CaesarCipher;

import static CaesarCipher.ConstantsForAlphabet.UK;
import static CaesarCipher.ConstantsForAlphabet.ENG;

public class CaesarCipher {
    private final int key;

    public CaesarCipher(int key) {
        this.key = key;
    }

    public CaesarCipher() {
        this.key = 0;
    }

    public String EncryptUA(String StringToEncrypt) {
        StringBuilder result = new StringBuilder();
        for (char el : StringToEncrypt.toCharArray()){
            if (inUK(el)){
                result.append(UK.get((UK.indexOf(el) + (key % UK.size())) % UK.size()));
            } else {
                result.append(el);
            }
        }
        return result.toString();
    }

    public String DecryptUA(String StringToDecrypt) {
        StringBuilder result = new StringBuilder();
        for (char el : StringToDecrypt.toCharArray()){
            if (inUK(el)){
                result.append(UK.get((UK.indexOf(el) - (key % UK.size()) + UK.size()) % UK.size()));
            } else {
                result.append(el);
            }
        }
        return result.toString();
    }

    public String EncryptENG(String StringToEncrypt) {
        StringBuilder result = new StringBuilder();
        for (char el : StringToEncrypt.toCharArray()){
            if (inENG(el)){
                result.append(ENG.get((ENG.indexOf(el) + (key % ENG.size())) % ENG.size()));
            } else {
                result.append(el);
            }
        }
        return result.toString();
    }

    public String DecryptENG(String StringToDecrypt) {
        StringBuilder result = new StringBuilder();
        for (char el : StringToDecrypt.toCharArray()){
            if (inENG(el)){
                result.append(ENG.get((ENG.indexOf(el) - (key % ENG.size()) + ENG.size()) % ENG.size()));
            } else {
                result.append(el);
            }
        }
        return result.toString();
    }

    public String BrudeDecryptUA(String StringToDecrypt, int key) {
        StringBuilder result = new StringBuilder();
        for (char el : StringToDecrypt.toCharArray()){
            if (inUK(el)){
                result.append(UK.get((UK.indexOf(el) - (key % UK.size()) + UK.size()) % UK.size()));
            } else {
                result.append(el);
            }
        }
        return result.toString();
    }

    public String BrudeDecryptENG(String StringToDecrypt, int key) {
        StringBuilder result = new StringBuilder();
        for (char el : StringToDecrypt.toCharArray()){
            if (inENG(el)){
                result.append(ENG.get((ENG.indexOf(el) - (key % ENG.size()) + ENG.size()) % ENG.size()));
            } else {
                result.append(el);
            }
        }
        return result.toString();
    }

    public boolean inUK(char letter){
        return UK.contains(letter);
    }

    public boolean inENG(char letter){
        return ENG.contains(letter);
    }
}


