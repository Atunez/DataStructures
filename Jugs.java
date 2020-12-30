import java.util.Scanner;
public class Jugs{

	private int a, b, c;
	private boolean[][] visited;
	private String[][] op;
	private int[][] prvA, prvB;
	static int fa, fb;
	int n = 1002;
	public Jugs(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
		this.visited = new boolean[n][n];
		this.op = new String[n][n];
		this.prvB = new int[n][n];
		this.prvA = new int[n][n];
	}

	private boolean visit(int a, int b, int prvA, int prvB, String op){
		if(a > this.a || b > this.b || visited[a][b] == true || 0 > a || 0 > b){
			return false;
		}

		this.visited[a][b] = true;
		this.prvA[a][b] = prvA;
		this.prvB[a][b] = prvB;
		this.op[a][b] = op;		
		boolean operation = false;

		if(a + b == this.c){
			fa = a;
			fb = b;
			return true;
		}


		operation = visit(this.a,b,a,b,"Fill Jug 1");
		if(operation){
			return true;
		}
		operation = visit(a,this.b,a,b,"Fill Jug 2");
		if(operation){
			return true;
		}
		operation = visit(0,b,a,b,"Empty Jug 1");
		if(operation){
			return true;
		}
		operation = visit(a,0,a,b,"Empty Jug 2");
		if(operation){
			return true;
		}
		int fillA = 0;
		int fillB = 0;
		if(a > (this.b - b)){
			fillA = a-(this.b - b);
			fillB = this.b;
		}else{
			fillA = 0;
			fillB = b+a;
		}	
		operation = visit(fillA,fillB,a,b,"Pour Jug 1 -> Jug 2");
		if(operation){
			return true;
		}
		if(b > (this.a - a)){
			fillA = this.a;
			fillB = b-(this.a - a);
		}else{
			fillA = b+a;
			fillB = 0;
		}	
		operation = visit(fillA,fillB,a,b,"Pour Jug 2 -> Jug 1");
		if(operation){
			return true;
		}
		return false;
	}

	private void printanswer(int a, int b){
		if(a == 0 && b == 0){
			return;
		}
		printanswer(this.prvA[a][b],this.prvB[a][b]);
		System.out.println(op[a][b] + " [a = " + a + ", b = " + b + "]");
	}

	public static void main(String[] args){
	        Scanner scanner = new Scanner(System.in);
        
		System.out.print("Enter A: ");
        	int a = scanner.nextInt();
        
		System.out.print("Enter B: ");
        	int b = scanner.nextInt();
        
		System.out.print("Enter C: ");
        	int c = scanner.nextInt();

		scanner.close();

		Jugs jug = new Jugs(a,b,c);
		
		boolean answer = jug.visit(0,0,-1,-1,"");

		if(answer){
			System.out.println("Yay! Found a solution.");	
			jug.printanswer(fa, fb);
		}else{
			System.out.println("Impossible!");	

		}
	}
}