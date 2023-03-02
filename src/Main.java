import java.security.InvalidParameterException;

public class Main {

    static java.util.Scanner in;
    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        short size = Short.parseShort(in.nextLine());
        String[] textNumbers = in.nextLine().split(" ");

        short[] numbers = new short[textNumbers.length];

        if (size > numbers.length) return;

        for (int i = 0; i < numbers.length; i++ ) {
            numbers[i] = Short.parseShort(textNumbers[i]);
        }

        System.out.println(findLostPiece(size, numbers));
    }

    public static short findLostPiece(short total, short[] pieces) {
        if (total == pieces.length) {
            throw new InvalidParameterException("No hay piezas faltantes");
        }

        short[] sorted = sortIntegerArray(pieces);
        short lost = sorted[sorted.length - 1];
        for (short i = 0; i < sorted.length-1; i++) {
            if (sorted[i] + 1 != sorted[i + 1]) {
                lost = (short) (sorted[i] + 1);
            }
        }
        return lost;
    }

    private static short[] sortIntegerArray(short[] numbers)
    {
        if (validateSort(numbers)) {
            return numbers;
        }

        for (short i = 0; i < numbers.length-1; i++) {
            if (numbers[i + 1] < numbers[i]) {
                short aux = numbers[i + 1];
                numbers[i + 1] = numbers[i];
                numbers[i] = aux;
            }
        }

        return sortIntegerArray(numbers);
    }

    private static boolean validateSort(short[] numbers) {
        short minor = Short.MIN_VALUE;
        for (short number : numbers) {
            if (number >= minor) {
                minor = number;
            } else {
                return false;
            }
        }
        return true;
    }
}