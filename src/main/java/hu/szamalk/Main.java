package hu.szamalk;
import hu.szamalk.modell.Konyv;

import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Set<Konyv> kulonbozoKonyvek;

    public static void main(String[] args) throws CloneNotSupportedException {
        Konyv konyv1 = new Konyv("cim1","szerző1",1975,583);
        Konyv konyv2 = new Konyv("cim2","szerző2",1993,1754);
        Konyv konyv3 = (Konyv) konyv1.clone(); //new Konyv("cim1","szerző1",2000,2568);
        Konyv konyv4 = new Konyv("cim2","szerző2",2018,1790);

        String sz3 = "szerző3";
        String sz4 = "szerző4";
        List<String> szerzok = new ArrayList<>();
        szerzok.add(sz3);
        szerzok.add(sz4);

        Konyv konyv5 = new Konyv("cim5", szerzok,2010,3790);
        Konyv konyv6 = new Konyv("cim6", Arrays.asList(sz3,sz4,"szerző1"),2010,3790);

        kulonbozoKonyvek = new HashSet<>();
        kulonbozoKonyvek.add(konyv1);
        kulonbozoKonyvek.add(konyv2);
        kulonbozoKonyvek.add(konyv3);
        kulonbozoKonyvek.add(konyv4);
        kulonbozoKonyvek.add(konyv5);
        kulonbozoKonyvek.add(konyv6);

        new Main().feladatok();
    }

    public void feladatok(){
        osszesKonyv();
        kulonbozoKonyvek();
    }

    private void osszesKonyv() {
        System.out.println("Könyvek listája:");
        kulonbozoKonyvek.forEach(System.out::println);
    }

    private void kulonbozoKonyvek() {
        System.out.println("Különböző könyvek száma:" + kulonbozoKonyvek.size());
    }
}