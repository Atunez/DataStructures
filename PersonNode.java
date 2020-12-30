public class PersonNode{
	private String name;
	private PersonNode next;
	private int A;
	private int B;

	public PersonNode(String _name, PersonNode _next){
		name = _name;
		next = _next;
		A = 0;
		B = 0;
	}
	
	public String getKey(){
		return name;
	}

	public PersonNode getNext(){
		return next;
	}

	public void setNext(PersonNode _next){
		next = _next;
	} 

	public void updateA(){
		A++;
	}

	public int getA(){
		return A;
	}

	public void updateB(){
		B++;
	}

	public int getB(){
		return B;
	}

}