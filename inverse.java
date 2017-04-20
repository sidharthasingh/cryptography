import java.util.Scanner;
class inverse
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
				case 1:codeInverse.encode();break;
				case 2:codeInverse.decode();break;
			}
		}
	}
}

class codeInverse
{
	
	static String Inverse(String a)
	{
		String str="";
		for(int i=0;i<a.length();i++)
		{
			str+=codeInverse.inv(a.charAt(i));
		}
		return str;
	}

	static char inv(char x)
	{
		if(x=='1')
			return '0';
		return '1';
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

	static void encode()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the String to encode : ");
		String s=sc.nextLine();

		//Encoding algorithm starts

		String str="";
		for(int i=0;i<s.length();i++)
		{
			// str+=(int)codeInverse.keyOnChar(s.charAt(i),key)+" ";
			str+=(char)codeInverse.fromBinary(codeInverse.Inverse(codeInverse.toBinary(s.charAt(i))));
		}
		System.out.print("The decoded String is      : "+str);
	}

	static void decode()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the String to decode : ");
		String s=sc.nextLine();

		//Encoding algorithm starts

		String str="";
		for(int i=0;i<s.length();i++)
		{
			// str+=(int)codeInverse.keyOnChar(s.charAt(i),key)+" ";
			str+=(char)codeInverse.fromBinary(codeInverse.Inverse(codeInverse.toBinary(s.charAt(i))));
		}
		System.out.print("The encoded String is      : "+str);
	}
}