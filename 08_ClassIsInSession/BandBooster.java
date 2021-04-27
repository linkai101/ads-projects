
public class BandBooster {
  String name;
  int boxesSold = 0;

  public BandBooster(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
  
  public void updateSales(int newSales) {
    this.boxesSold += newSales;
  }

  public String toString() {
    return name + " : " + boxesSold + " boxes sold"; 
  }
}