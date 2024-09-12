import java.math.BigDecimal;
import java.util.*;

public class number_operations
{
    public static void main(String[] args)
    {
        ArrayList<Number> tlist = new ArrayList<>();

        Number[] nums = {10, 20.5, 30, 40.7, 50, 60.3, 70, 80.1, 90, 100.9};
        int num1 = 2;
        double num2 = 56.262;
        float num3 = 12.4f;
        long num4 = 204;
        double num5 = 12.0;
        byte num6 = 13;
        BigDecimal num7 = new BigDecimal("12020200202");

        Collections.addAll(tlist, nums);
        tlist.add(num1);
        tlist.add(num2);
        tlist.add(num3);
        tlist.add(num4);
        tlist.add(num5);
        tlist.add(num6);
        tlist.add(num7);

        System.out.println("\nWhole list: " + tlist + "\n");

        System.out.print("Numbers as integers: [");
        for (Number x : tlist)
        {
            String value = String.valueOf(x);
            if (String.valueOf(x).contains("."))
                value = String.valueOf(Math.round(x.doubleValue()));

            if (tlist.indexOf(x) != tlist.size() - 1)
                System.out.print(value + ", ");
            else
                System.out.print(value + "]");
        }

        System.out.print("\n\nNumbers formatted with 2 decimals: [");
        for (Number x : tlist)
        {
            String value = String.format("%.2f", x.doubleValue()).replace(",", ".");
            if (tlist.indexOf(x) != tlist.size() - 1)
                System.out.print(value + ", ");
            else
                System.out.print(value + "]");
        }

        HashMap<Class<? extends Number>, ArrayList<Number>> num_lists = new HashMap<>();


        for (Number x : tlist)
        {
            num_lists.putIfAbsent(x.getClass(), new ArrayList<>());
            num_lists.get(x.getClass()).add(x);
        }

        System.out.println("\n");
        for (Map.Entry<Class<? extends Number>, ArrayList<Number>> x : num_lists.entrySet())
            System.out.println(String.valueOf(x.getKey()).substring(16) + " list: " + x.getValue());

        ArrayList<Number> integers = new ArrayList<>();

        for (Number x : tlist)
            if (x.doubleValue() % 1 == 0)
                integers.add(x);

        System.out.println("\nAll integers in a separate list: " + integers);

    }
}