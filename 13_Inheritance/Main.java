class Main {
  public static void main(String[] args) {
    Labrador lab = new Labrador("Spike", "yellow");
    System.out.println(lab.getName() + " says " + lab.speak());
    System.out.println("Average breed weight of a Labrador is " + lab.avgBreedWeight());
    System.out.println();
    Yorkshire york = new Yorkshire("Caramel");
    System.out.println(york.getName() + " says " + york.speak());
    System.out.println("Average breed weight of a Yorkshire is " + york.avgBreedWeight());
  }
}