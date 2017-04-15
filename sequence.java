import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
class sequence
{
	static String toBinary(int n)
	{
		String temp="";
		int r;
		while(n!=0)
		{
			r=n%2;
			temp=r+temp;
			n/=2;
		}
		if(temp.length()<7)
			while(temp.length()!=7)
				temp='0'+temp;
		return temp;
	}
	static int toDec(String s)
	{
		int temp=0,i,j=0;
		for(i=s.length()-1;i>=0;i--,j++)
		{
			if(s.charAt(i)=='1')
				temp+=Math.pow(2,j);
		}
		return temp;
	}
	static String encrypt(String s)
	{
		String temp2="",temp="";
		int i,j=0;
		Random rand=new Random();
		for(i=0;i<3;i++)
			temp+=rand.nextInt(2);
		for(i=0;i<s.length();i++)
			temp+=sequence.toBinary((int)s.charAt(i));
		for(i=0;i<4;i++)
			temp+=rand.nextInt(2);
		for(i=0,j=6;i<temp.length() && j<temp.length();i+=7,j+=7)
			temp2+=(char)sequence.toDec(temp.substring(i,j+1));
		return temp2;
	}
	static String decrypt(String s)
	{
		String temp2="",temp="";
		int i,j;
		for(i=0;i<s.length();i++)
			temp+=sequence.toBinary((int)s.charAt(i));
		temp=temp.substring(3,temp.length()-4);
		for(i=0,j=6;i<temp.length() && j<temp.length();i+=7,j+=7)
			temp2+=(char)sequence.toDec(temp.substring(i,j+1));
		return temp2;
	}
	public static void main(String arg[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the string : ");
		String s=sc.nextLine();
		s=sequence.encrypt(s);
		System.out.println("Encrypted String : "+s);
		s=sequence.decrypt(s);
		System.out.println("Decrypted String : "+s);
	}
}