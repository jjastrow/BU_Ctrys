import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by johnjastrow on 2/10/17.
 *
 * This World maintains a mapping of a list of countries identified by their starting first letter.
 */
public class World {
    List<String> countries = new ArrayList();               // country names
    static Map<String, List<String>> worldMap = new HashMap();     // first letter => countries

    // add a country to the appropriate list in worldMap by its 1st letter
    void add(String c)
    {
        String firstLetter = findFirstLetter(c);           // first letter of the country
        List <String> list = worldMap.get(firstLetter);     // associated list
        if (list == null)  list = new ArrayList<String>();  // create new if first time
        list.add(c);
        worldMap.put(firstLetter, list);
    }

    private static String findFirstLetter(String c) {
        return c.substring(0,1);
    }

    public void writeCountryList() {
        for (Map.Entry<String, List<String>>  entry : worldMap.entrySet()) {
            List<String> list = entry.getValue();
            int counter = 1;
            int listSize = list.size();
            for (String country : list) {
                String firstLetter = findFirstLetter(country);
                File f = new File(firstLetter + "_countries.txt");
                try {
                    FileWriter fw = new FileWriter(f);
                    fw.append(country);
                    if (listSize > counter) {
                        fw.append(", ");
                    }
                    fw.close();
                } catch (IOException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }
        }
    }
}
