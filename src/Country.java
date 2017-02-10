/**
 * Created by johnjastrow on 2/10/17.
 */
public class Country {
    private String abbrev = "";
    private String name = "";

    public Country(String abbrev, String name) {
        this.abbrev = abbrev;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
