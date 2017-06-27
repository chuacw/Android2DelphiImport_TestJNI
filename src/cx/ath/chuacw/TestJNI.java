package cx.ath.chuacw;

public class TestJNI {

	int A, B, C, D;
	String s;
	
   
   public TestJNI(int A, int B, int C, int D, String s) {
	   this.A = A;
	   this.B = B;
	   this.C = C;
	   this.D = D;
	   this.s = s;
	   System.out.println("toString: " + this.toString());
	   System.out.println("this: " + this);
   }
   
   // The Result methods will be called from Delphi, and thus the parameters are passed
   // from Delphi. These methods tests that the marshalling code is correct and
   // generates the expected results, as well as ensure that the marshalling code and
   // code generation for the Delphi interfaces and implemenation are correct.
   
   public int[] Result(int A, float B) {
	   int[] LResult = new int[3];
	   LResult[0] = A;
	   LResult[1] = (int)B;
	   LResult[2] = LResult[0] * LResult[1];
	   return LResult;
   }
   
   public Double[] Result(int A, int B) {
	   Double[] LResult = new Double[3];
	   LResult[0] = A*1.0D;
	   LResult[1] = B*1.0D;
	   LResult[2] = LResult[0] * LResult[1];
	   return LResult;
   }
	
   public Float[] Result(float A, float B) {
	   Float[] LResult = new Float[3];
	   LResult[0] = A*1.0f;
	   LResult[1] = B*1.0f;
	   LResult[2] = LResult[0] * LResult[1];
	   return LResult;
   }
   
   public float floatValue(float A) {
	   return A;
   }
   
   public double doubleValue(double A) {
	   return A;
   }
   
   public void A1(int A, int B, int C, int D) {
	   System.out.println("In A1");
	   System.out.println(String.format("%x", A));
	   System.out.println(String.format("%x", B));
	   System.out.println(String.format("%x", C));
	   System.out.println(String.format("%x", D));
   }
   
   public void setParams(int A, int B, int C, int D) {
	   System.out.println("setting params");
	   this.A = A;
	   this.B = B;
	   this.C = C;
	   this.D = D;
   }
   
   public void assignStr(String s) {
	   this.s = s;
	   System.out.println(s);
   }
   
   public float getFloat() {
	   return 1.0f;
   }
   
   public double getDouble() {
	   return 1.0d;
   }
   
   public void showFloat(float A) {
	   System.out.println(A);
   }
   
   public void showDouble(double A) {
	   System.out.println(A);
   }
   
   public String[] getString(String A, int length) {
	  String[] result = new String[length];
	  for (int i=0; i<result.length; i++)
		  result[i] = A+String.valueOf(i);
	  return result;
   }

   public void showDouble(double A, double B, float C, double D, double E, double F, float G) {
	   System.out.println(A);
	   System.out.println(B);
	   System.out.println(C);
	   System.out.println(D);
	   System.out.println(E);
	   System.out.println(F);
	   System.out.println(G);
   }

   public int setParams(int A, int B, int C) {
	   this.A = A;
	   this.B = B;
	   this.C = C;
	   return 0x10002222;
   }
   
   public long setParams(int A, int B) {
	   this.A = A;
	   this.B = B;
	   return 0x7fff88889999ffffL;
   };
   
   public void showSelf() {
	   System.out.println("Showing self");
	   System.out.println(String.format("%x", A));
	   System.out.println(String.format("%x", B));
	   System.out.println(String.format("%x", C));
	   System.out.println(String.format("%x", D));
   }
   
   public static void main(String[] args) {
	   System.out.println("args length: "+args.length);
	   if (args.length>0) {
		   for (int i=0;i<args.length;i++)
			   System.out.println(String.format("args %d: '%s'", new Object[]{i, args[i]}));
	   }
	   TestJNI t = new TestJNI(1, 2, 3, 4, "Blah");
	   t.A1(0x1000, 0x2000, 0x3000, 0x4000);
	   t.setParams(0x1000, 0x2000, 0x3000, 0x4000);
	   t.showSelf();
   }
   
}
