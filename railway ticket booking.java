import java.util.*;

class Main {
    static int b = 10, c = 5, tic_no = 4231, p, q, r, ui;
    static String x, y, z;
    static String tname = "Dindigul Express", tno = "9876546321";
    static Scanner s = new Scanner(System.in);
    static int arr[][] = new int[b][c];
    static String trainstop[] = { "Coimbatore", "Salem", "Tiruppur", "Erode", "Kanchepuram" };
    static ArrayList<Book> booklist = new ArrayList<>();
    static ArrayList<User> userlist = new ArrayList<>();
    static ArrayList<Wait> waitlist = new ArrayList<>();
    static int uid = 102, index = 0, ticno = 0, canin = 0;

    public static void main(String[] args) {
        aluser();
        home();

    }

    public static void aluser() {
        userlist.add(new User(1249, "Nigill", "372001"));
    }

    public static void home() {
        System.out.println("1.Admin Login");
        System.out.println("2.User Login");
        System.out.println("3.Exit");
        b = s.nextInt();
        switch (b) {
            case 1: {
                admin();
            }
            case 2: {
                userhome();
            }
            case 3: {
                System.out.println("Thank You for using this app");
            }
        }
    }

    public static void admin() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the User name :");
        x = s.next();
        System.out.println("Enter the Password :");
        y = s.next();
        if (x.equals("admin") && (y.equals("12345"))) {
            adminpage();
        } else {
            System.out.println("Wrong Credenals");
        }
    }

    public static void adminpage() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Train Name :" + tname);
        System.out.println("Train No :" + tno);
        System.out.println("Booking Details");
        System.out.printf("%-10s %-15s %-10s\n", "UserId", "From", "To", "TicketNo");
        for (int i = 0; i < booklist.size(); i++) {
            System.out.printf("%-10s %-15s %-10s\n", booklist.get(i).uid, trainstop[booklist.get(i).dep],
                    trainstop[booklist.get(i).ari], booklist.get(i).ticno);
        }
        System.out.println();
        System.out.println("Seat Filled");
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 5; k++) {
                System.out.printf("%-10s", arr[j][k]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Wait List");
        System.out.printf("%-10s %-15s %-10s\n", "UserId", "From", "To", "TicketNo");
        for (int i = 0; i < waitlist.size(); i++) {
            System.out.printf("%-10s %-15s %-10s\n", waitlist.get(i).uid, trainstop[waitlist.get(i).dep],
                    trainstop[waitlist.get(i).ari], waitlist.get(i).ticno);

        }
        home();
    }

    public static void userhome() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-----Welcome User------");
        System.out.println("1.Log in");
        System.out.println("2.Sign in");
        System.out.println("3.Exit");
        System.out.println("Enter the option :");
        int a = s.nextInt();
        switch (a) {
            case 1: {
                ulog();
            }
            case 2: {
                usig();
            }
            case 3: {
                System.out.println("Welcome");
                home();
            }
        }
    }

    public static void ulog() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the id");
        p = s.nextInt();
        System.out.println("Enter the password");
        x = s.next();
        if (checkuser(userlist, p, x)) {
            userbook();
        } else {
            System.out.println("Please enter the valid credenals");
            userhome();
        }
    }

    public static boolean checkuser(ArrayList<User> userlsit, int p, String x) {
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).uid == p && userlist.get(i).password.equals(p)) {
                ui = i;
                return true;
            }
        }
        return false;
    }

    public static void userbook() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("1.Book Ticket");
        System.out.println("2.View Ticket");
        System.out.println("3.Cancel Ticket");
        System.out.println("4.Exit");
        System.out.println("Enter the option");
        p = s.nextInt();
        switch (p) {
            case 1: {
                booktic();
            }
            case 2: {
                traindetail();
            }
            case 3: {
                canceltic();
            }
            case 4: {
                userhome();
            }
        }
    }

    public static void booktic() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("No of Booking");
        q = s.nextInt();
        for (int i = 0; i < q; i++) {
            int in = 0, din = -1, arin = -1;
            System.out.println("Enter the depature station");
            x = s.next();
            System.out.println("Enter the arrival station");
            y = s.next();
            for (int j = 0; j < trainstop.length; j++) {
                if (trainstop[j].equals(x)) {
                    din = j;
                    in++;
                }
                if (trainstop[j].equals(y)) {
                    arin = j;
                    in++;
                }
            }
            if (in == 2) {
                checkseat(din, arin);
            } else {
                System.out.println("Enter the correct deatail");
                booktic();
            }
        }
        userbook();
    }

    public static boolean checkseat(int din, int arin) {
        int con = 0;
        x: for (int i = 0; i < 10; i++) {
            int sum = 0;
            y: for (int j = din; j < arin; j++) {
                sum += arr[i][j];
            }
            if (sum == 0) {
                System.out.println("Allocated seat" + userlist.get(index).uid + "Seat Number" + i);
                con++;
                booklist.add(new Book(userlist.get(index).uid, din, arin, ++ticno));
                for (int k = din; k < arin; k++) {
                    arr[i][k] += ticno;
                }
                break x;
            }
        }
        if (con == 0) {
            if (waitlist.size() > 5) {
                System.out.println("Sorry Tickets not available");
            } else {
                System.out.println("You are in waitlist");
                waitlist.add(new Wait(userlist.get(index).uid, din, arin, 0));
            }
        }
        System.out.println();
        System.out.println("Seat Filled Deatails");
        for (int l = 0; l < 10; l++) {
            for (int h = 0; h < 5; h++) {
                System.out.printf("%-7s", arr[l][h]);
            }
            System.out.println();
        }
        return false;
    }

    public static void canceltic() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-----Booked Details-----");
        System.out.printf("%-10s %-15s %-15s\n", "UserId", "From", "To", "Ticket No");
        for (int i = 0; i < booklist.size(); i++) {
            if (booklist.get(i).uid == booklist.get(index).uid) {
                System.out.printf("%-10s %-15s %-15s\n", booklist.get(i).uid, trainstop[booklist.get(i).dep],
                        trainstop[booklist.get(i).ari], booklist.get(i).ticno);
            }
        }
        System.out.println("Press 1 to cancel the ticket ");
        int v = s.nextInt();
        int cancount = 0;
        if (v != 1) {
            userbook();
        } else {
            System.out.println("Enter the ticket no to cancel");
            p = s.nextInt();
            for (int i = 0; i < booklist.size(); i++) {
                if (booklist.get(i).uid == userlist.get(index).uid && booklist.get(i).ticno == p) {
                    canin = i;
                    cancelpro();
                }
            }
        }
    }

    public static void cancelpro() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == booklist.get(canin).ticno) {
                    arr[i][j] = 0;
                }
            }
        }
        int remindex = 0;
        System.out.println("Ticket cancelled ");
        z: for (int k = 0; k < waitlist.size(); k++) {
            if (waitlist.get(k).dep >= booklist.get(canin).dep && waitlist.get(k).ari <= booklist.get(canin).ari) {
                x: for (int i = 0; i < 10; i++) {
                    int sum = 0;
                    y: for (int j = waitlist.get(k).dep; j < waitlist.get(i).ari; j++) {
                        sum += arr[i][j];
                    }
                    if (sum == 0) {
                        int waitindex = -1;
                        booklist.add(new Book(waitlist.get(k).uid, waitlist.get(k).dep, waitlist.get(k).ari, ++ticno));
                        for (int m = 0; m < userlist.size(); m++) {
                            if (userlist.get(m).uid == waitlist.get(k).uid) {
                                waitindex = m;
                            }
                        }
                        for (int l = waitlist.get(k).dep; l < waitlist.get(k).ari; l++) {
                            arr[i][l] = ticno;
                        }
                        remindex = k;
                        booklist.remove(canin);
                        waitlist.remove(remindex);
                        break z;
                    }
                }
            }
        }
        userhome();
    }

    public static void traindetail() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Train Name" + tname);
        System.out.println("Train No" + tno);
        System.out.println("Train Travelling cities");
        for (int i = 0; i < 6; i++) {
            System.out.println(trainstop[i]);
            userhome();
        }
    }

    public static void usig() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the user name");
        x = s.next();
        System.out.println("Enter the password");
        y = s.next();
        userlist.add(new User(uid, x, y));
        uid++;
        System.out.println("User created sucessful");
        userhome();
    }
}

class Book {
    int uid, dep, ari, ticno;

    public Book(int uid, int dep, int ari, int ticno) {
        this.uid = uid;
        this.dep = dep;
        this.ari = ari;
        this.ticno = ticno;
    }
}

class Wait {
    int uid, dep, ari, ticno;

    public Wait(int uid, int dep, int ari, int ticno) {
        this.uid = uid;
        this.dep = dep;
        this.ari = ari;
        this.ticno = ticno;
    }
}

class User {
    int uid;
    String name, password;

    public User(int uid, String name, String password) {
        this.uid = uid;
        this.name = name;
        this.password = password;
    }
}