package buildings;

/**
 * Created by NW on 06.07.2017.
 */
public class DwellingFloor {
    private int numberFloor;
    private Flat[] floor;


    public DwellingFloor(int count) {
        if (count <= 0) return;
        this.floor = new Flat[count];
    }

    public DwellingFloor(Flat[] floor) {
        this.floor = floor;
    }

    public int getFloorCount() {
        return floor.length;
    }

    public double getSumPlace() {
        double sum = 0.0;
        int i = 0;
        while (i < floor.length) {
            sum += this.floor[i].getPlace();
            i++;
        }
        return sum;

    }

    public int getSumCounts() {
        int sum = 0;
        int i = 0;
        while (i < floor.length) {
            sum += this.floor[i].getCount();
            i++;
        }
        return sum;
    }


    public Flat[] getFloor() {
        return floor;
    }


    public Flat getFlatByNumber(int number) {
        if (number > this.floor.length || number < 0) return null;
        return floor[number];
    }

    public void changeFloorByNumber(int number, Flat anyNewFlat) {

        Flat temflat = getFlatByNumber(number);
        temflat.setCount(anyNewFlat.getCount());
        temflat.setPlace(anyNewFlat.getPlace());
    }

    public void addFlat(int number, Flat anyNewFlat) {
        if (number < 0 || number >= floor.length) {
            return;
        }

        if (number < floor.length && getFlatByNumber(number) == null) {
            floor[number] = anyNewFlat;
        } else if (number < floor.length && getFlatByNumber(number) != null) {
            int temcount = getFloorCount() + 1;

            Flat[] floor1 = new Flat[temcount];


            for (int i = 0; i < number; i++) {
                floor1[i] = floor[i];
            }

            for (int i = number + 1; i < floor1.length; i++) {
                floor1[i] = floor[i - 1];
            }
            floor1[number] = anyNewFlat;
            floor = floor1;
        } else if (number > floor.length) {
            Flat[] floor1 = new Flat[number];

            for (int i = 0; i < floor.length; i++) {
                floor1[i] = floor[i];
            }
            floor1[number] = anyNewFlat;
            floor = floor1;
        }

    }

    public void deleteFlat(int number) {
        if (getFlatByNumber(number) == null) return;
        floor[number] = null;
    }

    public Flat getBestSpace() {

        Flat tempBigFlat = floor[0];

        for (int i = 1; i < floor.length; i++) {
            if (tempBigFlat.getPlace() < floor[i].getPlace()) {
                tempBigFlat = floor[i];
            }
        }
        return tempBigFlat;
    }


}

