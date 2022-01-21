import java.util.*;
class Main{
    static Scanner s=new Scanner(System.in);
    int a,b,c,da;
    String x,y,z,boc;
    static int id=153,uid=987;
    static ArrayList<String> a1=new ArrayList<>();//adminusername
    static ArrayList<String>a2=new ArrayList<>();//admin password
    static ArrayList<String> b1=new ArrayList<>();//book
    static ArrayList<String> b2=new ArrayList<>();//type
    static ArrayList<String> b3=new ArrayList<>();//count;
    static ArrayList<Integer> b4=new ArrayList<>();//bookid
    static ArrayList<String> b5=new ArrayList<>();//bookprice
    static ArrayList<String> c1=new ArrayList<>();//add to cart
    static ArrayList<String> c2=new ArrayList<>();//userid
    static ArrayList<String> d1=new ArrayList<>();//username
    static ArrayList<String> d2=new ArrayList<>();//userpin
    static ArrayList<String> d3=new ArrayList<>();//userid
    static ArrayList<String> e1=new ArrayList<>();//useracc
    static ArrayList<String> e2=new ArrayList<>();//borrow
    static ArrayList<String> e3=new ArrayList<>();
    public static void main(String[] args){
        home();
    }
    public static void home(){
        System.out.println("Welcome to the Library");
        System.out.println("1.Admin");
        System.out.println("2.Student");
        System.out.println("3.Exit");
        System.out.println("Enter the choice");
        a=s.nextInt();
        switch(a){
            case 1:{
                admin();
            }
            case 2:{
                student();
            }
            case 3:{
                System.out.println("Thanks for using the Library");
            }
        }
    }
    public static void admin(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Welcome Admin");
        System.out.println("Enter the user name");
        x=s.next();
        System.out.println("Enter the password");
        y=s.next();
        if(x.equals("admin")&& y.equals("12345")){
            adminhome();
        }
        else{
            Sytem.out.println("Please enter the correct details");
            admin();
        }
    }
    public static void adminhome(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("1.Add Book");
        System.out.println("2.View Book");
        System.out.println("3.Delete Book");
        System.out.println("4.Edit stock");
        System.out.println("5.View Sold Book");
        System.out.println("6.Exit");
        System.out.println("Enter the choice");
        a=a.nextInt();
        switch(a){
            case 1:{
                addbook();
            }
            case 2:{
                viewbook();
            }
            case 3:{
                deletebook();
            }
            case 4:{
                edit();
            }
            case 5:{
                viewsold();
            }
            case 6:{
                System.out.println("Thank You!");
                x=s.next();
                adminhome();
            }
        }
    }
    public static void addbook(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the book name");
        x=s.next();
        System.out.println("Choose the book type");
        System.out.println("1.Civil");
        System.out.println("2.Cse");
        System.out.println("3.Ece");
        System.out.println("4.Mech");
        System.out.println("5.Chem");
        System.out.println("6.Eee");
        System.out.println("7.Bme");
        System.out.println("Enter the choice");
        a=s.nextInt();
        System.out.println("Enter the book quantity");
        z=s.next();
        System.out.println("Enter the book price");
        String v=s.next();
        switch(a){
            case 1:{
                civil();
            }
            case 2:{
                cse();
            }
            case 3:{
                ece();
            }
            case 4:{
                mech();
            }
            case 5:{
                chem();
            }
            case 6:{
                eee();
            }
            case 7:{
                bme();
            }
        }
    }
    public static void civil(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        b1.add(x);
        b2.add("Civil");
        b3.add(z);
        b4.add(id);
        b5.add(v);
        id++;
    }
    public static void cse(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        b1.add(x);
        b2.add("Cse");
        b3.add(z);
        b4.add(id);
        b5.add(v);
        id++;
    }
    public static void ece(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        b1.add(x);
        b2.add("Ece");
        b3.add(z);
        b4.add(id);
        b5.add(v);
        id++;
    }
    public static void mech(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        b1.add(x);
        b2.add("Mech");
        b3.add(z);
        b4.add(id);
        b5.add(v);
        id++;
    }
    public static void chem(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        b1.add(x);
        b2.add("Chem");
        b3.add(z);
        b4.add(id);
        b5.add(v);
        id++;
    }
    public static void eee(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        b1.add(x);
        b2.add("Eee");
        b3.add(z);
        b4.add(id);
        b5.add(v);
        id++;
    }
    public static void bme(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        b1.add(x);
        b2.add("Bme");
        b3.add(z);
        b4.add(id);
        b5.add(v);
        id++;
    }
    public static void viewbook(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if(b1.size()<1){
            System.out.println("No more books in the library");
        }
        else{
            System.out.printf("%-10s %-10s %-10s %-10s\n","Book Name","Book Type","Book Quantity","Book Price");
            for(int i=0;i<b1.size();i++){
                System.out.println("%-10s %-10s %-10s %-10s\n",b1.get(i),b2.get(i),b3.get(i),b5.get(i));
            }
        }
        adminhome();
    }
    public static void deletebook(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
            System.out.printf("%-10s %-10s %-10s\n","Book Id","Book Name","Book Type");
            for(int i=0;i<b4.size();i++){
            System.out.printf("%-10s %-10s %-10s\n",b4.get(i),b1.get(i),b2.get(i));
        }
        System.out.println("Enter the book id to delete");
        a=s.nextInt();
        b=b4.indexOf(a);
        b1.remove(b);
        b2.remove(b);
        b3.remove(b);
        b4.remove(b);
        b5.remove(b);
        System.out.println();
        System.out.println("Book Deleted Sucessfully");
        adminhome();
    }
    public static void edit(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("%-10s %-10s %-10s %-10s %-10s\n","Name","Type","Count","Id","Price");
        for(int i=0;i<b4.size();i++){
            System.out.printf("%-10s %-10s %-10s %-10s %-10s\n",b1.get(i),b2.get(i),b3.get(i),b4.get(i),b5.get(i));
        }
        System.out.println("Enter the book to edit");
        System.out.println();
        System.out.println("1.Change Book Name");
        System.out.println("2.Change Book Type");
        System.out.println("3.Change Book Count");
        System.out.println("4.Change Book Id");
        System.out.println("5.Change Book Price");
        System.out.println("Enter the choice");
        a=s.nextInt();
        switch(a){
            case 1:{
                editname();
            }
            case 2:{
                edittype();
            }
            case 3:{
                editcount();
            }
            case 4:{
                editprice();
            }
        }
    }
    public static void editname(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the book id to be edited");
        int f=s.nextInt();
        b=b4.indexOf(f);
        System.out.println("Enter the new name");
        x=s.next();
        b1.set(b,x);
        System.out.pritnln("Name changed sucessfull");
        edit();
    }
    public static void edittype(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the book id to be edited");
        a=s.nextInt();
        b=b4.indexOf(a);
        System.out.println("Enter the new type");
        x=s.next();
        b2.set(b,x);
        System.out.println("Type changed sucessull");
        edit();
    }
    public static void editcount(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Sytem.out.println("Enter the book id to be edited");
        a=s.nextInt();
        b=b4.indexOf(a);
        System.out.println("Enter the new count");
        x=s.next();
        b3.set(b,x);
        System.out.println("Count changed sucessfull");
        edit();
    }
    public static void editprice(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the book id to be edited");
        a=s.nextInt();
        b=b4.indexOf(a);
        System.out.println("Enter the new price");
        x=s.next();
        b5.set(b,x);
        System.out.println("Price changed sucessfull");
        edit();
    }
    public static void student(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Welcome");
        System.out.println();
        System.out.println("1.Login");
        System.out.println("2.Signup");
        System.out.println("3.Exit");
        System.out.println("Enter the choice");
        a=s.nextInt();
        switch(a){
            case 1:{
                login();
            }
            case 2:{
                signup();
            }
            case 3:{
                home();
            }
        }
    }
    public static void login(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the name");
        x=s.next();
        System.out.println("Enter the passwrd");
        y=s.next();
        if(d1.contains(x) && d2.contains(y)){
            if(b1.size()<1){
                System.out.println("No book to display");
            }
            else{
                System.out.printf("%-10s %-10s %-10s %-10s\n","Book Name","Book Type","Book Count","Book Price");
                for(int i=0;i<b4.size();i++){
                    System.out.print("%-10s %-10s %-10s %-10s\n"b1.get(i),b2.get(i),b3.get(i),b5.get(i));
                }
                login1();
            }
        }
        else{
            System.out.println("First signup and then login");
        }
    }
    public static void signup(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Welcome to signup page");
        System.out.println();
        System.out.println("Enter the name");
        x=s.next();
        System.out.println("Enter the password");
        y=s.next();
        System.out.println("Re-enter the password");
        z=s.next();
        if(y.equals(z)){
            d1.add(x);
            d2.add(y);
            uid++;
            d3.add(uid);
            System.out.println("Account created sucessfull");
            System.out.println("Id No :");
            System.out.println(uid);
            System.out.println("Rs.1000 is kept as hold from your account");
            a=d3.indexOf(uid);
            e1.add(a,"1000");
        }
        else{
            System.out.println("Password is incorrect");
        }
    }
    public static void login1(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.put.println("Welcome "+x);
        System.out.println();
        System.out.println("1.Add to cart");
        System.out.println("2.Remove from cart");
        System.out.println("3.View cart ");
        System.out.println("4.View Balance");
        System.out.println("5.Return");
        System.out.println("6.Lost");
        System.out.println("7.Exit");
        System.out.println();
        System.out.println("Enter the choice");
        a=s.nextInt();
        switch(a){
            case 1:{
                cart();
            }
            case 2:{
                remove();
            }
            case 3:{
                viewcart();
            } 
            case 4:{
                balance();
            }   
            case 5:{
                retrn();
            }
            case 6:{
                lost();
            }
            case 7:{
                student();
            }
        }
    }
    public static void cart(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the book id");
        a=s.nextInt();
        b=b4.indexOf(a);
        if(c1.contains(b1.get(b))){
            System.out.println("You can't borrow the same book");
        }
        else{
            c1.add(b1.get(b));
            boc=Integer.parseInt(b3.get(b));
            boc--;
            b3.set(b,Integer.toString(boc));
            System.out.println(boc);
            LocalDate borrow=LocalDate.now();
            System.out.println();
            System.out.println("Book added Sucessfull");
            System.out.println();
            System.out.println("Book borrowed on :"+borrow);
            e2.add(String.valueOf(borrow));
            LocalDate due=borrow.plusDays(15);
            e3.add(String.valueOf(due));
        }
        login1();
    }
    public static void remove(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the book id");
        a=s.nextInt();
        b=b4.indexOf(a);
        c1.remove(b1.get(b));
        boc++;
        b3.set(b,Integer.tostring(boc));
        System.out.println();
        System.out.println("Book removed sucessfull");
        System.out.println();
        login1();
    }
    public static void viewcart(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-----Cart-----");
        System.out.println();
        System.out.println(c1);
        System.out.println();
        login1();
    }
    public static void balance(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        int k=e1.indexOf(e1.get(b4.size()-1));
        System.out.println("Your balance :")
        System.out.println(e1.get(k));
        System.out.println();
        System.out.println("Want to add amount");
        System.out.println();
        System.out.println("1.Yes");
        System.out.println("2.No");
        System.out.println("Enter the choice");
        a=s.nextInt();
        switch(a){
            case 1:{
                adamo();
            }
            case 2:{
                login1();
            }
        }
    }
    public static void adamo(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the amount");
        int amo=s.nextInt();
        a=b4.indexOf(uid);
        int su=Integer.pareseInt(e1.get(a));
        int sum=amo+su;
        e1.set(a,Integer.toString(sum));
        login1();
    }
    public static void retrn(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if(c1.size()>0){
            System.out.println("Enter the date of return :");
            String date=s.next();
            int l1=d3.indexOf(uid);
            LocalDate date1=LocalDate.parse(date);
            String date2=e2.get(l1);
            LocalDate date3=LocalDate.parse(date2);
            da=Integer.parseInt(b3.get(b4.size()-1));
            da++;
            b3.set(l1,Integer.toString(da));
            if(date1.compareTo(date3)>15){
                int fine=date1.compareTo(date3);
                int po=fine-15;
                System.out.println();
                System.out.println("You are fined");
                System.out.println("Your due date was ended"+po+"ago");
                System.out.println();
                System.out.println("Amount will be reduced from your account");
                int fine1=Integer.parseInt(e1.get(l1));
                int sry=fine1-(fine*2);
                e1.set(l1,Integer.toString(sry));
            }
            else{
                System.out.println("Thanks for returning the book");
            }
            c1.remove(l1);
            e2.remove(l1);
            e3.remove(l1);
        }
        else{
            System.out.println("Books are not borrowed");
        }
        login1();
    }
    public static void lost(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if(c1.size>0){
        System.out.println("Enter the book id");
        a=s.nextInt();
        b=b4.indexOf(a);
        System.out.println(b);
        System.out.println("Reason");
        System.out.println();
        System.out.println("Your balance will be reduced");
        int price=Integer.parseInt(b5.get(b));
        int smu=(price*80)/100;
        int sub=Integer.pareseInt(e1.get(b));
        int redam=sub-smu;
        e1.set(b,Integer.toString(redam));
        b1.remove(b);
        b2.remove(b);
        c1.remove(b);
        e2.remove(b);
        e3.remove(b);
    }
    else{
        System.out.println("No book lost");
    }
    login1();
    }
}