import java.util.Hashtable;
import jdk.jshell.spi.ExecutionControl;
/* This is a stub for the Library class */

/**
     * Builds a new Library with a name, address, and number of floors.
     * Starts with an empty collection. Each book title maps to whether it’s available.
     * (true = on the shelf, false = checked out)
     *
     * @param name     library name
     * @param address  where the library lives
     * @param nFloors  how many floors the building has
     */

public class Library extends Building implements LibraryRequirements{
    private Hashtable<String, Boolean> collection;
    private boolean hasElevator;
    
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
      this.hasElevator = true;
    }
/**
     * Adds a book title to the collection as available (if it’s not already there).
     * If it exists, we skip adding a duplicate.
     *
     * @param title the book title to add
     */
    public void addTitle(String title){
      if (this.collection.containsKey(title)){
        System.out.println("Title is already in our selection");
      }
      else {
        this.collection.put(title, true);
      }
    }

    /**
     * Adds a book title and multiple copies to the collection 
     *
     * @param title the book title to add
     * @param copies the number of copies to add
     */

    public void addTitle(String title, int copies){
      for (int i = 0; i < copies; i++  ){
        this.addTitle(title + " (copy" + i + ")");
      }
      System.out.println("Added " + copies + " copies of " + title);
    }

    /**
     * Adds a book title, author, and genre to the collection by assigning it a varaible (fullBook) 
     *
     * @param title the book title to add
     * @param author the author of book to add
     * @param genre the genre of book to add
     */



    public void addTitle (String title, String author, String genre){
      String fullBook = title + " by "  + author + " from the " + genre + " genre ";
      this.addTitle(fullBook);
      System.out.println("You have added " + fullBook);
    }


  /**
     * Removes a book title from the collection and returns the title.
     *
     * @param title the book title to remove
     * @return the same title that was requested to be removed
     */

    public String removeTitle(String title){
      this.collection.remove(title);
      return title;
    }

    /**
     * Checks out a book
     *
     * @param title the title to check out
     * @param exception throws a runtime exception if book is not available to check out because it isn't in the collection or because it is already in use. 

     */
  
    public void checkOut(String title){
      if (this.collection.containsKey(title) == false){
        throw new RuntimeException("Cannot Check out this title because this does not exist in our collection");
      }
      if(this.collection.get(title) == false){
        throw new RuntimeException("Cannot check out this title because it is already in use");
      }
      this.collection.replace(title, false);
      }


    /**
     * Returns a book
     *
     * @param title the title being returned
     */
    public void returnBook(String title){
      if (this.collection.containsKey(title)){
        this.collection.replace(title, true);
      }
    }
    /**
     * Checks to see if we own this title at all?
     *
     * @param title the title to look for
     * @return true if the title exists in the collection, false otherwise
     */
    public boolean containsTitle(String title){
      if (this.collection.containsKey(title)){
        return true;
      }
      else {
        return false;
      }
    }

    /**
     * Availability check for a specific title.
     * 
     *
     * @param title the title to check
     * @return true if we have it and it’s on the shelf; false otherwise
     */

    public boolean isAvailable(String title){
      if (this.collection.containsKey(title)){
        return this.collection.get(title);
      }
      else {
        return false;
      }
    }
     /**
     * Prints a simple list of the collection with availability status.
     * 
     */
    public void printCollection(){
      for (String title : this.collection.keySet()){
        boolean status = this.collection.get(title);
        if (status){
          System.out.println(title + " is available");
        }
        else {
          System.out.println(title + " is checked out");
        }
      } 
    }
    public boolean hasElevator(){
      return this.hasElevator;
    }

    /**
     * 
     * 
    * This method overrides Building.showOptions() so we can list
    * the additional Library specific options a user can do,
     * 
     * 
     * Calls super.showOptions() first to display all Building options,
     * then adds the Library only options.
    */
    @Override
    public void showOptions(){
      super.showOptions();
      System.out.println("addTitle(String Title) \n + removeTitle(String Title) \n + checkOut(String Title) \n + returnBook(String Title) \n + containsTitle(String Title) \n + isAvailable(String Title) \n + printCollection()");
    }
    
      /**
 * Moves the user to a specific floor within the Library.
 *
 * This method overrides Building.goToFloor(int) to enforce Library rules:
 * Libraries have elevators so you can move between more than one floor
 * up or down. it goes to super.goToFloor(n).
 *
 * @param n the floor number to move to
 */
    @Override
    public void goToFloor(int n){
      super.goToFloor(n);
    }
    
    public static void main(String[] args) {
     Library neilson = new Library("Neilson Library", "Elm Street", 4);

    // add and check one book
    neilson.addTitle("Frankenstein");
    neilson.checkOut("Frankenstein");

    System.out.println("Library test ran successfully 📖");
}
  
  }