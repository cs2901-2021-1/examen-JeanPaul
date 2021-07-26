package cs;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public  final class VacCenter {



    static Long totalPeople = 22935533L;
    private static VacCenter vacCenter;


    Double vacAvance;
    Double vacCobertura;
    int vacCenterNum ;
    SecureRandom sc;

    List<Hospital> hospitalList;
    static final Logger logger = Logger.getLogger(VacCenter.class.getName());







    public VacCenter(){
        sc = new SecureRandom();
        vacAvance = sc.nextDouble();
        vacCobertura = sc.nextDouble() * vacAvance;


        while (vacCobertura + vacAvance > 1){
            vacCobertura = sc.nextDouble() * vacAvance;

        }

        hospitalList = new ArrayList<>();
    }

    public static VacCenter getInstance(){
        if(vacCenter == null){
            vacCenter = new VacCenter();
        }
        return vacCenter;
    }


    public void getReporte(){
        logger.info(()->"Avance de la Vacunación:" + vacAvance.toString() );
        logger.info(()->"Cobertura de la Vacunación:" + vacCobertura);
        logger.info(()->"Número de Centros de Vacunación:" + vacCenterNum);
        logger.info(()->"Número de personas vacunadas parcialmente:" + (int) Math.round(vacAvance* totalPeople));
        logger.info(()->"Número de personas vacunadas completamente:" + (int) Math.round(vacCobertura* totalPeople));

    }

    public  Hospital search(String name){

        for (Hospital h : hospitalList) {
            if(h.name.equals(name))
                return  h;
        }

        return  null;
    }

    public  boolean alta(String name){

        if(hospitalList.size() > 50) return false;

        var h = search(name);

        if(h == null){
            h = new Hospital(name);
            hospitalList.add(h);
            vacCenterNum++;
            return  true;
        }
        return false;
    }

    public  boolean baja(String name){

        var h = search(name);

        if(h == null){
            return  false;
        }

        hospitalList.remove(h);
        vacCenterNum--;
        return true;
    }


    void notify(String username){
        logger.info(()->"the user " + username + " was vaccinated");
    }

}
