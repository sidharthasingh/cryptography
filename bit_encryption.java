import java.util.Scanner;

class bit_encryption
{
	public static void main(String arg[])
	{
		Scanner sc=new Scanner(System.in);
		int opt=0;
		while(opt!=3)
		{
			System.out.print("\n1. Encode\n2. Decode \n3. Exit  : ");
			opt=sc.nextInt();
			switch(opt)
			{
				case 1:code.encode();break;
				case 2:code.decode();break;
			}
		}
	}
}

class code
{

	static boolean isDig(String s)
	{
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)>'9' || s.charAt(i)<'0')
				return false;
		return true;
	}

	static String toBinary(int x)
	{
		String str="";
		int r;
		while(x!=0)
		{
			r=x%2;
			str=r+str;
			x=x/2;
		}
		if(str.length()!=8)
			for(int l=8-str.length(),i=0;i<l;i++)
				str='0'+str;
		return str;
	}

	static int fromBinary(String s)
	{
		String str="";
		int i,j=0,sum=0;
		for(i=s.length()-1;i>=0;j++,i--)
		{
			if(s.charAt(i)=='1')
				sum+=Math.pow(2,j);
		}
		return sum;
	}

	static char keyOnChar(char x,String key)
	{
		String bin=code.toBinary((int)x);
		String str="";
		for(int i=0;i<bin.length();i++)
		{
			str+=bin.charAt(Integer.parseInt(new String(""+key.charAt(i)))-1);
		}
		return (char)code.fromBinary(str);
	}

	static void encode()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the String to encode : ");
		String s=sc.nextLine();
		System.out.print("Enter a 8 digit Key (1 - 8): ");
		String key=sc.nextLine();
		if(key.length()!=8 || !code.isDig(key))
		{
			System.out.println("Key not valid");
			return;
		}

		//Encoding algorithm starts

		String str="";
		for(int i=0;i<s.length();i++)
		{
			// str+=(int)code.keyOnChar(s.charAt(i),key)+" ";
			str+=code.keyOnChar(s.charAt(i),key);
		}
		System.out.print("The decoded String is      : "+str);
	}

	static char charOnKey(char c,String key)
	{
		String bin=code.toBinary((int)c);
		char arr[]=new char[bin.length()];
		for(int i=0;i<key.length();i++)
		{
			arr[Integer.parseInt(new String(""+key.charAt(i)))-1]=bin.charAt(i);
		}
		return (char)code.fromBinary(new String(arr));
	}

	static void decode()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the String to decode : ");
		String s=sc.nextLine();
		System.out.print("Enter a 8 digit Key (1 - 8): ");
		String key=sc.nextLine();
		if(key.length()!=8 || !code.isDig(key))
		{
			System.out.println("Key not valid");
			return;
		}

		//Encoding algorithm starts

		String str="";
		for(int i=0;i<s.length();i++)
		{
			// str+=(int)code.keyOnChar(s.charAt(i),key)+" ";
			str+=code.charOnKey(s.charAt(i),key);
		}
		System.out.print("The encoded String is      : "+str);
	}
}