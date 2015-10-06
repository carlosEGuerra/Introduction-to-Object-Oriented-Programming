package cs1410;

import javax.swing.*;

/**
 * @author Carlos Guerra (u0847821)
 * This program takes the input from a user an calculates the car type, miles driven, MPG, and Gas cost per mile.
 */

public class GasMileage {
	
	/**
	 * This gets the user input and outputs the car type, gas cost, MPG, gas cost per mile.
	 */

	public static void main(String args[]) {
		
		//Initializing variables
		String carType, milesDriven, priceForGas, gallonsUsed, gasCost, MPG, costPerMile;
		int milesDrivenInt;
		double priceForGasDub, gallonsUsedDub;
		
		//gets the user input
		carType     = JOptionPane.showInputDialog("What is your type of car?");
		milesDriven = JOptionPane.showInputDialog("What is the number of miles driven since the last time the tank was filled?");
		priceForGas = JOptionPane.showInputDialog("What is the  current price in dollars for a gallon of gasoline?");
		gallonsUsed = JOptionPane.showInputDialog("What is the number of gallons used to fill the tank?");
		
		//formats the intput to workable variables
		milesDrivenInt = Integer.parseInt(milesDriven);
		priceForGasDub = Double.parseDouble(priceForGas);
        gallonsUsedDub = Double.parseDouble(gallonsUsed);

		//creates the return values
		gasCost = String.format("%.2f" , (priceForGasDub * gallonsUsedDub));
	    MPG = String.format("%.2f", (milesDrivenInt / gallonsUsedDub));	
		costPerMile = String.format("%.2f", ((priceForGasDub * gallonsUsedDub) / milesDrivenInt));

		//returns info to user
		JOptionPane.showMessageDialog(null, carType + "\n" 
										 + "Gas cost: " + gasCost + "\n"
										 + "Miles Per Gallon: " + MPG + "\n"
										 + "Gas Cost Per Mile: " + costPerMile);
	}
}