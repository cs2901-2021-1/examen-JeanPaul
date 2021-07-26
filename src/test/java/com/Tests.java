
package com;

import cs.Login;
import cs.vacCenter;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.String;
import java.util.logging.Logger;

public class Tests {
    @Test
    public void test1(){

        var l = Login.getInstance();
        var cond = l.login("Jean", "aneJ");
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

        var vc = new vacCenter();
        vc.getReporte();

        vc.alta("test");
        var h = vc.search("test");
        assert (h != null);

        var cond  = vc.baja("test");
        assert (cond);

        h = vc.search("test");
        assert (h == null);
    }

}
