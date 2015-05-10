import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author millemariehansen
 */
public class TestBeholdere {
    public static void main(String[] args) {
        TestBeholdere test = new TestBeholdere();
        System.out.println(test.testTabell());
        System.out.println(test.testEnkelSortertListe());
        System.out.println(test.testEnkelReseptListe());
    }
    
    public boolean testTabell(){
        boolean altFunker = true;
        Tabell<Person> personTabell = new Tabell<>(10);
        Long f = 1L;
        int p = 1;
        Person p1 = new Person("Elsie", f++ + "","Algol", p++);
        
        Long longNr = 0L;
        for (int i = 0; i< 10; i++){
            altFunker = personTabell.settInn(new Person("a"+i, longNr + "", "b"+i, i), i);
            if (altFunker == false){
                System.out.println("Har et problem naar den setter inn 10 pers");
                return false;
            }
            longNr++;
        }
        altFunker = !personTabell.settInn(p1, p);
        int teller = 0;
        for (Person pe: personTabell){
            altFunker = pe.adresse().equals("b" +teller);
            if (altFunker == false){
                System.out.println("Feil ved iterering");
                return false;
            }
            teller++;
        }
        
        altFunker = personTabell.settInn(new Person("Elsie", f++ + "","Algol", p++), 0);
        p1 = personTabell.finn(0);
        altFunker = p1.name().equals("Elsie") == altFunker;

        if (altFunker == false){
            System.out.println("Klarer ikke ta ut personen 'Elsie'");
            return false;
        }
        return altFunker;
    }
    
    public boolean testEnkelSortertListe() {
        boolean ok = true;
        SortertEnkelListe<Lege> leger = new SortertEnkelListe<>();
        
        for (int i = 0; i < 10; i++) {
            ok = leger.settInn(new Lege("a" + i));
            if (ok == false) {
                System.out.println("Kan ikke sette inn lege nr: " + i);
            }
        }
        int teller = 0;
        for (Lege le: leger) {
            ok = le.samme("a" + teller);
            if (ok == false) {
                System.out.println("Kan ikke finne lege nr: " + teller);
            }
            teller++;
        }
        
        Lege l = new Lege("Tone");
        ok = leger.settInn(l);
        if (ok == false) {
            System.out.println("Kan ikke sette inn Lege 'Tone'");
        }
        Fastlege f = new Fastlege("Lise", 001);
        ok = leger.settInn(f);
        if (ok == false) {
            System.out.println("Kan ikke sette inn fastlege 'Lise'");
        }
        ok = l == leger.finn("Tone");
        if (ok == false) {
            System.out.println("Kan ikke finne legen 'Tone'");
        }
        Lege m = new Lege("Maria");
        ok = !(m == leger.finn("Maria"));
        if (ok == false) {
            System.out.println("Kan finne legen 'Maria' som ikke er i beholderen");
        }
        ok = f == leger.finn("Lise");
        if (ok == false) {
            System.out.println("Kan ikke finne fastlegen 'Lise'");
        }
        
        return ok;
    }
    
    public boolean testEnkelReseptListe(){
        YngsteForstReseptListe persResept = new YngsteForstReseptListe();
        EldsteForstReseptListe legeResept = new EldsteForstReseptListe();
        boolean okL = true; 
        boolean okP = true;
        
        Resept[] persArray = new Resept[10];
        Resept[] legeArray = new Resept[10];
        int teller = 0;
        for(Resept r4: persResept){
            persArray[teller] = r4;
            teller ++;
        }
        teller = 0;
        for(Resept r5: legeResept){
           legeArray[teller] = r5;
           teller++;
        }
        if (legeArray.length != persArray.length){
            System.out.println("Det settes/tas inn/ut forskjellige mengder respter");
        }
        for (int i = 0; i< legeArray.length; i++){
            if (legeArray[i] != persArray[10 - 1 -i]){
                System.out.println(i);
                System.out.println("Disse burde vaert like");
                return false;
            }
        }
        
        Resept r = new Resept (new Legemiddel("Ibux", 150, 50), new Lege("b" + 0), new Person("Elsie", 1 + "","Algol", 1 ), 100);
        okP = persResept.settInn(r);
        okL = legeResept.settInn(r);
        
        if (okL == false || okP == false){
            System.out.println("Kan ikke sette inn en resept");
        }
        
        Resept r2 = new Resept (new Legemiddel("Paraset", 150, 50), new Lege("b" + 1), new Person("Mille", 2 + "","Algol", 2 ), 100);
        okP = persResept.settInn(r2);
        okL = legeResept.settInn(r2);
        
        if(persResept.finn(r2.ID()) != legeResept.finn(r2.ID())){
            okP = false;
            okL = okP;
            System.out.println("Tar ut forskjellige resepter med samme ID nokkel");
            return false;
        }
        
        if(persResept.finn(r.ID()) != legeResept.finn(r.ID())){
            okP = false;
            okL = okP;
            System.out.println("Tar ut forskjellige resepter med samme ID nokkel");
            return false;
        }
        
        Legemiddel a = new Legemiddel("Antibotika", 200, 50);
        for (int i = 0; i < 10; i++){
            Resept re = new Resept (a, new Lege("b" + i), new Person("c" + i, 2 + "","Algol", 2 ), 100);
            okP = persResept.settInn(re);
            okL = legeResept.settInn(re);
            if (okL == false || okP == false){
                System.out.println("Kan ikke sette inn en respt");
                return false;
            }
        }
        return true;
    }
}
