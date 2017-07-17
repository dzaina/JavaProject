package buildings;


public class Main {

    public static void main(String[] args) {
        Flat myFlat;
        Flat parrentsFlat;
        myFlat = new Flat();
        myFlat.setCount(1);
//        myFlat.number=187;
        myFlat.setPlace(41.9);
        parrentsFlat =new Flat();
        parrentsFlat.setCount(2);
//        parrentsFlat.number=23;
        parrentsFlat.setPlace(55.9);

        System.out.println(parrentsFlat.getCount() > myFlat.getCount());

    }
}
