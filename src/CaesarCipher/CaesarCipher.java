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
}


