Description

Program that encrypt and decrypt messages and texts using two different algorithms. The first one shifts each letter by the specified number according to its order in the alphabet in circle. The second one is based on Unicode table. Program works with command-line arguments and has the ability to read and write original and cipher data to files

List of arguments:

    • -mode - determine the program’s mode, enc for encryption, dec for decryption. Default value is enc.
    • -key - an integer key to modify the message. Default value is 0.
    • -data - text or ciphertext to encrypt or decrypt. Default value is an empty string.
    • -in - the full name of a file to read data from. If there are both -data and -in arguments, program prefers -data over -in.
    • -out - full name of a file to write the result. If there is no -out argument, the program prints data to the standard output.
    • -alg – specifies algorithm to use: shift or unicode.  Default value is shift

Example:

    • java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode

This command gets data from the file road_to_treasure.txt, encrypts the data with the key 5, creates a file called protected.txt and writes ciphertext to it.
