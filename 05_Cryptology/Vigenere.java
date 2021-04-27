import java.util.ArrayList;

class Vigenere {
  public static String encrypt(String text, String keyword) {
    int length = keyword.length();
    int k = 0;
    ArrayList<Character> textLetters = new ArrayList<>();
    for (char letter: text.toCharArray()) {
      textLetters.add(letter);
    }
    for (int i=0; i<textLetters.size(); i++) {
      int asciiLetter = (int) textLetters.get(i);
      int position = (i-k) % length;
      char positionKeyword = keyword.charAt(position);
      int shift = ((int) positionKeyword - 65);
      boolean isCapital = asciiLetter>=65 && asciiLetter<=90;
      boolean isSpace = asciiLetter == 32;
      if (isSpace) {
        textLetters.set(i, (char) asciiLetter);
        k++;
      }
      else {
        asciiLetter += shift; 
        asciiLetter = (isCapital) ? ((asciiLetter - 65) % 26 + 65) : ((asciiLetter - 97) % 26 + 97);
        textLetters.set(i, (char) asciiLetter);
      }
    }
    String encryptedText = "";
    for (int i=0; i<textLetters.size(); i++) {
      encryptedText += String.valueOf(textLetters.get(i));
    }
    return encryptedText;
  }
}