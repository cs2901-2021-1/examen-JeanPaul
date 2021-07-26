package cs;

import java.util.Scanner;
import java.util.logging.Logger;

public class Menu {

    Login log = Login.getInstance();
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    static final Logger logger = Logger.getLogger(Menu.class.getName());




    Menu(){

    }

    public void menu(){

        var c = VacCenter.getInstance();
        var getHosInput = "insert hospital:";


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

            switch (cmd) {
                case "Reporte":
                    c.getReporte();
                    break;
                case "Alta": {
                    logger.info(getHosInput);
                    var hospital = myObj.nextLine();
                    c.alta(hospital);
                    break;
                }
                case "Baja": {
                    logger.info(getHosInput);
                    var hospital = myObj.nextLine();
                    c.baja(hospital);
                    break;
                }
                case "Vacunado":{
                    logger.info(getHosInput);
                    var hospital = myObj.nextLine();
                    var h = c.search(hospital);
                    if(h == null) {
                        logger.info("hospital is not in service");
                        break;
                    }
                    logger.info("insert vacunado:");
                    var user = myObj.nextLine();
                    h.update(user);

                    break;
                }
                default:
                    break;
            }


        }

    }
}
