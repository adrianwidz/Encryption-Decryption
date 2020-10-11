package encryptdecrypt;

public class UnicodeEncryption implements EncryptionStrategy {

    @Override
    public String encrypt(String message, int key) {
        return convert(message, key, false);
    }

    @Override
    public String decrypt(String message, int key) {
        return convert(message, key, true);
    }

    private String convert(String message, int key, boolean dec) {
        StringBuilder messageToConvert = new StringBuilder(message);

        if (dec) {
            key = -key;
        }

        for (int i = 0; i < messageToConvert.length(); i++) {
            char characterToConvert = messageToConvert.charAt(i);

            int unicodeToConvert = (int) characterToConvert + key;
            char convertedCharacter = (char) unicodeToConvert;

            String replacement = "" + convertedCharacter;
            messageToConvert.replace(i, i + 1, replacement);
        }

        return messageToConvert.toString();
    }
}
