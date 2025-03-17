package hu.szamalk.modell;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Konyv implements Cloneable{
    private String cim;
    private List<String> szerzok;
    private int ar, ev;

    public Konyv(String cim, String szerzo, int ar, int ev) throws NemLetezoKonyException{
        this(cim, new ArrayList<>(), ev, ar);
        szerzok.add(szerzo);
    }

    public Konyv(String cim, List<String> szerzok, int ar, int ev) throws NemLetezoKonyException{
        if (ev < 1000) {
            throw new IllegalArgumentException("Az év nem lehet 1000-nél kisebb!");
        }
        this.cim = cim;
        this.szerzok = new ArrayList<>(new HashSet<>(szerzok));
        this.ar = ar;
        this.ev = ev;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public List<String> getSzerzok() {
        return szerzok;
    }

    public void setSzerzok(List<String> szerzok) {
        this.szerzok = szerzok;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getEv() {
        return ev;
    }

    public void setEv(int ev) {
        this.ev = ev;
    }



    @Override
    public String toString() {
        return "Konyvtar{" +
                "cim='" + cim + '\'' +
                ", szerzok=" + szerzok +
                ", ar=" + ar +
                ", ev=" + ev +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Konyv konyv = (Konyv) o;
        return Objects.equals(cim, konyv.cim) && Objects.equals(szerzok, konyv.szerzok);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cim, szerzok);
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
