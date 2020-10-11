package encryptdecrypt;

public class Encryptor {

    private EncryptionStrategy strategy;

    public void setStrategy(EncryptionStrategy strategy) {
        this.strategy = strategy;
    }

    public String convert(String message, int key, String mode) {

        if (mode.equals("enc")) {
            return strategy.encrypt(message, key);

        } else if (mode.equals("dec")) {
            return strategy.decrypt(message, key);

        } else {
            return null;
        }
    }
}
