import java.util.Scanner;
class Number
{
	private String num;
	private static int addDigit(char a,char b)
	{
		return Integer.parseInt(""+a)+Integer.parseInt(""+b);
	}
	private static String mulNum(String ax,char b)
	{
		try
		{
			Number n=new Number(ax);
			Number sum=new Number(0);
			for(char a='0';a<b;a=(char)((int)a+1))
				sum=sum.add(n);
			return sum.retNum();
		}
		catch(Exception e)
		{

		}
		return "";
	} 
	Number()
	{
		num="0";
	}
	Number(int n)
	{
		num=""+n;
	}
	Number(String n) throws Exception
	{
		if(!Number.checkNum(n))
			throw new Exception("NOT A VALID NUMBER");
		else
			num=n;
	}
	static boolean checkNum(String n)
	{
		for(int i=0;i<n.length();i++)
			if(n.charAt(i)>'9' || n.charAt(i)<'0')
				return false;
		return true;
	}
	void setNum(String n) throws Exception
	{
		if(!Number.checkNum(n))
			throw new Exception("NOT A VALID NUMBER");
		else
			num=n;
	}
	void setNum(int n)
	{
		num=""+n;
	}
	String retNum()
	{
		return num;
	}

	// INCREASE BY X

	void inc(Number x)
	{
		try
		{
			this.setNum(this.add(x).retNum());
		}
		catch(Exception e)
		{

		}
	}

	void inc(int x)
	{
		this.inc(new Number(x));
	}

	// ADDITION

	static Number add(Number ax,Number bx) throws Exception
	{
		String a=ax.retNum();
		String b=bx.retNum();
		if(!Number.checkNum(a) || !Number.checkNum(b))
			throw new Exception("ADDITION OF NON-VALID NUMBER");
		int la=a.length(),lb=b.length();
		if(la!=lb)
		{
			String str="";
			if(la<lb)
			{
				for(int i=0;i<lb-la;i++)
					str+='0';
				a=str+a;
			}
			else if(lb<la)
			{
				for(int i=0;i<la-lb;i++)
					str+='0';
				b=str+b;
			}
		}
		String str="";
		char c='0';
		int sum;
		for(int i=a.length()-1;i>=0;i--)
		{
			sum=Integer.parseInt(""+c)+Number.addDigit(a.charAt(i),b.charAt(i));
			str=(sum%10)+str;
			c=(char)((sum/10)+48);
		}
		if(c!='0')
			str=c+str;
		return new Number(str);
	}

	Number add(int x)
	{
		try
		{
			return this.add(new Number(x));
		}
		catch(Exception e)
		{

		}
		return null;
	}

	Number add(Number ax) throws Exception
	{
		String a=ax.retNum();
		String b=this.retNum();
		if(!Number.checkNum(a) || !Number.checkNum(b))
			throw new Exception("ADDITION OF NON-VALID NUMBER");
		int la=a.length(),lb=b.length();
		if(la!=lb)
		{
			String str="";
			if(la<lb)
			{
				for(int i=0;i<lb-la;i++)
					str+='0';
				a=str+a;
			}
			else if(lb<la)
			{
				for(int i=0;i<la-lb;i++)
					str+='0';
				b=str+b;
			}
		}
		String str="";
		char c='0';
		int sum;
		for(int i=a.length()-1;i>=0;i--)
		{
			sum=Integer.parseInt(""+c)+Number.addDigit(a.charAt(i),b.charAt(i));
			str=(sum%10)+str;
			c=(char)((sum/10)+48);
		}
		if(c!='0')
			str=c+str;
		return new Number(str);
	}

	// MULTIPLICATION

	static Number mul(Number ax,Number bx) throws Exception
	{
		String a=ax.retNum();
		String b=bx.retNum();
		int l=b.length();
		if(!Number.checkNum(a) || !Number.checkNum(b))
			throw new Exception("ADDITION OF NON-VALID NUMBER");
		Number sum=new Number(0);
		for(int i=b.length()-1;i>=0;i--)
		{
			String tempstr="";
			String mulResult=Number.mulNum(a,b.charAt(i));
			for(int j=0;j<l-i-1;j++)
				tempstr+='0';
			mulResult+=tempstr;
			try
			{
				sum=sum.add(new Number(mulResult));
			}
			catch(Exception e)
			{

			}
		}
		return sum;
	}

	Number mul(Number ax) throws Exception
	{
		String a=ax.retNum();
		String b=this.retNum();
		int l=b.length();
		if(!Number.checkNum(a) || !Number.checkNum(b))
			throw new Exception("ADDITION OF NON-VALID NUMBER");
		Number sum=new Number(0);
		for(int i=b.length()-1;i>=0;i--)
		{
			String tempstr="";
			String mulResult=Number.mulNum(a,b.charAt(i));
			for(int j=0;j<l-i-1;j++)
				tempstr+='0';
			mulResult+=tempstr;
			try
			{
				sum=sum.add(new Number(mulResult));
			}
			catch(Exception e)
			{

			}
		}
		return sum;
	}

