public class TestRetailItem
{
  public static void main(String[] args)
  {
    RetailItem item1 = new RetailItem("Jacket", 12, 59.95);
    RetailItem item2 = new RetailItem("Designer Jeans", 40, 34.95);
    RetailItem item3 = new RetailItem();

    println(item1.getDescription());
    item1.setDescription("Coat");
    println(item1.getDescription());
    println(item3.getDescription());
  }

  public static void print(String words)
  {
    System.out.print(words);
  }

  public static void println(String words)
  {
    System.out.println(words);
  }

}