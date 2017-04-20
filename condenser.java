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
	static void encode()
	{

	}

	static void decode()
	{
		
	}
}