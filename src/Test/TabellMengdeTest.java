package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import oblig3.mengde.MengdeADT;
import oblig3.mengde.TabellMengde;

import static org.junit.jupiter.api.Assertions.*;


public class TabellMengdeTest {

    private TabellMengde<Integer> mengde1;
    private TabellMengde<Integer> mengde2;

    @BeforeEach
    public void setup() {
        mengde1 = new TabellMengde<>(10);
        mengde2 = new TabellMengde<>(10);
    }

    @Test
    public void testErTom() {
        assertTrue(mengde1.erTom());
        mengde1.leggTil(5);
        assertFalse(mengde1.erTom());
    }

    @Test
    public void testLeggTil() {
        mengde1.leggTil(10);
        assertTrue(mengde1.inneholder(10));
        mengde1.leggTil(10); 
        assertEquals(1, mengde1.antallElementer());
    }

    @Test
    public void testFjern() {
        mengde1.leggTil(20);
        assertTrue(mengde1.inneholder(20));
        Integer fjernetElement = mengde1.fjern(20);
        assertEquals(20, fjernetElement);
        assertFalse(mengde1.inneholder(20));
    }

    @Test
    public void testUnion() {
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        mengde2.leggTil(2);
        mengde2.leggTil(3);

        MengdeADT<Integer> unionMengde = mengde1.union(mengde2);
        assertTrue(unionMengde.inneholder(1));
        assertTrue(unionMengde.inneholder(2));
        assertTrue(unionMengde.inneholder(3));
    }

    @Test
    public void testSnitt() {
        mengde1.leggTil(5);
        mengde1.leggTil(6);
        mengde2.leggTil(6);
        mengde2.leggTil(7);

        MengdeADT<Integer> snittMengde = mengde1.snitt(mengde2);
        assertTrue(snittMengde.inneholder(6));
        assertFalse(snittMengde.inneholder(5));
        assertFalse(snittMengde.inneholder(7));
    }

    @Test
    public void testErLik() {
        mengde1.leggTil(10);
        mengde1.leggTil(20);
        mengde2.leggTil(10);
        mengde2.leggTil(20);

        assertTrue(mengde1.erLik(mengde2));
    }
    
    @Test
    public void testMinus() {
        mengde1.leggTil(10);
        mengde1.leggTil(20);
        mengde2.leggTil(20);
        mengde2.leggTil(30);

        MengdeADT<Integer> differanseMengde = mengde1.minus(mengde2);
        assertTrue(differanseMengde.inneholder(10));
        assertFalse(differanseMengde.inneholder(20));
        assertFalse(differanseMengde.inneholder(30));
    }
    
    @Test
    public void testLeggTilAlleFra() {
        mengde1.leggTil(10);
        mengde1.leggTil(20);
        mengde2.leggTil(20);
        mengde2.leggTil(30);

        mengde1.leggTilAlleFra(mengde2);
        assertTrue(mengde1.inneholder(10));
        assertTrue(mengde1.inneholder(20));
        assertTrue(mengde1.inneholder(30));
    }

    @Test
    public void testErDisjunkt() {
        mengde1.leggTil(10);
        mengde1.leggTil(20);
        mengde2.leggTil(30);
        mengde2.leggTil(40);

        assertTrue(mengde1.erDisjunkt(mengde2));
    }
    
    

    @Test
    public void testErDelmengdeAv() {
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        mengde1.leggTil(3);

        mengde2.leggTil(1);
        mengde2.leggTil(2);

        assertTrue(mengde2.erDelmengdeAv(mengde1));
    }
}