	// EXPONENTIAL

	Number pow(Number a,Number b)
	{
		return null;
	}

	// LESS THAN

	boolean lessThan(int x)
	{
		return this.lessThan(new Number(x));
	}

	boolean lessThan(String x)
	{
		try
		{
			return this.lessThan(new Number(x));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	boolean lessThan(Number bx)
	{
		String a=this.retNum();
		String b=bx.retNum();
		int la=a.length(),lb=b.length();
		if(la!=lb)
		{
			String str="";
			if(la<lb)
			{
				for(int i=0;i<lb-la;i++)
					str+='0';
				a=str+a;
			}
			else if(lb<la)
			{
				for(int i=0;i<la-lb;i++)
					str+='0';
				b=str+b;
			}
		}
		char x,y;
		int count=0;
		for(int i=0;i<a.length();i++)
		{
			x=a.charAt(i);
			y=b.charAt(i);
			if(x>y)
				return false;
			else if(x<y)
				return true;
			else if(x==y)
				count++;
		}
		if(count==a.length())
			return false;
		return true;
	}

	// EQUAL TO

	boolean equalTo(int x)
	{
		return this.equalTo(new Number(x));
	}

	boolean equalTo(String x)
	{
		try
		{
			return this.equalTo(new Number(x));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	boolean equalTo(Number bx)
	{
		String a=this.retNum();
		String b=bx.retNum();
		int la=a.length(),lb=b.length();
		if(la!=lb)
		{
			String str="";
			if(la<lb)
			{
				for(int i=0;i<lb-la;i++)
					str+='0';
				a=str+a;
			}
			else if(lb<la)
			{
				for(int i=0;i<la-lb;i++)
					str+='0';
				b=str+b;
			}
		}
		for(int i=0;i<a.length();i++)
		{
			if(a.charAt(i)!=b.charAt(i))
				return false;
		}
		return true;
	}

	// GREATER THAN

	boolean graeterThan(int x)
	{
		return this.greaterThan(new Number(x));
	}

	boolean greaterThan(String x)
	{
		try
		{
			return this.greaterThan(new Number(x));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	boolean greaterThan(Number bx)
	{
		String a=this.retNum();
		String b=bx.retNum();
		int la=a.length(),lb=b.length();
		if(la!=lb)
		{
			String str="";
			if(la<lb)
			{
				for(int i=0;i<lb-la;i++)
					str+='0';
				a=str+a;
			}
			else if(lb<la)
			{
				for(int i=0;i<la-lb;i++)
					str+='0';
				b=str+b;
			}
		}
		char x,y;
		int count=0;
		for(int i=0;i<a.length();i++)
		{
			x=a.charAt(i);
			y=b.charAt(i);
			if(x<y)
				return false;
			else if(x>y)
				return true;
			else if(x==y)
				count++;
		}
		if(count==a.length())
			return false;
		return true;
	}

	// COMPARE

	int compare(Number bx)
	{
		String a=this.retNum();
		String b=bx.retNum();
		int la=a.length(),lb=b.length();
		if(la!=lb)
		{
			String str="";
			if(la<lb)
			{
				for(int i=0;i<lb-la;i++)
					str+='0';
				a=str+a;
			}
			else if(lb<la)
			{
				for(int i=0;i<la-lb;i++)
					str+='0';
				b=str+b;
			}
		}
		char x,y;
		for(int i=0;i<a.length();i++)
		{
			x=a.charAt(i);
			y=b.charAt(i);
			if(x<y)
				return -1;
			else if(x>y)
				return 1;
		}
		return 0;
	}

	static int compare(Number ax,Number bx)
	{
		String a=ax.retNum();
		String b=bx.retNum();
		int la=a.length(),lb=b.length();
		if(la!=lb)
		{
			String str="";
			if(la<lb)
			{
				for(int i=0;i<lb-la;i++)
					str+='0';
				a=str+a;
			}
			else if(lb<la)
			{
				for(int i=0;i<la-lb;i++)
					str+='0';
				b=str+b;
			}
		}
		char x,y;
		for(int i=0;i<a.length();i++)
		{
			x=a.charAt(i);
			y=b.charAt(i);
			if(x<y)
				return -1;
			else if(x>y)
				return 1;
		}
		return 0;
	}
}
class number
{
	public static void main(String arg[])
	{
		try
		{
			Number i=new Number("0");
			for(;i.lessThan(new Number("10000000"));i.inc(1))
				System.out.println(i.retNum());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}