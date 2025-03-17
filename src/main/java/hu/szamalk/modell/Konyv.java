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


























    public int compateTo(Konyv masik){
        //return this.cim.compareTo(masik.cim);
        Collator coll = Collator.getInstance();
        return coll.compare(this.cim, masik.cim);
    }
    
    
    public static EvComparator(){
        return new EvComparator();
    }

    public static ArComparator(){
        return new ArComparator();
    }

    private static class EvComparator implements Comparator<Konyv>(){
        @Override
        public int compare(Konyv egyik, Konyv masik){
            return egyik.ev - masik.ev;
        }
    }


    private static class ArComparator implements Comparator<Konyv>(){
        @Override
        public int compare(Konyv egyik, Konyv masik){
            return egyik.ar - masik.ar;
        }
    }























    @Override
    public Iterator<Konyv> iterator() {
        //return konyvek.iterator();
        return new ForditottIterator();
    }

    private class ForditottIterator implements Iterator<Konyv> {
        private int i = konyvek.size() -1;
        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public Konyv next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Nincs több elem a kollekcioba.");
            }
            return konyvek.get(i--);
        }
    }


}
