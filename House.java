/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building implements HouseRequirements {
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;
  
  
  /**
   * Creates a new House object with a name, address, number of floors, and info on if it has a dining room.
   * Also sets up the list of residents for this house.
   *
   * @param name name of the house
   * @param address where the house is located
   * @param nFloors how many floors the house has
   * @param hasDiningRoom whether the house includes a dining room
   */



  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<Student>();
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  

  
  /**
   * Checks if this house has a dining room.
   *
   * @return true if the house has a dining room, false if not
   */


  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }
  /**
   * Counts how many residents currently live in the house.
   *
   * @return number of students living here
   */
  public int nResidents(){
    return this.residents.size();
  }
   /**
   * Moves a student into the house and adds them to the residents list.
   *
   * @param s the student moving in
   * @param throws Runtime Exception if student is already in building
   */
  public void moveIn(Student s){
    if(this.residents.contains(s)) {
      throw new RuntimeException("This student is already in this building");
    }
    
    this.residents.add(s);
  }

     /**
   * Moves a student into the house and adds them to the residents list by calling the moveIn method.
   *
   * @param String name the student moving in
   */
  public void moveIn(String name){
    System.out.println(name + " moved into " +  this.name);
    this.moveIn(new Student(name, name, activeFloor));
  }

  /**
   * Moves a student out of the house, removing them from the residents list.
   * Returns the student who just moved out, mostly for confirmation.
   *
   * @param s the student moving out
   * @return the same student who moved out
   */
  public Student moveOut(Student s){
    residents.remove(s);
    return s;
  } 


  /**
   * Moves a student out of the house, removing them from the residents list by calling the moveOut method.
   * Prints the student who just moved out, mostly for confirmation.
   *
   * @param String name the student moving out
   *
   */
  public void moveOut(String name){
    System.out.println(name + " moved out of " + this.name);
    this.moveOut(new Student(name, name, activeFloor));
  }
/**
   * Checks if a given student currently lives in this house.
   *
   * @param s the student you’re checking for
   * @return true if the student is a resident, false otherwise
   */
  public boolean isResident(Student s){
    return residents.contains(s);
  }

  public boolean hasElevator(){
    return this.hasElevator;
  }

/**
  * 
  * 
  * This method overrides Building.showOptions() so we can list
  * the additional House specific options a user can do,
  * Calls super.showOptions() first to display all Building options,
  * then adds the House only options.then adds the House only options.
  */


  @Override
  public void showOptions(){
      super.showOptions();
      System.out.println("moveIn(s) \n + isResident(s) \n + hasDiningRoom \n + nResidents()");
    }
  
  /**
 * Moves the user to a specific floor within the House.
 *
 * This method overrides Building.goToFloor(int) to enforce House rules:
 * Houses without elevators can only move between floors one level at a time.
 *
 * If the House has no elevator, trying to move more than one floor up (up or down)
 * will throw a RuntimeException. If the House does have an elevator,
 * it goes to super.goToFloor(n).
 *
 * @param n the floor number to move to
 * @throws RuntimeException when trying to go up/down more than one floor without an elevator 
 */
  @Override
  public void goToFloor(int n){
     if (this.hasElevator == false){
      if (n > this.activeFloor + 1){
      throw new RuntimeException("You can only go up one floor at a time");
     }
      if (n < this.activeFloor - 1){
      throw new RuntimeException("You can only go down one floor at a time");
     }}
     
    super.goToFloor(n);
    
    }
  /**
   * Quick test for the House class.
   * Just builds a new house to make sure everything compiles.
   */
  public static void main(String[] args) {
    House chase = new House("Chase House", "Elm Street", 4, true, true);
  }

}