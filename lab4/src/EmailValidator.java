public class EmailValidator {
    public static void checkEmailFormat(String email) throws CustomEmailFormatException {
        if (!email.contains("@")) {
            throw new CustomEmailFormatException("Email address is missing '@' symbol");
        }
    }

    public static void main(String[] args) {
        String email = "example.com";

        try {
            EmailValidator.checkEmailFormat(email);
            System.out.println("Email format is valid");
        } catch (CustomEmailFormatException e) {
            System.out.println("Invalid email format: " + e.getMessage());
        }
    }
}

