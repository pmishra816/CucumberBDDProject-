package Utilities;

public class Constructor {
	
	String s=null;
	int empId;
	
	public Constructor(String s, int empId)
	{
		this.empId=empId;
		this.s=s;
	}
	public static void main(String[] args) {
		
		Constructor c1=new Constructor("prashant", 30);
		Constructor c2=new Constructor("sushant", 28);
		
		System.out.println(c1.s);
		System.out.println(c1.empId);
		
		System.out.println(c2.s);
		System.out.println(c2.empId);
		
		
	}

}
