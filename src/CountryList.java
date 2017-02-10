import jodd.json.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This is the input of all countries
public class CountryList {
    static List<String> countries = new ArrayList();

    // get the list of all countries
    static List<String> readCountries() {
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
}
