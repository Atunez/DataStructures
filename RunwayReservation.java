import java.util.Scanner;

public class RunwayReservation {
	private static int n;
	private static int k;

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt(); // The total number of requests.
		k = kb.nextInt(); // Grace time between requests.

		// Variables for getting the input.
		String cmd;
		int time = 0;
		String flightname = null;
		String flightnumber = null;
		String source = null;
		String destination = null;
		int curtime = 0; // Current time, initialized to 0.

		// An array of requests. This is the data stored outside of our binary search tree.
		Requests [] reqs = new Requests[n];
		int i = 0;

		// Reading the input. All requests are read from the input file and stored in array reqs.
		while(kb.hasNext()) {
			cmd = kb.next();

			if (cmd.equals("r")) {
				time = kb.nextInt();
				flightname = kb.next();
				flightnumber = kb.next();
				source = kb.next();
				destination = kb.next();

				reqs[i++] = new Requests(cmd, time, flightname, flightnumber, source, destination);
			}
			else {
				time = kb.nextInt();
				reqs[i++] = new Requests(cmd, time);
			}
			kb.nextLine();
		}

		// TODO: Code to process each request and solve the Runway Reservation problem.
		BST flights = new BST();
		int timepassed = 0;

		for(int q = 0; q < n; q++){
	                if(reqs[q].getCommand().equals("r")){
                		// Insert into tree if valid request
         		       	if(flights.isValidRequest(reqs[q].getTime(), k) == true){
                		    flights.insert(reqs[q].getTime(), q);
                		}
            		}

			if(reqs[q].getCommand().equals("t")){
				timepassed += reqs[q].getTime();
				
				System.out.println("Current time = " + timepassed + " units");
				
				Node min = flights.min();
				while(min.getTime() < timepassed){
					System.out.println(reqs[min.getReq_index()].getAirline());
					flights.delete(min.getTime());
					min = flights.min();
				}
			}
		}

		
		Node max = flights.max();
		System.out.println("Current time = " + max.getTime() + " units");
		//flights.print();
        	Node min = null;
		//System.exit(0);
        	while (flights.isEmpty() == false) {
        	    min = flights.min();
        	    System.out.println(reqs[min.getReq_index()].getAirline());
        	    flights.delete(min.getTime());
        	}
	}
}
