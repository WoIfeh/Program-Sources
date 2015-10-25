public class RetailItem
{
    // Instance variables
    private String description;
    private int unitsOnHand;
    private double price;

    // Constructors
    public RetailItem(String name, int number, double cost)
    {
      description = name;
      unitsOnHand = number;
      price = cost;
    }

    public RetailItem()
    {
      description = "default";
      unitsOnHand = 0;
      price = 0.00;
    }

    // other methods - mutators/setters
    public void setDescription(String name)
    {
      description = name;
    }

    // other methods - accessors/setters
    public String getDescription()
    {
      return description;
    }

}