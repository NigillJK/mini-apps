import java.util.*;

class Amazon {
    static Scanner s = new Scanner(System.in);
    static ArrayList<Vendor> al = new ArrayList<>();
    static ArrayList<Customer> bl = new ArrayList<>();
    static ArrayList<Product> pro = new ArrayList<>();
    static ArrayList<String> signup = new ArrayList<>();
    static ArrayList<Integer> signc = new ArrayList<>();
    static ArrayList<Product> allp = new ArrayList<>();
    static ArrayList<Product> cart = new ArrayList<>();
    static ArrayList<String> type = new ArrayList<>();
    static String vali = "";
    static int index, index1, pi, ci, si;

    public static void main(String[] args) {
        vendorlist();
        cuslist();
        home();
    }

    public static void home() {
        System.out.println("\t\t\tWelcome !!!  \n\tplease select your Designation\n");
        System.out.println("1. Admin");
        System.out.println("2. Vendor");
        System.out.println("3. Customer");
        System.out.println("4. Exit");
        int a = s.nextInt();
        flush();
        switch (a) {
            case 1: {
                admin();
            }
            case 2: {
                vhome();
            }
            case 3: {
                chome();
            }
            default: {
                System.out.println("See you again later");

            }
        }
    }

    public static void admin() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("UserName : ");
        s.nextLine();
        String name = s.nextLine();
        System.out.println("Password : ");
        String password = s.nextLine();
        flush();
        if (name.equals("admin") && password.equals("12345"))
            admin1();
        else {
            System.out.println("Please Enter Valid Login Credentials");
            home();
        }
    }

    public static void admin1() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Welcome !!!\n");
        System.out.println("1. Add Vendor");
        System.out.println("2. Remove Vendor");
        System.out.println("3. Approve");
        System.out.println("4. View Vendor");
        System.out.println("5. Exit");
        int a = s.nextInt();
        flush();
        switch (a) {
            case 1: {
                addvendor();
            }
            case 2: {
                removevendor();
            }
            case 3: {
                approvevendor();
            }
            case 4: {
                viewvendor();
            }
            default: {
                home();
            }
        }
    }

    public static void addvendor() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter Vendor name");
        s.nextLine();
        String name = s.nextLine();
        System.out.println("Enter password");
        String pass = s.nextLine();
        int id = al.size() + 1;
        System.out.println("Enter Type");
        s.nextLine();
        String type = s.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        ArrayList<Product> pro = new ArrayList<>();
        al.add(new Vendor(name, pass, id, type, pro));
        System.out.println("Vendor added Successfully ");
        admin1();
    }

    public static void removevendor() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter Vendor name");
        s.nextLine();
        String pn = s.nextLine();
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).name.equals(pn)) {
                al.remove(i);
                break;
            }
        }
        System.out.println("Vendor removed Successfully ");
        admin1();
    }

    public static void viewvendor() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < al.size(); i++) {
            System.out
                    .println(al.get(i).name + "\t" + al.get(i).id + "\t" + al.get(i).password + "\t" + al.get(i).type);
        }
        admin1();
    }

    public static void approvevendor() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < signup.size(); i++) {
            System.out.println(signup.get(i));
            s.nextLine();
            String st = s.nextLine();
            if (st.equals("yes")) {
                signc.set(i, 1);
                System.out.println("Approved");
            } else if (st.equals("wait")) {
                System.out.println("Waiting");
            } else {
                signc.set(i, 0);
                System.out.println("Declined");
            }
        }
    }

    public static void vhome() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Welcome !!!\n");
        System.out.println("1. Sign in");
        System.out.println("2. Sign up");
        System.out.println("3. Cancel");
        int a = s.nextInt();
        flush();
        switch (a) {
            case 1: {
                vsignin();
            }
            case 2: {
                vsignup();
            }
            case 3: {
                home();
            }
            default: {
                System.out.println("Wrong choice");
            }
        }
    }

    public static void vsignin() {
        System.out.println("UserName : ");
        s.nextLine();
        String name = s.nextLine();
        System.out.println("Password : ");
        String password = s.nextLine();
        if (checkVen(name, password)) {
            trueven();
        } else {
            vali = name + " " + password + " ";
            if (signup.isEmpty() || signc.isEmpty()) {
                System.out.println("Please Enter Valid Login Credentials\n If your are new Vendor please Singup");
                vhome();
            } else if (checkSignUp(vali) && signc.get(index1) == -1) {
                System.out.println("Waiting for approval");
                vhome();
            } else if (signc.get(index1) == 1) {
                signc.remove(index1);
                signup.remove(index1);
                index = -1;
                int ar = al.size() + 1;
                s.nextLine();
                System.out.println("Enter the type of Product you are Selling");
                String st = s.nextLine();
                ArrayList<Product> pro = new ArrayList<>();
                al.add(new Vendor(name, password, ar, st, pro));
                trueven();
            }
        }
    }

    public static void trueven() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Welcome !!!\n");
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product");
        System.out.println("3. View Product Details");
        System.out.println("4. Edit Product Details");
        System.out.println("5. Exit");
        int a = s.nextInt();
        flush();
        switch (a) {
            case 1: {
                addpro();
            }
            case 2: {
                rempro();
            }
            case 3: {
                System.out.println("Name\ttype\tprice\tquant\tsale\tret\n");
                viewpro();
                trueven();
            }
            case 4: {
                editpro();
                trueven();
            }
            default: {
                home();
            }
        }
    }

    public static void addpro() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter Product name");
        s.nextLine();
        String pn = s.nextLine();
        System.out.println("Enter Product type");
        String t = s.nextLine();
        if (!type.contains(t))
            type.add(t);
        System.out.println("Enter the Price of the Product");
        int pp = s.nextInt();
        System.out.println("Enter the Quantity of the Product");
        int q = s.nextInt();
        System.out.println("Enter the no of days to return (if no return : -1)");
        int ret = s.nextInt();
        al.get(index).pro.add(new Product(pn, t, pp, q, 0, ret));
        allp.add(new Product(pn, t, pp, q, 0, ret));
        System.out.println("Product Added Successfully ");
        trueven();
    }

    public static void rempro() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter Product name");
        s.nextLine();
        String pn = s.nextLine();
        for (int i = 0; i < al.get(index).pro.size(); i++) {
            if (al.get(index).pro.get(i).name.equals(pn)) {
                al.get(index).pro.remove(i);
                break;
            }
        }
        for (int i = 0; i < allp.size(); i++) {
            if (allp.get(i).name.equals(pn)) {
                allp.remove(i);
                break;
            }
        }
        System.out.println("Product removed Successfully ");
        trueven();
    }

    public static void viewpro() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < al.get(index).pro.size(); i++) {
            System.out.println(al.get(index).pro.get(i));
        }
        System.out.println("\nPress Enter to continue");
        s.nextLine();
        String st = s.nextLine();
        trueven();
    }

    public static boolean checkVen(String name, String password) {
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).name.equals(name) && al.get(i).password.equals(password)) {
                index = i;
                return true;
            }
        }
        return false;
    }

    public static void editpro() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the product name : ");
        s.nextLine();
        String name = s.nextLine();
        if (checkpro(al.get(index).pro, name))
            trueedit();
        else {
            System.out.println("Wrong product name ");
            trueven();
        }
    }

    public static void trueedit() {
        System.out.println("Choose the detail to edit");
        System.out.println("1. Name of the product");
        System.out.println("2. Type of the product");
        System.out.println("3. Price of the product");
        System.out.println("4. Quantity of the product");
        System.out.println("5. return days of the product");
        System.out.println("6. Exit");
        int a = s.nextInt();
        switch (a) {
            case 1: {
                System.out.println("Enter new Name : ");
                s.nextLine();
                String n = s.nextLine();
                al.get(index).pro.get(pi).name = n;
                allp.get(si).name = n;
                break;
            }
            case 2: {
                System.out.println("Enter new Type : ");
                s.nextLine();
                String n = s.nextLine();
                al.get(index).pro.get(pi).type = n;
                allp.get(si).type = n;
                break;
            }
            case 3: {
                System.out.println("Enter new Price : ");
                int n = s.nextInt();
                al.get(index).pro.get(pi).price = n;
                allp.get(si).price = n;
                break;
            }
            case 4: {
                System.out.println("Enter new Quantity : ");
                int n = s.nextInt();
                al.get(index).pro.get(pi).quant = n;
                allp.get(si).quant = n;
                break;
            }
            case 5: {
                System.out.println("Enter new Return : ");
                int n = s.nextInt();
                al.get(index).pro.get(pi).ret = n;
                allp.get(si).ret = n;
                break;
            }
            default: {
                System.out.println("enter a valid choice ");
                vhome();
            }
        }
    }

    public static boolean checkpro(ArrayList<Product> pro, String name) {
        for (int i = 0; i < pro.size(); i++) {
            if (pro.get(i).name.equals(name)) {
                pi = i;
                return true;
            }
        }
        return false;
    }

    public static void vsignup() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("UserName : ");
        s.nextLine();
        String name = s.nextLine();
        System.out.println("Password : ");
        String password = s.nextLine();
        if (checkVen(name, password)) {
            System.out.println("You have signup already");
            vhome();
        } else {
            vali = name + " " + password + " ";
            if (checkSignUp(vali)) {
                if (signc.get(index1) == 1) {
                    signc.remove(index1);
                    signup.remove(index1);
                    index = -1;
                    int ar = al.size() + 1;
                    System.out.println("Enter the type of Product you are Selling");
                    String st = s.nextLine();
                    ArrayList<Product> pro = new ArrayList<>();
                    al.add(new Vendor(name, password, ar, st, pro));
                    vhome();
                } else if (signc.get(index1) == -1) {
                    System.out.println("Waiting for approval");
                    vhome();
                } else {
                    System.out.println("Sorry u are not authorized");
                    vhome();
                }
            } else {
                signup.add(vali);
                signc.add(-1);
                System.out.println("Waiting for approval");
                vhome();
            }
        }
    }

    public static boolean checkSignUp(String vali) {
        for (int i = 0; i < signup.size(); i++) {
            if (signup.get(i).equals(vali)) {
                index1 = i;
                return true;
            }
        }
        return false;
    }

    public static void chome() {
        System.out.println("Welcome !!!\n");
        System.out.println("1. Sign in");
        System.out.println("2. Sign up");
        System.out.println("3. Cancel");
        int a = s.nextInt();
        flush();
        switch (a) {
            case 1: {
                csignin();
                break;
            }
            case 2: {
                csignup();
                break;
            }
            case 3: {
                home();
                break;
            }
            default: {
                System.out.println("Wrong choice");
                break;
            }
        }
    }

    public static void csignin() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("UserName : ");
        s.nextLine();
        String name = s.nextLine();
        System.out.println("Password : ");
        String password = s.nextLine();
        if (checkcus(name, password)) {
            truecus();
        } else {
            System.out.println("Wrong login Credentials");
            chome();
        }
    }

    public static void csignup() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("UserName : ");
        s.nextLine();
        String name = s.nextLine();
        System.out.println("Password : ");
        String password = s.nextLine();
        flush();
        if (checkcus(name, password)) {
            System.out.println("Already signed in");
            chome();
        } else {
            bl.add(new Customer(name, password, new ArrayList<>(), 0, new ArrayList<>()));
            System.out.println("Account created sucessfully");
            chome();
        }
    }

    public static boolean checkcus(String name, String password) {
        for (int i = 0; i < bl.size(); i++) {
            if (bl.get(i).name.equals(name) && bl.get(i).password.equals(password)) {
                ci = i;
                return true;
            }
        }
        return false;
    }

    public static void truecus() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Welcome !!!");
        System.out.println("1. Search products");
        System.out.println("2. Filter product");
        System.out.println("3. View cart");
        System.out.println("4. View OrderList");
        System.out.println("5. Exit");
        int a = s.nextInt();
        switch (a) {
            case 1: {
                search();
                break;
            }
            case 2: {
                filter();
                break;
            }
            case 3: {
                cart();
                break;
            }
            case 4: {
                order();
                break;
            }
            default: {
                chome();
                break;
            }
        }
    }

    public static void search() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        s.nextLine();
        System.out.println("Search for the product : ");
        String a = s.nextLine();
        for (int i = 0; i < allp.size(); i++) {
            if (allp.get(i).name.contains(a)) {
                System.out.println(allp.get(i).name);
            }
        }
        System.out.println("Select a product");
        String g = s.nextLine();
        int check = 0;
        for (int i = 0; i < allp.size(); i++) {
            if (allp.get(i).name.equals(g)) {
                si = i;
                check = 1;
                break;
            }
        }
        if (check == 1)
            proConfirm();
        else {
            System.out.println("No such product found");
        }
        truecus();
    }

    public static void filter() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < type.size(); i++) {
            System.out.println((i + 1) + " " + type.get(i));
        }
        System.out.println("Select a filter");
        int g = s.nextInt();
        for (int i = 0; i < allp.size(); i++) {
            if (allp.get(i).type.equals(type.get(g - 1))) {
                System.out.println(allp.get(i).name);
            }
        }
        s.nextLine();
        System.out.println("Select a product");
        String k = s.nextLine();
        int check = 0;
        for (int i = 0; i < allp.size(); i++) {
            if (allp.get(i).name.equals(k)) {
                si = i;
                check = 1;
                break;
            }
        }
        if (check == 1)
            proConfirm();
        else {
            System.out.println("No such product found");
        }
        truecus();
    }

    public static void proConfirm() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Name : " + allp.get(si).name);
        System.out.println("Price : " + allp.get(si).price);
        System.out.println("Price  : " + (double) (allp.get(si).price));
        if (allp.get(si).ret > 0)
            System.out.println("Return availablity : " + allp.get(si).ret + "days");
        else
            System.out.println("no return");
        System.out.println("Type : " + allp.get(si).type);
        if (allp.get(si).quant == 0)
            System.out.println("Out of Stock");
        else if (allp.get(si).quant < 10)
            System.out.println("Limited Stock");
        else
            System.out.println("Stock available\n");
        System.out.println("1. Add to cart");
        System.out.println("2. Go back");
        int a = s.nextInt();
        switch (a) {
            case 1:
                acart();
                break;
            default:
                truecus();
                break;
        }
    }

    public static void acart() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        bl.get(ci).cart.add(allp.get(si));
        System.out.println("Product added to cart");
        truecus();
    }

    public static void cart() {
        System.out.println("Product\tPrice");
        for (int i = 0; i < bl.get(ci).cart.size(); i++) {
            System.out.println(bl.get(ci).cart.get(i).name + "\t" + bl.get(ci).cart.get(i).price);
        }
        System.out.println("1. Buy now");
        System.out.println("2. Remove item");
        System.out.println("3. Go back");
        int a = s.nextInt();
        switch (a) {
            case 1: {
                buynow();
                break;
            }
            case 2: {
                remitem();
                break;
            }
            default: {
                truecus();
                break;
            }
        }
    }

    public static void buynow() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        int cost = 0;
        for (int i = 0; i < bl.get(ci).cart.size(); i++) {
            System.out.println("Order details");
            System.out.println("Product : " + bl.get(ci).cart.get(i).name);
            System.out.println("Price : " + (bl.get(ci).cart.get(i).price));
            cost += bl.get(ci).cart.get(i).price;
            changeinvendor(bl.get(ci).cart.get(i).name);
            bl.get(ci).order.add(bl.get(ci).cart.get(i));
        }
        s.nextLine();
        System.out.println("Press Enter to confirm the order");
        String s1 = s.nextLine();
        if (cost <= bl.get(ci).wallet) {
            bl.get(ci).wallet -= cost;
            System.out.println("Order was sucessfull");
            bl.get(ci).cart.clear();
        } else {
            System.out.println("Your wallet amount is low");
        }
        truecus();
    }

    public static void changeinvendor(String name) {
        a: for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.get(i).pro.size(); j++) {
                if (al.get(i).pro.get(j).name.equals(name)) {
                    al.get(i).pro.get(j).sale += 1;
                    al.get(i).pro.get(j).quant -= 1;
                    break a;
                }
            }
        }
    }

    public static void remitem() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the product name to remove");
        s.nextLine();
        String a = s.nextLine();
        for (int i = 0; i < bl.get(ci).cart.size(); i++) {
            if (bl.get(ci).cart.get(i).name.equals(s)) {
                bl.get(ci).cart.remove(i);
                break;
            }
        }
        truecus();
    }

    public static void order() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < bl.get(ci).order.size(); i++) {
            System.out.println(bl.get(ci).order.get(i).name);
            System.out.println(bl.get(ci).order.get(i).price);
        }
        System.out.println("\n1. Cancel product");
        System.out.println("2. Return product");
        System.out.println("3. Go back");
        int a = s.nextInt();
        flush();
        switch (a) {
            case 1: {
                cancel();
                break;
            }
            case 2: {
                returnpro();
                break;
            }
            default: {
                truecus();
                break;
            }
        }
    }

    public static void cancel() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the product name to cancel order");
        s.nextLine();
        String can = s.nextLine();
        for (int i = 0; i < bl.get(ci).order.size(); i++) {
            if (bl.get(ci).order.get(i).name.equals(can)) {
                bl.get(ci).order.remove(i);
                break;
            }
        }
        a: for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.get(i).pro.size(); j++) {
                if (al.get(i).pro.get(j).name.equals(can)) {
                    al.get(i).pro.get(j).sale -= 1;
                    al.get(i).pro.get(j).quant += 1;
                    break a;
                }
            }
        }
        truecus();
    }

    public static void returnpro() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the product name to Return");
        s.nextLine();
        String can = s.nextLine();
        for (int i = 0; i < bl.get(ci).order.size(); i++) {
            if (bl.get(ci).order.get(i).name.equals(can)) {
                bl.get(ci).order.remove(i);
                break;
            }
        }
        a: for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.get(i).pro.size(); j++) {
                if (al.get(i).pro.get(j).name.equals(can)) {
                    al.get(i).pro.get(j).sale -= 1;
                    al.get(i).pro.get(j).quant += 1;
                    break a;
                }
            }
        }
        truecus();
    }

    public static void flush() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void vendorlist() {
        al.add(new Vendor("john", "1234", 1, "sports", new ArrayList<>()));
        al.add(new Vendor("rithiesh", "1243", 2, "accesories", new ArrayList<>()));
    }

    public static void cuslist() {
        bl.add(new Customer("Nigill", "1234", new ArrayList<>(), 12000, new ArrayList<>()));
        bl.add(new Customer("Yasir", "1324", new ArrayList<>(), 13000, new ArrayList<>()));
        bl.add(new Customer("Piranav", "4132", new ArrayList<>(), 14000, new ArrayList<>()));
    }
}

class Vendor {
    String name, password, type;
    int id;
    ArrayList<Product> pro;

    Vendor(String name, String password, int id, String type, ArrayList<Product> pro) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.type = type;
        this.pro = new ArrayList<>(pro);
    }
}

class Product {
    String name, type;
    int price, quant, sale, waranty, offer, ret;

    Product(String name, String type, int price, int quant, int sale, int ret) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.quant = quant;
        this.sale = sale;
        this.ret = ret;
    }

    public String toString() {
        return name + "\t" + type + "\t" + price + "\t" + quant + "\t" + sale + "\t" + ret + "\t";
    }
}

class Customer {
    String name, password;
    int wallet;
    ArrayList<Product> cart, order;

    Customer(String name, String password, ArrayList<Product> cart, int wallet, ArrayList<Product> order) {
        this.name = name;
        this.password = password;
        this.cart = new ArrayList<>(cart);
        this.wallet = wallet;
        this.order = new ArrayList<>(order);
    }
}
