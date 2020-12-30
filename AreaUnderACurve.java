import java.util.Scanner;

public class AreaUnderACurve {

	/**
		The function f(x) = x^2 + x + 1.
	*/
	private static double f(double x) {
		return x * x + x + 1; 
	}

	/**
		Returns an approximation for the area under the curve f(x) between x = a and x = b.
	*/
	private static double computeArea(double a, double b) {
		double error = 1e-08; // This is the comparison error. See document for description.

		// TODO: Please compute an approximation for the area under the curve here.
		PriorityQueue curve = new PriorityQueue(9);

		double old = (b-a)*f(b);
		Interval start = new Interval (a,b);
		curve.insert(start);

		boolean difference = true;

		while(difference){
			Interval i = curve.remove_max();

			double m = i.getStart();
			double n = i.getEnd();
			double p = (n+m)/2;

			double newArea = old - ((n-m)*f(n)) + ((p-m)*f(p)) + ((n-p)*f(n));

			if(Math.abs(newArea - old) < error){
				difference = false;
			}

			curve.insert(new Interval(m,p));
			curve.insert(new Interval(p,n));

			old = newArea;
		}
		
		return old; // Remove this statement and return the computed area.
	}

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("We have the function f(x) = x^2 + x + 1.");
		System.out.print("Please enter lower value a: ");
		double a = kb.nextDouble();
		System.out.print("Please enter upper value b: ");
		double b = kb.nextDouble();

		double area = computeArea(a, b);
		System.out.println("\nAn approximation for the area under the curve f(x) \nbetween a = " + a + " and b = " + b + " is " + area);
	}
}
