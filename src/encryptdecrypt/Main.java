package encryptdecrypt;


import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String mode = "enc";
        String message = "";
        int key = 0;
        String algorithm = "shift";
        boolean saveMessage = false;
        File file = null;

        for (int i = 0; i < args.length - 1; i++) {

            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-data":
                    message = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-alg":
                    algorithm = args[i + 1];
                    break;
                case "-out":
                    saveMessage = true;
                    file = new File(args[i + 1]);
                    break;
                case "-in":
                    file = new File(args[i + 1]);

                    try (Scanner scanner = new Scanner(file)) {
                        if (scanner.hasNext()) {
                            message = scanner.nextLine();
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        Encryptor encryptor = new Encryptor();
        String convertedMassage = "";

        if (algorithm.equals("unicode")) {

            encryptor.setStrategy(new UnicodeEncryption());
            convertedMassage = encryptor.convert(message, key, mode);

        } else if (algorithm.equals("shift")) {

            encryptor.setStrategy(new ShiftEncryption());
            convertedMassage = encryptor.convert(message, key, mode);
        }


        if (saveMessage) {
           try (FileWriter writer = new FileWriter(file)) {

               writer.write(convertedMassage);

           } catch (Exception e) {

               System.out.println(e.getMessage());
           }
        } else {

            System.out.println(convertedMassage);
        }
    }
}
