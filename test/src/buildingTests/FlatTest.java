package buildingTests;

import buildings.Flat;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by NW on 17.07.2017.
 */
public class FlatTest extends TestCase {

    @Test
    public void testConstruct() {
        Flat testFlat1 = new Flat();

        Flat testFlat2 = new Flat(150);

        Flat testFlat3 = new Flat(250, 6);

        System.out.println("Test constructors: ");
        System.out.println("Flat1: countRooms = " + testFlat1.getCount() + " place = " + testFlat1.getPlace());
        System.out.println("Flat2: countRooms = " + testFlat2.getCount() + " place = " + testFlat2.getPlace());
        System.out.println("Flat3: countRooms = " + testFlat3.getCount() + " place = " + testFlat3.getPlace());

        assertTrue(true);
    }
}
