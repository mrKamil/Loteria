package Loteria;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Kamil on 2017-05-10.
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Podaj ile liczb chcesz wylosować: ");

            int iloscLiczb = in.nextInt();
            System.out.print("Z przedziału ilu liczb ma być wykonane losowanie? ");
            int przedzial = in.nextInt();

            if (przedzial < iloscLiczb) {
                System.out.println("Nie można wylosować więcej liczb niż jest w przedziale.");
                System.exit(0);
            } else if (iloscLiczb <= 0) {
                System.out.println("Szkoda, że nie chcesz sprawdzić swoich szans :(");
                System.exit(0);
            }
            BigInteger loteria = BigInteger.valueOf(1);
            for (int i = 1; i <= iloscLiczb; i++)

                loteria = loteria.multiply(BigInteger.valueOf(przedzial - i + 1)).divide(BigInteger.valueOf(i));
            System.out.println("Szanse na wygranie w loterii to 1 do " + loteria);
        } catch (InputMismatchException e) {
            System.out.println("Błędnie podano liczbę lub podano zbyt dużą liczbę.");
        }
    }
}