package studio2;

import java.util.Scanner;

public class GamblersRuin {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Amount of money: ");
		double startAmount = in.nextDouble();
		System.out.print("chance of winning: ");
		double winChance = in.nextDouble();
		System.out.print("win limit: ");
		double winLimit = in.nextDouble();
		System.out.print("total simuluations: ");
		int totalSimulations = in.nextInt();

		int days;
		int plays = 0;
		boolean result = false;
		double currentAmount = startAmount;
		int ruin = 0;
		double expectedRuin = (1-winChance)/winChance;
		
		for (days = 1; days <= totalSimulations; days++)
		{
			while (currentAmount>0 && currentAmount<winLimit)
			{
				double probability = Math.random();
				plays++;
				if (probability < winChance){
					currentAmount++;
					result = true;
				}
				else {
					currentAmount--;
					result = false;
				}
			}
			if (result) {
				System.out.println("Simulation " + days + ": " + plays + " WIN");
			}
			else {
				ruin++;
				System.out.println("Simulation " + days + ": " + plays + " LOSE");
			}
			currentAmount = startAmount;
			plays = 0;
		}
		
		System.out.println("Ruin rate: " + (1.0*ruin)/totalSimulations);
		
		if(winChance == 0.5) {
			System.out.println("Expected ruin rate: " + (1-((startAmount)/winLimit)));
		}
		else {
			System.out.println("Expected ruin rate: " + (Math.pow(expectedRuin, startAmount)-Math.pow(expectedRuin, winLimit))/(1-Math.pow(expectedRuin, winLimit)));
		}
		
	}
}