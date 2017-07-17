package buildings;

/**
 * Created by NW on 06.07.2017.
 */
public class Dwelling {
    private DwellingFloor[] dwellingFloors;


    public Dwelling(int count, int[] countFlatsByFloor) {
        if (count < 1 || count != countFlatsByFloor.length) return;
        for (int i = 0; i < count; i++) {
            dwellingFloors[i] = new DwellingFloor(countFlatsByFloor[i]);
        }

    }

    public Dwelling(DwellingFloor[] dwellingFloors) {
        this.dwellingFloors = dwellingFloors;
    }

    public int getCountFloors() {
        return dwellingFloors.length;
    }

    public int getCountFlatsOnDwelling() {
        int sum = 0;
        int i = 0;
        while (i < dwellingFloors.length) {
            sum += this.dwellingFloors[i].getFloorCount();
            i++;
        }
        return sum;

    }

    public double getSumPlacesOnDwelling() {
        double sum = 0;
        int i = 0;
        while (i < dwellingFloors.length) {
            sum += this.dwellingFloors[i].getSumPlace();
            i++;
        }
        return sum;
    }

    public int getSumCountRoomsOnDwelling() {
        int sum = 0;
        int i = 0;
        while (i < dwellingFloors.length) {
            sum += this.dwellingFloors[i].getSumCounts();
            i++;
        }
        return sum;

    }

    public DwellingFloor[] getDwellingFloors() {
        return dwellingFloors;
    }

    public DwellingFloor getDwellingFloorByNumber(int number) {
        if (number > this.dwellingFloors.length || number < 0) return null;
        return dwellingFloors[number];
    }

    public void changeDwellingFloorByNumber(int number, DwellingFloor anyNewFloor) {
        if (number < 0 || number > dwellingFloors.length || anyNewFloor == null) return;
        DwellingFloor tempDwellingFloor = dwellingFloors[number];
        int countFlatsOnFloor = tempDwellingFloor.getFloorCount();
        for (int i = 0; i < countFlatsOnFloor && i < anyNewFloor.getFloorCount(); i++) {
            tempDwellingFloor.changeFloorByNumber(i, anyNewFloor.getFlatByNumber(i));
        }
    }

    public Flat getFlatbyNumberAtDwelling(int number) {

        int[] ttt = getFloorNumberAtDwillingByNumberOfFlat(number);


        return dwellingFloors[ttt[0]].getFlatByNumber(ttt[1]);
    }

    public void changeFlatByNumberAtDwelling(int number, Flat anyNewFlat) {

        Flat targetFlat = getFlatbyNumberAtDwelling(number);

        if (targetFlat != null) {
            targetFlat.setCount(anyNewFlat.getCount());
            targetFlat.setPlace(anyNewFlat.getPlace());
        }
    }


    public void addNewFlatByNumberAtDwelling(int number, Flat anyNewFlat) {
        int[] ttt = getFloorNumberAtDwillingByNumberOfFlat(number);

        dwellingFloors[ttt[0]].addFlat(ttt[1], anyNewFlat);

        return;


    }

    public void deleteFlatByNumberAtDwelling(int number) {

        int[] ttt = getFloorNumberAtDwillingByNumberOfFlat(number);

        dwellingFloors[ttt[0]].deleteFlat(ttt[1]);

        return;


    }

    private int[] getFloorNumberAtDwillingByNumberOfFlat(int number) {
        if (number < 0) {
            return new int[]{-1, -1};
        }
        int tempNumber = number;
        int floornumber = 0;

        while (number >= 0) {
            tempNumber = tempNumber - dwellingFloors[tempNumber].getFloorCount();
            floornumber++;
        }

//Вычисление номера квартиры на этаже и собственно на каком этаже
        return new int[]{floornumber, dwellingFloors[floornumber].getFloorCount() + tempNumber - 1};
    }

    public Flat getBestSpace() {
        Flat[] getBestFlatBySpaceByFloor = new Flat[getCountFloors()];
        for (int i = 0; i < getCountFloors(); i++) {

            getBestFlatBySpaceByFloor[i] = dwellingFloors[i].getBestSpace();

        }

        Flat tempBigFlat = getBestFlatBySpaceByFloor[0];

        for (int i = 1; i < getBestFlatBySpaceByFloor.length; i++) {
            if (tempBigFlat.getPlace() < getBestFlatBySpaceByFloor[i].getPlace()) {
                tempBigFlat = getBestFlatBySpaceByFloor[i];
            }
        }
        return tempBigFlat;

    }

    public Flat[] sortDescAnyArrayOfFlats(Flat[] anyNewArrayOfFlats) {

        Flat[] sortedArray = new Flat[anyNewArrayOfFlats.length];

        int k = 0; //первый элемент сортированного массива

        // Ищем САМУЮ большую площадь и записываем как элемент 0, и для простоты запиливаем в 0 - 0 элемент входящего массива
        sortedArray[0] = anyNewArrayOfFlats[0];


        for (int i = 0; i < anyNewArrayOfFlats.length; i++) {
            if (sortedArray[0].getPlace() <= anyNewArrayOfFlats[i].getPlace()) {
                sortedArray[0] = anyNewArrayOfFlats[i];
            }
        }
        // теперь в 0 у нас лежит самая большая квартира
        // начинаем сортировать - по принципу самая большая квартира, но не предыдущая (сравнивать можно поссылке, потому что могу)
        // для этого пилим цикл который будет дергать приватный метод и передавать в него ВЕСЬ аррей и объект, который стоит на предыдущем месте


        for (k = 1; k < anyNewArrayOfFlats.length - 1; k++) {

            sortedArray[k] = getNextBiggedFlatAtArray(anyNewArrayOfFlats,sortedArray[k-1]) ;
        }

        return sortedArray;
    }


    private Flat getNextBiggedFlatAtArray(Flat[] arrayOfFlats, Flat incomPrevFlat) {

        Flat nextFlat = arrayOfFlats[0];
        Flat prevFlat = incomPrevFlat;

        for (int i = 0; i < arrayOfFlats.length; i++) {
            if (nextFlat.getPlace() <= arrayOfFlats[i].getPlace() && nextFlat != prevFlat) {
                nextFlat = arrayOfFlats[i];

            }
        }


        return nextFlat;
    }


}

