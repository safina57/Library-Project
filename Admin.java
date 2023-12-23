import java.util.Scanner;

public class Admin {
    private static boolean exists = false;
    private int ID;
    private String password;

    public Admin(){}
    public void signIn(){
        if(exists){
            System.out.println("An admin already exists !");
        }
        else{
            Scanner sc=new Scanner(System.in);
            System.out.print("ID:");
            this.ID=sc.nextInt();
            sc.nextLine();
            System.out.print("Password:");
            this.password=sc.nextLine();
            exists=true;
        }
    }
    public boolean logIn(int ID,String password){
        return (ID == this.ID) && (password.equals(this.password));
    }

}
