import java.util.Scanner;

public class Chapter4AWNum1 
{

    public static void main(String[] args)
    {
    	Scanner input = new Scanner(System.in);
    	// 289
    	int numUser = 0, product = 0;
    	
    	while (product < 100)
    	{
    		System.out.print("Enter a number: ");
    		numUser = input.nextInt();
    		product = numUser * 10;
    	}
    }
    
    
}