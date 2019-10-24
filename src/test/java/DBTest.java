import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

@RunWith(JUnitParamsRunner.class)
public class DBTest {

    @Test
    public void constructorTest() {

        Random random = new Random();
        String fileName = Integer.toString(Math.abs(random.nextInt())) + ".csv";

        DB db1 = null;
        try {
            db1 = new DB(fileName, 4);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String expected = fileName;
        Assert.assertEquals(db1.getFileName(), expected);
    }

    @Test
    public void testDBFileName() {
        String fileName = "test.csv";
        DB testDB = null;
        try {
            testDB = new DB(fileName, 4);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String actual = testDB.getFileName();
        Assert.assertEquals(testDB.getFileName(), fileName);
    }

    @Test
    public void testPathToFileName() {
        String input = "/Users/josh/Desktop/Projects/CR-MacroLabs-OOP-ATM/data/610393892.csv";
        String expected = "610393892.csv";
        Assert.assertEquals(expected, DB.pathToFileName(input));
    }

    @Test
    public void testFileNametoPath() {
        String input = "610393892.csv";
        String expected = "/Users/josh/Desktop/Projects/CR-MacroLabs-OOP-ATM/data/610393892.csv";
        Assert.assertEquals(expected, DB.fileNameToPath(input, System.getProperty("user.dir")));
    }

    @Test
    public void tempStuff() {
//        String fileName = "test.csv";
//        DB testDB = null;
//        try {
//            testDB = new DB(fileName, 4);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        testDB.addRow(new String[] {"Item 1", "Item 2", "Item 3", "Item 4"});
//        testDB.addRow(new String[] {"Item 1b", "Item 2b", "Item 3b", "Item 4b"});
//        testDB.addRow(new String[] {"Item 1c", "Item 2c", "Item 3c", "Item 4c"});
//        testDB.addRow(new String[] {"Item 1d", "Item 2d", "Item 3d", "Item 4d"});

    }

    @Test
    public void readTestDBTest() {
        String fileName = "test.csv";

        ArrayList<String[]> expected = new ArrayList<>();
        expected.add(new String[] {"Item 1", "Item 2", "Item 3", "Item 4"});
        expected.add(new String[] {"Item 1b", "Item 2b", "Item 3b", "Item 4b"});
        expected.add(new String[] {"Item 1c", "Item 2c", "Item 3c", "Item 4c"});
        expected.add(new String[] {"Item 1d", "Item 2d", "Item 3d", "Item 4d"});

        DB testDB = null;
        try {
            testDB = new DB(fileName, 4);

            ArrayList<String[]> records = testDB.readAllRows();

            for (int i = 0; i < 4; i++) {
                Assert.assertEquals(expected.get(i), records.get(i));
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void printDBTest() {
        String fileName = "test.csv";
        DB testDB = null;
        try {
            testDB = new DB(fileName, 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        testDB.printDB();
    }

    @Test
    public void clearDBTest() {
        Random random = new Random();
        String fileName = Integer.toString(Math.abs(random.nextInt())) + ".csv";

        DB db1 = null;
        try {
            db1 = new DB(fileName, 4);
        } catch (IOException e) {
            e.printStackTrace();
        }

        db1.addRow(new String[]{"Sticky", "Icky", "Wicky", "Quicky"});
        db1.clear();

        ArrayList<String[]> records = db1.readAllRows();

        Assert.assertEquals(0,records.size());
    }

    @Test
    public void addRowTest() {
        Random random = new Random();
        String fileName = Integer.toString(Math.abs(random.nextInt())) + ".csv";

        DB db1 = null;
        try {
            db1 = new DB(fileName, 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String[]> data = new ArrayList<>();
        data.add(new String[] {"Item 1", "Item 2", "Item 3", "Item 4"});
        data.add(new String[] {"Item 1b", "Item 2b", "Item 3b", "Item 4b"});
        data.add(new String[] {"Item 1c", "Item 2c", "Item 3c", "Item 4c"});
        data.add(new String[] {"Item 1d", "Item 2d", "Item 3d", "Item 4d"});

        ArrayList<String[]> records;
        for (int i = 0; i < 4; i++) {
            db1.addRow(data.get(i));
            Assert.assertTrue(i + 1 == db1.length());

            records = db1.readAllRows();

            for (int j = 0; j <= i; j++) {
                //System.out.println(String.format("Rows: %d Testing row: %d", i, j));
                Assert.assertEquals(records.get(i), data.get(i));
            }
        }
    }

    @Test
    public void getRowLengthTest() {
        Random random = new Random();
        String fileName = Integer.toString(Math.abs(random.nextInt())) + ".csv";

        DB db1 = null;
        Integer rowL = random.nextInt(10);
        try {
            db1 = new DB(fileName, rowL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] row = new String[rowL];
        db1.addRow(row);
        Assert.assertTrue(1 == db1.length());

        Assert.assertTrue(rowL == db1.getRowLength());
    }

    @Test
    public void getFileNameTest() {
        Random random = new Random();
        String fileName = Integer.toString(Math.abs(random.nextInt())) + ".csv";

        DB db1 = null;
        Integer rowL = random.nextInt(10);
        try {
            db1 = new DB(fileName, rowL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(fileName == db1.getFileName());

        
    }
}