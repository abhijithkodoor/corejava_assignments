import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Arithmetic{
	double num1,num2;

	public Arithmetic(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}
	abstract void calculate();
	
}
class addition extends Arithmetic{

	public addition(double num1, double num2) {
		super(num1, num2);
		
	}

	@Override
	void calculate() {
		System.out.println("Sum ="+(num1+num2));
	}

	
}
class subtraction extends Arithmetic{

	public subtraction(double num1, double num2) {
		super(num1, num2);
	}

	@Override
	void calculate() {
		System.out.println("Difference ="+(num1-num2));

	}
	
}
class multiplication extends Arithmetic{

	public multiplication(double num1, double num2) {
		super(num1, num2);
	}

	@Override
	void calculate() {
		System.out.println("Product ="+(num1*num2));

	}
	
}
class division extends Arithmetic{

	public division(double num1, double num2) {
		super(num1, num2);
	}

	@Override
	void calculate() {
		System.out.println("Sum ="+(num1/num2));

	}
	
}
public class Calculator {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		Arithmetic a[]=new Arithmetic[4];
		int num1,num2;
		System.out.println("Enter number 1");
		num1=Integer.parseInt(br.readLine());
		System.out.println("Enter number 2");
		num2=Integer.parseInt(br.readLine());
		System.out.println("Enter:\n1 to add\n2 to subtract\n3 to multiply\n4 to divide");
		int choice=Integer.parseInt(br.readLine());
		a[0]=new addition(num1, num2);
		a[1]=new subtraction(num1, num2);
		a[2]=new multiplication(num1, num2);
		a[3]=new division(num1, num2);
		a[choice-1].calculate();
		
	}

}
