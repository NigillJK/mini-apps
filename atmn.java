import java.util.*;
public class Main{
    static Scanner s=new Scanner(System.in);
    static int arr[]={0,0,0,0};
    static double r;
    static int a,x;
    static String c,b;
    static ArrayList<UseRs> al=new ArrayList<>();
    public static void main(String[] args){
        us();
        home();
        }
        public static void home(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("1.Admin Login");
        System.out.println("2.User Login");
        System.out.println("3.Exit");
        System.out.println("Enter the choice:");
        a=s.nextInt();
        switch(a){
            case 1:{
                admin();
                break;
            }
            case 2:{
                user();
                break;
            }    
        }
        home();
    }public static void admin(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        s.nextLine();
        System.out.println("Enter the User Name :");
        String b=s.nextLine();
        System.out.println("Enter the Pin :");
         c=s.nextLine();
        if(b.equals("admin") && c.equals("12345") || b.equals("manager")&& c.equals("54321")){
            admin1();
        }
        else{
            System.out.println("Enter the correct the details");
            home();
        }
    }
    public static void admin1() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    	System.out.println("Welcome Admin");
    	System.out.println("1.Add Money");
    	System.out.println("2.Show Money added");
    	System.out.println("3.Show Balance");
    	System.out.println("4.Exit");
    	System.out.println("Enter the options: ");
    	a=s.nextInt();
    	if(a>4 || a<1) {
    		System.out.println("Please the correct options");
    		admin();
    	}
    	else {
    		if(a==1){
    			addmoney();
    		}
    		else if(a==2){
    			showmoneyadd();
    		}
    		else if(a==3){
    			showbalance();
    		}
    		else if(a==4){
    			home();
    		}
    	}
        admin1();
    }
    public static void addmoney(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    	System.out.println("Insert the money");
    	System.out.println("100");
    	arr[0]+=s.nextInt();
    	System.out.println("200");
    	arr[1]+=s.nextInt();
    	System.out.println("500");
    	arr[2]+=s.nextInt();
    	System.out.println("2000");
    	arr[3]+=s.nextInt();
    	admin1();
    }
    public static void showmoneyadd() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    	System.out.println("100-->"+arr[0]);
    	System.out.println("200-->"+arr[1]);
    	System.out.println("500-->"+arr[2]);
    	System.out.println("2000-->"+arr[3]);
    }
    public static void showbalance() {
    	System.out.print("\033[H\033[2J");
        System.out.flush();
    	double r=((arr[0]*100)+(arr[1]*200)+(arr[2]*500)+(arr[3]*2000));
    	System.out.println("Balance Amount : "+r);
    }
   public static void user() {
       System.out.print("\033[H\033[2J");
        System.out.flush();
	   System.out.println("Welcome User");
       s.nextLine();
	   System.out.println("Enter the User Name:");
	   b=s.nextLine();
	   System.out.println("Enter the Pin:");
	   c=s.nextLine();
	   if (checkuser(b,c,al)) {
		   user1();
	   }
	   else{
		   System.out.println("Enter valid Details");
		   user();
	   }
   }
   public static void user1() {
       System.out.print("\033[H\033[2J");
        System.out.flush();
	   System.out.println("1.Withdrawl");
	   System.out.println("2.Balance check");
	   System.out.println("3.Mini Statement");
	   System.out.println("4.Transaction");
	   System.out.println("5.Add Money");
	   System.out.println("6.Exit");
	   System.out.println("Enter the option :");
	   a=s.nextInt();
	   if(a>6 || a<1){
		   System.out.println("Please Enter valid option");
		   user1();
	   }
	   else{
		   if(a==1){
			   withdraw();
		   }
		   else if(a==2){
			   balancecheck();
		   }
           else if(a==3){
               miniStatement();
           }
		   else if(a==4){
			   trans();
		   }
		   else if(a==5){
			   addmoney();
		   }
	   }
       user1();
   }
   public static void miniStatement(){
       System.out.print("\033[H\033[2J");
        System.out.flush();
       System.out.println("\nREASON\t\tAMOUNT");
       for(int i=0;i<al.get(x).state.size();i++){
        System.out.println(al.get(x).state.get(i));
       }
       System.out.println();
   }
   public static void trans(){
       System.out.print("\033[H\033[2J");
        System.out.flush();
	   System.out.println("Enter the IFSC Code:");
	   String d=s.next();
	   System.out.println("Enter the account number:");
	   String e=s.next();
	   System.out.println("Enter the amount to transfer:");
	   int ac=s.nextInt();
	   for(int i=0;i<al.size();i++){
		   if(al.get(i).IFSC.equals(d)&& al.get(i).accno.equals(e)) {
			   al.get(i).amount+=ac;
		   }
	   }
	   al.get(x).amount-=ac;
       al.get(x).state.add("Transaction "+ac+" "+e);
   }
   public static void balancecheck() {
       System.out.print("\033[H\033[2J");
        System.out.flush();
	   System.out.println("Balance Amount:"+al.get(x).amount);
   }
   public static void custom() {
	   al.add(new UseRs("Nigill","372001",5000,"ni123","987654",new ArrayList<>()));
	   al.add(new UseRs("Chandra","8112001",4000,"ch123","987645",new ArrayList<>()));
	   al.add(new UseRs("Manjit","312002",7000,"ma123","987543",new ArrayList<>()));
	   al.add(new UseRs("Pranesh","1892001",4000,"pr123","98534",new ArrayList<>()));
   }
   public static void withdraw() {
       System.out.print("\033[H\033[2J");
        System.out.flush();
	   System.out.println("Enter the withdrawl amount :");
	   int ab=s.nextInt();
	   while(ab!=0) {
		   int ac;
		   int bc;
		   if(ab<=2000) {
			   bc=a%2000;
			   ac=a/2000;
			   arr[0]-=ac;
			   ac=0;
			   bc=ab;
		   }
		   else if(ab<=500) {
			   ac=ab/500;
			   bc=ab%500;
			   arr[1]-=ac;
			   ac=0;
			   bc=ab;
		   }
		   else if(ab<=200) {
			   ac=ab/200;
			   bc=ab%200;
			   arr[2]-=ac;
			   ac=0;
			   bc=ab;
		   }
		   else if(a<=100) {
			   ac=ab/100;
			   bc=ab%100;
			   arr[2]-=ac;
			   ac=0;
			   bc=ab;
		   }
	   }
	   r-=ab;
       al.get(x).state.add("Withdraw "+ab);
	   user();
   }
public static boolean checkuser(String g,String h,ArrayList<UseRs>al) {
	 boolean flag=true;
	for(int i=0;i<al.size();i++) {
		if(al.get(i).name.equals(g) && al.get(i).password.equals(h)) {
		flag=true;
		x=i;
		}
	}
return flag;	
}
public static void us(){
    al.add(new UseRs("Nigill","123",10000,"ic123","12345",new ArrayList<>()));
    al.add(new UseRs("Nigill","123",12000,"rb123","12345",new ArrayList<>()));
    al.add(new UseRs("Nigill","123",13000,"rb123","12345",new ArrayList<>()));
    al.add(new UseRs("Nigill","123",17000,"ic123","12345",new ArrayList<>()));
}
}
class UseRs{
	public String name;
	public String password;
	public int amount;
	public String IFSC;
	public String accno;
    public ArrayList<String> state;
	public UseRs(String name,String pass,int amo,String IFSC,String accno,ArrayList<String> state) {
		this.name=name;
		this.password=pass;
		this.amount=amo;
		this.IFSC=IFSC;
		this.accno=accno;
        this.state=state;
	}

}