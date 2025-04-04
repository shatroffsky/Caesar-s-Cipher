package CaesarCipher;

import java.util.ArrayList;
import java.util.Arrays;

public class ConstantsForAlphabet {

    public static final ArrayList<Character> UK = new ArrayList<>(
            Arrays.asList('а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і',
                    'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
                    'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я',
                    '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '));

    public static final ArrayList<Character> ENG = new ArrayList<>(
            Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                    'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                    'y', 'z', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '));
}
