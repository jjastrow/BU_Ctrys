/**
 * Starting from the requirements I first created the approach in the comment block below.
 */
public class Main {
    public static void main(String[] args) {

        World world = new World();

        world.loadCountries();

        world.loadMap();

        world.printCountryList();
    }
}


/*
class Country
  String abbrev,  name
  String findFirstLetter() {...}
  String getName() {...}

class World
  List <String> countries. // country name
  Map <String, List <String>> worldMap // first letter => countries
  void add(Country c)  // add by 1st letter
  {
    String firstLetter = c.findFirstLetter()
    List <String> list = worldMap.get (firstLetter)
    if (list == null)  list = createNewList()
    list.add (c.getName())
  }
*/