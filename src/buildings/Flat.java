package buildings;

public class Flat {

    public static final double DEF_PLACE = 50.0;
    public static final int DEF_COUNT = 2;
    private double place;
    private int count;

    public Flat() {
        this.place = DEF_PLACE;
        this.count = DEF_COUNT;
    }

    public Flat(double place) {
        this.count=DEF_COUNT;
        this.place=place;
    }

    public Flat(double place, int count) {
        this.count=count;
        this.place=place;

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPlace() {
        return place;
    }

    public void setPlace(double place) {
        this.place = place;
    }


}







