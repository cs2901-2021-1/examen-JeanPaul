package cs;

public class Hospital {

    String name;
    VacCenter vc;
    int vaccinatedNum;


    Hospital(String name){
        this.name = name;
        vc = VacCenter.getInstance();
        vaccinatedNum = 0;
    }

    void update(String userVacunado){
        vaccinatedNum++;
        vc.notify(userVacunado);
    }



}
