
package com;

import cs.Login;
import cs.VacCenter;
import org.testng.annotations.Test;

public class Tests {
    @Test
    public void test1(){

        var l = Login.getInstance();
        var cond = l.login("Jean", "naeJ");
        assert (cond);
    }

    @Test
    public void test2(){

        var l = Login.getInstance();
        var cond = l.login("Jaean", "aneJ");
        assert (!cond);
    }



    @Test
    public void test3(){

        var vc = new VacCenter();
        vc.getReporte();

//        vc.alta("test");
//        var h = vc.search("test");
//        assert (h != null);
//
//        var cond  = vc.baja("test");
//        assert (cond);
//
//        h = vc.search("test");
//        assert (h == null);
    }

}
