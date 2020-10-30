/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class ValidationTest {

    Validation v;

    public ValidationTest() {
        v = new Validation();
    }

    @Test
    public void testCheckName1() {
        boolean expected = false;
        boolean rs = v.checkName("ban hien dang rat cham chi hoc mon swt cua thay pham ngoc ha nhung abcxyz");
        assertEquals(expected, rs);
    }

    @Test
    public void testCheckName2() {
        boolean expected = true;
        boolean rs = v.checkName("abcxyz");
        assertEquals(expected, rs);
    }

    @Test
    public void testCheckName3() {
        boolean expected = false;
        boolean rs = v.checkName("abcxyzvbcsjcsjbcjsbcsjcbscbksbksckbckscm mgdjsgdjsdsj");
        assertEquals(expected, rs);
    }

    @Test
    public void testCheckDateOfBirthFormat1() {
        boolean expected = true;
        boolean rs = v.checkDateOfBirthFormat("25/09/2020");
        assertEquals(expected, rs);
    }

    @Test
    public void testCheckDateOfBirthFormat2() {
        boolean expected = false;
        boolean rs = v.checkDateOfBirthFormat("fweqfasdf");
        assertEquals(expected, rs);
    }

    @Test
    public void testCheckDateOfBirthFormat3() {
        boolean expected = false;
        boolean rs = v.checkDateOfBirthFormat("32/15/2020");
        assertEquals(expected, rs);
    }

    @Test
    public void testCheckSpecialization1() {
        boolean expected = true;
        boolean rs = v.checkSpecialization("Dfsagxzgvsadtsrtdsr");
        assertEquals(expected, rs);
    }

    @Test
    public void testCheckSpecialization2() {
        boolean expected = false;
        boolean rs = v.checkSpecialization("rqewrqweufbqwukebhsdbchj"
                + "asbdjvbjwhqffffffffffffffffffffffffffffffffffffffffff"
                + "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                + "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                + "fwqerqwerewrwerweqrwqefewqfsdfsadfwqefwqeiurhuiewhuwqehirewqjfnndsnfn"
                + "sdfsdfsdhfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                + "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                + "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                + "fffffffff");
        assertEquals(expected, rs);
    }

    @Test
    public void testCheckSpecialization3() {
        boolean expected = true;
        boolean rs = v.checkSpecialization("fsdfsadfsdfsad");
        assertEquals(expected, rs);
    }
    @Test
    public void testCheckEmailFormat1() {
        
        
        boolean expected = false;
        boolean rs = v.checkEmailFormat("fwefs");
        assertEquals(expected, rs);
    }
    @Test
    public void testCheckEmailFormat2() {
        
        
        boolean expected = true;
        boolean rs = v.checkEmailFormat("minhquang.17820@gmail.com");
        assertEquals(expected, rs);
    }
    @Test
    public void testCheckEmailFormat3() {
        
        
        boolean expected = false;
        boolean rs = v.checkEmailFormat("@@@@@,fqwe");
        assertEquals(expected, rs);
    }
    @Test
    public void testCheckPhoneNumberFormat1() {
        boolean expected = true;
        boolean rs = v.checkPhoneNumberFormat("(111)-111-1111");
        assertEquals(expected, rs);
    }
    @Test
    public void testCheckPhoneNumberFormat2() {
        boolean expected = false;
        boolean rs = v.checkPhoneNumberFormat("111-111-1111");
        assertEquals(expected, rs);
    }
    @Test
    public void testCheckPhoneNumberFormat3() {
        boolean expected = false;
        boolean rs = v.checkPhoneNumberFormat("aaaaaaaaaaa");
        assertEquals(expected, rs);
    }




    

}
