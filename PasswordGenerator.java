import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+";
    private static final String ALL_CHARACTERS = UPPER + LOWER + DIGITS + SPECIAL;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();
        
        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include digits? (yes/no): ");
        boolean includeDigits = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("yes");
        
        String password = generatePassword(length, includeUppercase, includeLowercase, includeDigits, includeSpecial);
        
        System.out.println("Generated Password: " + password);
    }
    
    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, 
                                          boolean includeDigits, boolean includeSpecial) {
        StringBuilder characterSet = new StringBuilder();
        
        if (includeUppercase) {
            characterSet.append(UPPER);
        }
        if (includeLowercase) {
            characterSet.append(LOWER);
        }
        if (includeDigits) {
            characterSet.append(DIGITS);
        }
        if (includeSpecial) {
            characterSet.append(SPECIAL);
        }
        
        if (characterSet.length() == 0) {
            throw new IllegalArgumentException("At least one character type must be selected.");
        }
        
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(index));
        }
        
        return password.toString();
    }
}
