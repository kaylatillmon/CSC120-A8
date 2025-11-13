import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
       
        Library Neilson = new Library("Neilson", "Chapin Dr", 5);
        Library Josten = new Library("Josten", "Mendenhall Center", 3);

        Cafe Compass = new Cafe("Compass Cafe", "Chapin Dr", 1);
        Cafe compassCafeCenter = new Cafe("Campus Center Cafe", "49 College Lane", 1);

        House Scales = new House("Scales House", "170 Elm St", 4, true, true);
        House King = new House("King House", "180 Elm St", 4, true, true);
        House Haynes = new House("Haynes House", "1 Mandelle Rd", 4, true, true);
        House Capen = new House("Capen House", "26 Prospect St, Northampton", 4, false, false);
        House Cutter = new House("Cutter House", "10 Prospect St", 3, true, true);
        House Morrow = new House("Morrow House", "Mandelle Rd", 4, true, false);

        Neilson.addTitle("Frankenstein", 4);
        Josten.addTitle("And Then There Were None", "Agatha Christie", "Mystery");

        Compass.sellCoffee(12);
        compassCafeCenter.sellCoffee(16, 4);

        Capen.moveOut("Kayla");
        Scales.moveIn("Kayla");



        myMap.addBuilding(Neilson);
        myMap.addBuilding(Josten);

        myMap.addBuilding(Compass);
        myMap.addBuilding(compassCafeCenter);

        myMap.addBuilding(Scales);
        myMap.addBuilding(King);
        myMap.addBuilding(Haynes);
        myMap.addBuilding(Capen);
        myMap.addBuilding(Cutter);
        myMap.addBuilding(Morrow);



        System.out.println(myMap);
    }
    
}
