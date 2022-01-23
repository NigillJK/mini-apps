import java.util.*;

public class splitwise {
    static Scanner s = new Scanner(System.in);
    static int a, b, c, d, wallet;
    static String x, y, z, name;
    static ArrayList<String> arr = new ArrayList<>();
    static ArrayList<String> brr = new ArrayList<>();
    static ArrayList<Integer> crr = new ArrayList<>();
    static ArrayList<Integer> drr = new ArrayList<>();
    static String Trans;

    public static void main(String[] args) {
        friends();
        home();

    }

    public static void friends() {
        arr.add("Nigill");
        brr.add("372001");
        crr.add(10000);
        drr.add(0);
        arr.add("Yasir");
        brr.add("2332001");
        crr.add(12000);
        drr.add(0);
    }

    public static void home() {
        System.out.println("-----Welcome to the Split wise app-----");
        System.out.println("1.Group");
        System.out.println("2.Expenses");
        System.out.println("3.Exit");
        System.out.println("Please enter the option");
        a = s.nextInt();
        switch (a) {
            case 1: {
                group();
            }
            case 2: {
                System.out.println(Trans);
            }
            case 3: {
                System.out.println("Thank you for your visit");
            }
        }
    }

    public static void group() {
        System.out.println("------Welcome to the Group------");
        System.out.println("Enter the name");
        x = s.next();
        System.out.println("Enter the password");
        y = s.next();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(x) && brr.get(i).equals(y)) {
                d = i;
                userhome();
            }
        }
        name = x;
    }

    public static void userhome() {
        wallet = crr.get(d);
        System.out.println("Welcome" + name);
        System.out.println("1.Pay rent");
        System.out.println("2.View debt");
        System.out.println("3.Pay debt");
        System.out.println("4.Add amount to wallet");
        System.out.println("5.Add Friends");
        System.out.println("6.Remove friends");
        System.out.println("7.Exit");
        System.out.println("Enter the choice");
        a = s.nextInt();
        switch (a) {
            case 1: {
                rent();
            }
            case 2: {
                System.out.println(drr.get(d));
            }
            case 3: {
                paydebt();
            }
            case 4: {
                addwallet();
            }
            case 5: {
                addfriends();
            }
            case 6: {
                removefriends();
            }
            case 7: {
                home();
            }
        }
    }

    public static void rent() {
        System.out.println("Enter the amount for rent");
        b = s.nextInt();
        if (b <= wallet) {
            String ab = "The amount paid by" + name + "is" + b;
            Trans += ab;
            int amount = b / arr.size();
            for (int i = d + 1; i < arr.size(); i++) {
                int loan = amount;
                drr.set(i, loan);
            }
            System.out.println("Amount of" + b + "is paid");
            wallet = crr.get(d) - b;
            crr.set(d, wallet);
        }
    }

    public static void paydebt() {
        System.out.println("Debt in yout account is");
        System.out.println(drr.get(d));
        System.out.println("Enter the amount to pay");
        c = s.nextInt();
        int deb = crr.get(d) - c;
        crr.set(d, deb);
    }

    public static void addwallet() {
        System.out.println("Enter the amount to add");
        int amo = s.nextInt();
        amo += crr.get(d);
        crr.set(d, amo);
    }

    public static void addfriends() {
        System.out.println("Enter the number of friends to add");
        int num = s.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.println("Enter the name of the friend");
            String na = s.next();
            System.out.println("Enter the password");
            String pa = s.next();
            arr.add(na);
            brr.add(pa);
            crr.add(0);
            drr.add(0);
        }
    }

    public static void removefriends() {
        System.out.println("Enter the name to remove");
        y = s.next();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(y)) {
                arr.remove(arr.get(i));
                brr.remove(brr.get(i));
                crr.remove(crr.get(i));
                drr.remove(drr.get(i));
            }
        }
    }
}