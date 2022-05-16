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
>>>>>>> b0249b70864448f13209787cdec6ed4ef7b62860
