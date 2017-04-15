import java.util.Scanner;
class prime
{
	static boolean isPrime(int n)
	{
		int count=0;
		for(int i=1;i<=n/2;i++)
		{
			if(n%i==0)
				count++;
			if(count>2)
				break;
		}
		if(count>1)
			return false;
		return true;
	}
	static int[] prim(int n)
	{
		int j=0,arr[]=new int[n];
		for(int i=2;j<n;i++)
		{
			if(prime.isPrime(i))
				arr[j++]=i;
		}
		return arr;
	}
	static String cryp(String s)
	{
		String temp="";
		int x;
		char a=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)>a)
				a=s.charAt(i);
		}
		int arr[]=prime.prim(1+(int)a);
		for(int i=0;i<s.length();i++)
		{
			// System.out.println(i+"->"+arr[i]);
			temp+=arr[(int)s.charAt(i)];
		}
		return temp;
	}
	static int search(int arr[],int s,int n)
	{
		for(int i=0;i<n;i++)
			if(arr[i]==s)
				return i;
		return 0;
	}
	static String decryp(String s)
	{
		int i,j;
		String temp="";
		int arr[]=prime.prim(256);
		for(i=0,j=0;j<s.length();j++)
		{
			if(prime.isPrime(Integer.parseInt(s.substring(i,j+1))))
			{
				temp+=(char)arr[prime.search(arr,Integer.parseInt(s.substring(i,j+1)),256)];
				i=j+1;
			}
		}
		return temp;
	}
	public static void main(String arg[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the message to encrypt : ");
		String s=sc.nextLine();
		System.out.print("Encrypted Message is : "+prime.decryp(prime.cryp(s)));
	}
}