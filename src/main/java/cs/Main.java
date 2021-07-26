package cs;


import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    Login log = Login.getInstance();
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    static final Logger logger = Logger.getLogger(Main.class.getName());




    void menu(){

        var c = new vacCenter();


        while (true){
            logger.info("insert your username:");
            var username =myObj.nextLine();
            logger.info("insert your password:");
            var password =myObj.nextLine();

            if(log.login(username,password))
                break;
        }

        while (true){
            logger.info("insert command:");
            var cmd =myObj.nextLine();


            if(cmd.equals("exit"))
                break;

            if(cmd.equals("Reporte")){
                c.getReporte();
            }


        }

    }

    public static void main(String[] args) { // main for


        var c = new vacCenter();

        c.getReporte();


    }
}
