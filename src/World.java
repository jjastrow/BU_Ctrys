import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by johnjastrow on 2/10/17.
 * <p>
 * This World maintains a mapping of a list of countries identified by their starting first letter.
 */
public class World {
    List<String> countries = new ArrayList();               // country names
    static Map<String, List<String>> worldMap = new HashMap();     // first letter => countries

    // add a country to the appropriate list in worldMap by its 1st letter
    void add(String c, List<String> list) {
        String firstLetter = findFirstLetter(c);           // first letter of the country
        list = worldMap.get(firstLetter);     // associated list
        if (list == null) list = new ArrayList<String>();  // create new if first time
        list.add(c);
        worldMap.put(firstLetter, list);
    }

    // get the list of all countries
    public List<String> loadCountries() {
        List<String> countries = new ArrayList();
        File f = new File("countries.txt");
        try {
            Scanner scanner = new Scanner(f);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] columns = line.split("\\|");
                Country country = new Country(columns[0], columns[1]);
                countries.add(country.getName());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No input file found!");
        } catch (Exception e) {
            System.out.println("ERROR: Problem reading input file!");
        }
        return countries;
    }

    private static String findFirstLetter(String c) {
        return c.substring(0, 1);
    }

    public void writeCountryList(String firstLetter) {
        List<String> list = worldMap.get(firstLetter);
        int counter = 1;
        int listSize = list.size();

        File f = new File(firstLetter + "_countries.txt");
        try {
            FileWriter fw = new FileWriter(f);
            for (String country : list) {
                fw.write(country);
                if (listSize > counter) {
                    fw.append(", ");
                }
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void printCountryList() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter a letter for the country file you want to output [ENTER to Quit]: ");
            String letter = scanner.nextLine().substring(0);
            if (letter.isEmpty()) break;

            this.writeCountryList(letter);
        }
    }

    public void loadMap() {
        List<String> list = null;
        for (String country : countries) {
            add(country, list);
        }
    }
}
