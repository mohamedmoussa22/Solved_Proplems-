public class CLEANSTRING {
    public static StringBuilder cleanString(String input) {

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 65 && input.charAt(i) <= 90) {
                output.append(Character.toLowerCase(input.charAt(i)));
            } else if (input.charAt(i) >= 97 && input.charAt(i) <= 122
                    || input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                output.append(input.charAt(i));
            }

        }
        return output;
    }
}
