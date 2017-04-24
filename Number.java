public class Number
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

	static int singleDiv(String n,String m)
	{
		try
		{
			Number num=new Number(m);
			Number div=new Number(n);
			Number i=new Number(0);
			Number temp=new Number(0);
			for(;!temp.greaterThan(num);)
			{
				i.inc(1);
				temp=Number.mul(div,i);
			}
			return Integer.parseInt(i.sub(new Number(1)).retNum());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return -1;
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

	// REFRESH THE NUMBER (REMOVE REDUNDANT 0's etc.)

	void refresh()
	{
		String str="";
		int i;
		for(i=0;i<num.length();i++)
			if(num.charAt(i)!='0')
			{
				str+=num.charAt(i);
				i++;
				break;
			}
		for(;i<num.length();i++)
			str+=num.charAt(i);
		if(str.length()==0)
			num="0";
		else
			num=str;
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

	Number mul(Number ax)
	{
		String a=ax.retNum();
		String b=this.retNum();
		int l=b.length();
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

	static Number pow(Number a,Number b)
	{
		try
		{
			Number ret=new Number(1);
			for(Number i=new Number(0);i.lessThan(b);i.inc(1))
				ret=Number.mul(ret,a);
			return ret;
		}
		catch(Exception e)
		{

		}
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

	// SUBTRACTION

	static Number sub(Number ax,Number bx)
	{
		if(bx.greaterThan(ax))
			return Number.sub(bx,ax);
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
		int arr[]=new int[a.length()];
		int l=a.length();
		int brr[]=new int[b.length()];
		String str="";
		for(int i=0;i<l;i++)
		{
			arr[i]=(int)a.charAt(i)-48;
			brr[i]=(int)b.charAt(i)-48;
		}
		for(int i=l-1;i>=0;i--)
		{
			if(arr[i]-brr[i]<0)
			{
				arr[i-1]-=1;
				arr[i]+=10;
			}
			str=((char)(arr[i]-brr[i]+48))+str;
		}
		try
		{
			Number n=new Number(str);
			n.refresh();
			return n;
		}
		catch(Exception e)
		{

		}
		return null;
	}

	Number sub(Number bx)
	{
		if(bx.greaterThan(this))
			return Number.sub(bx,this);
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
		int arr[]=new int[a.length()];
		int l=a.length();
		int brr[]=new int[b.length()];
		String str="";
		for(int i=0;i<l;i++)
		{
			arr[i]=(int)a.charAt(i)-48;
			brr[i]=(int)b.charAt(i)-48;
		}
		for(int i=l-1;i>=0;i--)
		{
			if(arr[i]-brr[i]<0)
			{
				arr[i-1]-=1;
				arr[i]+=10;
			}
			str=((char)(arr[i]-brr[i]+48))+str;
		}
		try
		{
			Number n=new Number(str);
			n.refresh();
			return n;
		}
		catch(Exception e)
		{

		}
		return null;
	}

	// DIVISION

	static Number div(Number n,Number m) throws Exception
	{
		n.refresh();
		m.refresh();
		boolean checkn=n.equalTo(0),checkm=m.equalTo(0);
		if(checkn)
		{
			if(checkm)
				return new Number(0);
			else
				throw new Exception("Exception found : Cannot divide by zero\n");
		}
		else if(checkm)
		{
			if(checkn)
				return new Number(0);
			else
				throw new Exception("Exception found : Case of Infinity\n");
		}
		try
		{
			if(m.lessThan(n))
				return new Number(0);
			String rem;
			String div=n.retNum();
			String num=m.retNum();
			String quo="0";
			String q;
			int j=div.length()-1;
			quo+=Number.singleDiv(div,num.substring(0,j+1));
			rem=Number.sub(new Number(num.substring(0,j+1)),Number.mul(new Number(div),new Number(quo))).retNum();
			j++;
			while(j<num.length())
			{
				rem+=num.charAt(j);
				q=""+Number.singleDiv(div,rem);
				rem=Number.sub(new Number(rem),Number.mul(new Number(div),new Number(q))).retNum();
				quo+=q;
				j++;
			}
			n=new Number(quo);
			n.refresh();
			return n;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	// REMAINDER

	static Number rem(Number n,Number m)
	{
		try
		{
			return Number.sub(m,Number.mul(n,Number.div(n,m)));
		}
		catch(Exception e)
		{

		}
		return null;
	}

}