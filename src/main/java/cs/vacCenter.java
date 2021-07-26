package cs;

import java.security.SecureRandom;
import java.util.List;
import java.util.logging.Logger;

public class vacCenter {



    static Long totalPeople = 22935533L;
    Double vacAvance;
    Double vacCobertura;
    int vacCenterNum ;
    SecureRandom sc;

    List<Hospital> hospitalList;
    static final Logger logger = Logger.getLogger(vacCenter.class.getName());





    public vacCenter(){
        sc = new SecureRandom();
        vacAvance = sc.nextDouble();
        vacCobertura = sc.nextDouble() * vacAvance;
        logger.info(vacAvance.toString());
        logger.info(vacCobertura.toString());

        while (vacCobertura + vacAvance > 1){
            vacCobertura = sc.nextDouble() * vacAvance;

        }
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

        var h = search(name);

        if(h == null){
            h = new Hospital(name);
            hospitalList.add(h);
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
        return true;
    }


}
