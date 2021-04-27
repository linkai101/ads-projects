import java.util.ArrayList;

class Caesar {
  public static String encrypt(String text, int shift) {
    // Splits string into list of chars
    ArrayList<Character> textLetters = new ArrayList<>();
    for (char letter: text.toCharArray()) {
      textLetters.add(letter);
    }

    // Shifts every char in list
    for (int i=0; i<textLetters.size(); i++) {
      int asciiLetter = (int) textLetters.get(i);

      boolean isCapital = (asciiLetter>=65 && asciiLetter<=90) ? true : false;
      boolean isSpace = asciiLetter == 32;

      // Shifts letter and fixes if shift is outside alphabet range
      asciiLetter += shift;
      asciiLetter = (isCapital) ? ((asciiLetter - 65) % 26 + 65) : ((asciiLetter - 97) % 26 + 97);

      // Sets to space if original letter was space
      if (isSpace) asciiLetter = 32;

      textLetters.set(i, (char) asciiLetter);
    }

    // Converts list of chars into string
    String encryptedText = "";
    for (int i=0; i<textLetters.size(); i++) {
      encryptedText += String.valueOf(textLetters.get(i));
    }
    
    return encryptedText;
  }
}