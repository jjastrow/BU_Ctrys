import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by johnjastrow on 2/10/17.
 */
public class Main {
    public static void main(String[] args) {
        World world = new World();
        world.countries = CountryList.readCountries();

        for (String country : world.countries) {
            world.add(country);
        }

        world.writeCountryList();
    }
}
