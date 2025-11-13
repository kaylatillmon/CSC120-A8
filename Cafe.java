/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

     /**
     * Creates a new Cafe object with a name, address, and number of floors.
     * Starts off with zero supplies until restocked.
     *
     * @param name name of the cafe
     * @param address location of the cafe
     * @param nFloors number of floors in the cafe
     */

    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Sells one cup of coffee based on the size and customer's order.
     * If the cafe doesn’t have enough supplies, it automatically restocks before selling.
     *
     * @param size amount of coffee 
     * @param nSugarPackets number of sugar packets used
     * @param nCreams number of creams used
     */

    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces < size){
            restock(100, 0, 0, 0);
        }
        if (this.nSugarPackets < nSugarPackets){
            restock(0, 75, 0, 0);
        }
        if (this.nCreams < nCreams){
            restock(0, 0, 80, 0);
        }
        if (this.nCups < 1){
            restock(0, 0, 0, 30);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }

    /**
     * Sells one cup of coffee of the Holiday Special based on the size and customer's order.
     * 
     *
     * @param size amount of coffee 
     */

    public void sellCoffee(int size){
        this.sellCoffee(size, 3, 8);
        System.out.println("You've ordered a " + size + " oz " + " of the Holiday Special!");
    }

    /**
     * Sells one cup of coffee of the Fall Special based on the size and number of sugar packets the in the customer's order.
     * 
     *
     * @param size amount of coffee 
     * @param nSugarPackets number of sugar packets used
     */
    public void sellCoffee(int size, int nSugarPackets){
        this.sellCoffee(size, nSugarPackets, 5);
        System.out.println("You've ordered a " + size + " oz "+ " with " + nSugarPackets + " sugar packets" + " of the Fall Special!");
    }
    /**
     * Refills cafe supplies.
     * Only called when the cafe runs low on stock.
     *
     * @param nCoffeeOunces coffee ounces to add
     * @param nSugarPackets sugar packets to add
     * @param nCreams creams to add
     * @param nCups cups to add
     */

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;

        }
   /**
  * 
  * 
  * This method overrides Building.showOptions() so we can list
  * the additional Cafe specific options a user can do,
  * Calls super.showOptions() first to display all Building options,
  * then adds the Cafe only options.then adds the Cafe only options.
  */
    @Override
    public void showOptions(){
        super.showOptions();
        System.out.println("sellCoffee(int size, int nSugarPackets, int nCreams) \n + restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) \n +  ");
    }
    /**
 * Keeps the user on the first floor within the Cafe.
 *
 * This method overrides Building.goToFloor(int) to enforce Cafe rules:
 * Cafes only have one floor, any additional is not for customers 
 *
 * @param n the floor number to move to
 * @throws RuntimeException when trying to anywhere that's not the first floor
 */
    @Override
    public void goToFloor(int n){
        throw new RuntimeException("Customers can't access any other floor");}
    

    public static void main(String[] args) {
    
    Cafe compass = new Cafe("Compass Cafe", "Green Street", 1);

    
    compass.restock(100, 50, 50, 10);

    
    compass.sellCoffee(12, 2, 1);

    System.out.println("Coffee sold successfully ☕");
}

    
}
