import java.util.Scanner;
class xor
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
				case 1:codexor.encode();break;
				case 2:codexor.decode();break;
			}
		}
	}
}

class codexor
{
	
	static String Xor(String a,String b)
	{
		char x,y;
		String str="";
		for(int i=0;i<a.length();i++)
		{
			x=a.charAt(i);
			y=b.charAt(i);
			if(x==y)
				str+="0";
			else
				str+="1";
		}
		return str;
	}

	static char inv(char x)
	{
		if(x=='1')
			return '0';
		return '1';
	}

	static String invXor(String a,String b)
	{
		// a is the decodable String, b is the key 
		char x,y;
		String str="";
		for(int i=0;i<a.length();i++)
		{
			x=a.charAt(i);
			y=b.charAt(i);
			if(x=='1')
				str+=codexor.inv(y);
			else
				str+=y;
		}
		return str;
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

	static char keyOnChar(char x,char key)
	{
		return (char)codexor.fromBinary(codexor.Xor(codexor.toBinary((int)x),codexor.toBinary((int)key)));
	}

	static void encode()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the String to encode : ");
		String s=sc.nextLine();
		System.out.print("Enter a 8 digit Key (1 - 8): ");
		String key=sc.nextLine();
		if(key.length()!=8)
		{
			System.out.println("Key not valid");
			return;
		}

		//Encoding algorithm starts

		String str="";
		for(int i=0;i<s.length();i++)
		{
			// str+=(int)codexor.keyOnChar(s.charAt(i),key)+" ";
			str+=codexor.keyOnChar(s.charAt(i),key.charAt(i%8));
		}
		System.out.print("The decoded String is      : "+str);
	}

	static char charOnKey(char c,char key)
	{
		return (char)codexor.fromBinary(codexor.invXor(codexor.toBinary((int)c),codexor.toBinary((int)key)));
	}

	static void decode()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the String to decode : ");
		String s=sc.nextLine();
		System.out.print("Enter a 8 digit Key (1 - 8): ");
		String key=sc.nextLine();
		if(key.length()!=8)
		{
			System.out.println("Key not valid");
			return;
		}

		//Encoding algorithm starts

		String str="";
		for(int i=0;i<s.length();i++)
		{
			// str+=(int)codexor.keyOnChar(s.charAt(i),key)+" ";
			str+=codexor.charOnKey(s.charAt(i),key.charAt(i%8));
		}
		System.out.print("The encoded String is      : "+str);
	}
}