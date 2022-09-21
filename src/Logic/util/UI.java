package Logic.util;

import Logic.Entitet.Bog;

import java.util.List;
import java.util.Scanner;

public class UI
{
    public static void udskriv (List<Bog> bogList) {

        for (Bog bog : bogList) {

            System.out.println(bog.toString());

        }


    }

    public static String getString(String s) {

        System.out.println(s + " : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    public static int getInt (String s) {

        while (true) {

            try {
                int res = Integer.parseInt(getString(s));
                return res;
            } catch (NumberFormatException e) {
                System.out.println("husk det skal være et til !");
            }
        }


    }
}
