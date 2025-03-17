package hu.szamalk.modell;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class KonyvTest {

    @Test
    void testEgyKonyvbenNemLehetnekAzonosSzerzok() {
        System.out.println("Egy könyvnek nem lehet több azonos szerzője");
        Konyv konyv = new Konyv("c", Arrays.asList("sz", "sz"), 1500, 2000);
        Assertions.assertEquals(1, konyv.getSzerzok().size(), "Hiba, azonos szerzők duplikálva lettek!");
    }

    @Test
    void evKisebbMintEzer() {
        System.out.println("Az év nem lehet kisebb, mint 1000");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Konyv("Teszt könyv", Collections.singletonList("Teszt szerző"), 500, 999);
        }, "Hiba! Az év 1000 alatti értéket kapott, de nem dobott kivételt.");
    }
}