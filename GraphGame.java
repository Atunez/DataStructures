import java.util.Scanner;

public class GraphGame{
	

	static boolean[][] graph;
	static int minimum = Integer.MAX_VALUE;
	static int maximum = 0;
	static int[][] coloredgraph;
	static boolean[][] visited;
	static int[][] finalcolored;
	static int[][] actualfinalcolored;
	static Queue queue = new Queue();
	static int s1 = 0;
	static int s2 = 0;
	static int sf1 = 0;
	static int sf2 = 0;
	static int n = 0;

	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		int m = kb.nextInt();
		
		// Graph starting at 1, holds n edges.
		graph = new boolean[n+1][n+1];
		visited = new boolean[n+1][n+1];
		coloredgraph = new int[n+1][n+1];
		finalcolored = new int[n+1][n+1];
		actualfinalcolored = new int[n+1][n+1];

		

		while(m != 0){
			int x = kb.nextInt();
			int y = kb.nextInt();
			graph[x][y] = true;
			if(s1 == 0){
				s1 = x;
				//s2 = y;
			}
			if(x > sf1){
				sf1 = x;
			}
			if(y > sf1){
				sf1 = y;
			}
			m--;
		}
		
		//System.out.println(sf1);

		kb.close();

		bfs(1);

		//int[] checker = new int[2];
		//checker = findnext(s1,s2);
		//System.out.print(s1);
		//System.out.print(s2);
		//System.out.println();
		//while(checker[0] != -1 && checker[1] != -1){
		//	System.out.print(checker[0]);
		//	System.out.print(checker[1]);
		//	System.out.println();
		//	checker = findnext(checker[0], checker[1]);
		//}
	}
	

	public static void bfs(int x){
		int[] neighbors = findneighbors(x);

		Node start = new Node(x);
		start.setdistance(0);
		start.setneighbors(findneighbors(start.getnumber()));
		queue.enqueue(start);

		Node prev = start;


		while(queue.isEmpty() == false){
			Node current = queue.dequeue();
			prev = current;
			int[] neighb = current.getneighbors();

			for(int q : neighb){
				if(q != 0 && q != -1 && (queue.find(q) == false) && (queue.history(q) == false)){
					//System.out.println("Current Node is: " + current.getnumber());
					//System.out.println("Added node is: " + q);
					Node temp = new Node(q);
					temp.setneighbors(findneighbors(temp.getnumber()));
					if(q == s1){
						temp.setdistance(0);
					}else{
						//System.out.println("Node is: " + q + " distance is: " + (prev.getdistance() + 1));
						temp.setdistance(prev.getdistance() + 1);
					}

					//if( (current.getneighbors())[0] == -1 || current.getnumber() == sf1){
				//		System.out.println(current.getdistance()-1);
				//		break;
				//	}


					queue.enqueue(temp);
				}
			}
			

			if( (current.getneighbors())[0] == -1 || current.getnumber() == sf1){
				System.out.println(current.getdistance()-1);
				//break;
			}
			
			//System.out.println("The print");
			//queue.print();
			
		}


		

		
	
	}

	public static int[] findneighbors(int x){
		int[] answer = {-1};

		if(x > sf1 || x == -1){
			return answer;
		}

		int[] pairs = new int[2*(n+1)]; // y values duh.
		for(int i = 0; i < n+1; i++){
			if(graph[x][i]){
				pairs[i] = i;
			}
		}

		for(int i = n+1; i < 2*(n+1); i++){
			if(graph[i-(n+1)][x]){
				pairs[i] = i-(n+1);
			}
			
		}

		return pairs;


	}

	public static void checkcolors(int x, int colornow, int colorbefore, int colorchanges){
		// Check the column, then move along each of the nodes in order

		if(colornow != colorbefore && colornow != 0 && colorbefore != 0){	
			colorchanges++;
			//System.out.println(x + " " + colornow + " " + colorbefore + " " + colorchanges);
		}

		// find all connections, 
		int[] pairs = new int[n+1]; // y values duh.
		for(int i = 0; i < n+1; i++){
			if(graph[x][i]){
				pairs[i] = i;
			}
		}
		
		for(int points : pairs){
			if(points == 0){
			}else{
				if(coloredgraph[x][points] == 0){
					System.out.println("bro you stupid");
					System.out.println(x);
					System.out.println(points);

				}
				checkcolors(points, coloredgraph[x][points], colornow, colorchanges);
			}
		}	

		//end
		if(isEmpty(pairs) == true){
			//System.out.println(colorchanges);
			if(minimum > colorchanges){
				minimum = colorchanges;
			}
			return;
		}
		
	}

	public static boolean isEmpty(int[] array){
		for(int i = 0; i < n+1; i++){
			if(array[i] != 0){
				return false;
			}
		}
		return true;
	}

	public static int[] findnext(int x, int y){
		int[] answer = {-1,-1};

		//System.out.println("Here is the input: x = " + x + " y = " + y);
		
		if(x > sf1 || x == -1){
			return answer;
		}

		int[] pairs = new int[n+1]; // y values duh.
		for(int i = 0; i < n+1; i++){
			if(graph[x][i]){
				pairs[i] = i;
			}
		}

		boolean exists = false;
		int whatsfound = 0;
		for(int points : pairs){
			if(points == 0){
			}else{
				//if(x == 4 && points == 5){
				//	System.out.println("thonkers");
				//}
				if(points <= y){
					continue;
				}else{
					if(whatsfound == 0){
						whatsfound = points;
					}
					exists = true;
				}
			}
		}

		if(exists == false){
			//System.out.println("here is one problem: " + x + " with " + y);
			return findnext(x+1,0);
		}else{
			//answer = {x, whatsfound};
			answer[0] = x;
			answer[1] = whatsfound;
			return answer;
		}
	}


}
