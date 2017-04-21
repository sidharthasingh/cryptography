import java.util.Scanner;
class condenser
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
				case 1:codeCondense.encode();break;
				case 2:codeCondense.decode();break;
			}
		}
	}
}

class codeCondense
{

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

	static char  keyOnChar(char x)
	{
		String str="",s=codeCondense.toBinary((int)x);
		for(int i=0;i<s.length();i++)
		{
			if(i%2==0)
			{
				if(s.charAt(i)=='0')
					str+='1';
				else
					str+='0';
			}
			else
			{
				if(s.charAt(i)=='1')
					str+='1';
				else
					str+='0';
			}
		}
		return (char)codeCondense.fromBinary(str);
	}

	static char  charOnKey(char x)
	{
		String str="",s=codeCondense.toBinary((int)x);
		for(int i=0;i<s.length();i++)
		{
			if(i%2==0)
			{
				if(s.charAt(i)=='0')
					str+='1';
				else
					str+='0';
			}
			else
			{
				if(s.charAt(i)=='1')
					str+='1';
				else
					str+='0';
			}
		}
		return (char)codeCondense.fromBinary(str);
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
			// str+=(int)codexor.keyOnChar(s.charAt(i),key)+" ";
			str+=codeCondense.keyOnChar(s.charAt(i));
		}
		System.out.print("The encoded String is      : "+str);
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
			// str+=(int)codexor.keyOnChar(s.charAt(i),key)+" ";
			str+=codeCondense.charOnKey(s.charAt(i));
		}
		System.out.print("The decoded String is      : "+str);
	}
}