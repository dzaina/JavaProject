package buildings;


public class Main {

    public static void main(String[] args) {
        Flat myFlat;
        Flat parrentsFlat;
        myFlat = new Flat();
        myFlat.count=1;
        myFlat.number=187;
        myFlat.s=41.9;
        parrentsFlat =new Flat();
        parrentsFlat.count=2;
        parrentsFlat.number=23;
        parrentsFlat.s=55.9;

        System.out.println(parrentsFlat.count>myFlat.count);

    }
}
