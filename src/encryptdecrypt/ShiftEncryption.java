package encryptdecrypt;


public class ShiftEncryption implements EncryptionStrategy {

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
        boolean upperCase = false;

        for (int i = 0; i < messageToConvert.length(); i++) {

            char characterToConvert = messageToConvert.charAt(i);
            if (Character.isLetter(characterToConvert)) {

                if (Character.isUpperCase(characterToConvert)) {
                    upperCase = true;
                    String characterToLower = ("" + characterToConvert).toLowerCase();
                    characterToConvert = characterToLower.charAt(0);
                }

                int indexOfConversion = (int) characterToConvert - 96;

                if (!dec) {
                    indexOfConversion += key;
                    if (indexOfConversion > 26) {
                        indexOfConversion = indexOfConversion % 26;
                    }
                } else {
                    indexOfConversion -= key;
                    if (indexOfConversion < 0) {
                        indexOfConversion = 26 + indexOfConversion % 26;
                    }
                }

                indexOfConversion += 96;
                String convertedCharacter = String.valueOf((char) indexOfConversion);
                if (upperCase) {
                    convertedCharacter = convertedCharacter.toUpperCase();
                }

                messageToConvert.replace(i, i + 1, convertedCharacter);
            }
        }
        return messageToConvert.toString();
    }
}
