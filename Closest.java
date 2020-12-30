import java.util.Scanner;
import java.io.*;
import java.lang.Math;

public class Closest {

	static int b = 1000;
	public static void main(String[] args)
	{
		Point[][] grid = new Point[b][b];
		double minimum = 2;

		try{
			Scanner read = new Scanner(System.in);
			while(read.hasNext())
			{
				double xVal = read.nextDouble();
				int x = hash(xVal); 
				double yVal = read.nextDouble();
				int y = hash(yVal); 
				grid[x][y] = new Point(xVal, yVal, grid[x][y]);
			}

		}
		catch (Exception e){
			System.out.println("NO INPUT PROVIDED");
		}
		for(int x = 0; x < b; x++) {
			for(int y = 0; y < b; y++){
				Point xCurrent = grid[x][y]; 
				while(xCurrent != null){
					for(int i = x - 1; i < x + 2; i++) {
						for (int j = y - 1; j < y + 2; j++){
							if (checkBounds(i, j)) {
								Point yCurrent = grid[x][y]; 
								while(yCurrent != null){
									if (xCurrent != yCurrent) { 
										double distance = findDistance(xCurrent.x, xCurrent.y, yCurrent.x, yCurrent.y);
										if (distance < minimum) 
											minimum = distance; 
									}
									yCurrent = yCurrent.next;
								}
							}
						}
					}
					xCurrent = xCurrent.next;
				}
			}
		}


		System.out.println("The closest pair of points is: " + minimum);
	}
	public static double findDistance(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt((Math.pow(x2-x1, 2) + (Math.pow(y2-y1, 2)))); 
	}

	public static boolean checkBounds(int x, int y)
	{
		if (x < 0 || x >= b || y >= b || y < 0) {
			return false;
		}
		else
			return true;
	}
	public static  int hash(double num)
	{
		return  ((int) (b * num));
	}
}
