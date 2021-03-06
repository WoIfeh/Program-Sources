/*
 * ################################################################################
 * Name: Billy Hart
 * Chapter: 6
 * Assignment: Programming Challenge 9 - Requisite Class
 * Date: 10/13/15
 * Description: Class file that stores substance information including type and
 *              boiling/freezing temperature information. Getters return boolean
 *              values to represent substance temperature range.
 *
 * Side note:   Optimally I would have used two methods, isSubstanceFreezing() and
 *              isSubstanceBoiling().
 * ################################################################################
*/

/*
 * ## UML Table ###################################################################
 * SubstanceInfo                                                                  |
 * -------------------------------------------------------------------------------|
 * - substanceType : String                                                       |
 * - freezingTemp  : int                                                          |
 * - boilingTemp   : int                                                          |
 * -------------------------------------------------------------------------------|
 * + SubstanceInfo()                                                              |
 * + isEthylFreezing(temperatureToCheck)  : boolean                               |
 * + isEthylBoiling(temperatureToCheck)   : boolean                               |
 * + isOxygenFreezing(temperatureToCheck) : boolean                               |
 * + isOxygenBoiling(temperatureToCheck)  : boolean                               |
 * + isWaterFreezing(temperatureToCheck)  : boolean                               |
 * + isWaterBoiling(temperatureToCheck)   : boolean                               |
 * ################################################################################
*/

public class SubstanceInfo
{
    // Instance Variables
    private String substanceType;
    private int freezingTemp;
    private int boilingTemp;

    // Constructor
    public SubstanceInfo(String substanceName, int freezingPoint, int boilingPoint)
    {
      this.substanceType = substanceName;
      this.freezingTemp = freezingPoint;
      this.boilingTemp = boilingPoint;
    }

    // Getters: Determine substance freezing/boiling points
      // Ethyl
      public boolean isEthylFreezing(int temperatureToCheck)
      {
        return (temperatureToCheck <= this.freezingTemp) ? true : false;
      }

      public boolean isEthylBoiling(int temperatureToCheck)
      {
        return (temperatureToCheck >= this.boilingTemp) ? true : false;
      }

      // Oxygen
      public boolean isOxygenFreezing(int temperatureToCheck)
      {
        return (temperatureToCheck <= this.freezingTemp) ? true : false;
      }

      public boolean isOxygenBoiling(int temperatureToCheck)
      {
        return (temperatureToCheck >= this.boilingTemp) ? true : false;
      }

      // Water
      public boolean isWaterFreezing(int temperatureToCheck)
      {
        return (temperatureToCheck <= this.freezingTemp) ? true : false;
      }

      public boolean isWaterBoiling(int temperatureToCheck)
      {
        return (temperatureToCheck >= this.boilingTemp) ? true : false;
      }
}