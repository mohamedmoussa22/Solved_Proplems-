public class DECIMALTOBINARY {
    public static String decimalToBinary(int num) {
        if (num == 0) {
            return "";
        }
        if (num % 2 == 0) {
            return decimalToBinary(num / 2) + "0";
        }
        return decimalToBinary(num / 2) + "1";

    }
}