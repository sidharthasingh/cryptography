public class binary
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

	static String inverse(String s)
	{
		String str="";
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='0')
				str+='1';
			else
				str+='0';
		}
		return str;
	}

	static String equalizeLength(String a,int x)
	{
		int n=x-a.length();
		String str="";
		for(int i=0;i<n;i++)
			str+='0';
		return str+a;
	}

	static String xor(String a,String b)
	{
		String str="";
		int la=a.length(),lb=b.length();
		if(la<lb)
			a=binary.equalizeLength(a,b.length());
		else if(lb<la)
			b=equalizeLength(b,a.length());
		for(int i=0;i<a.length();i++)
		{
			if(a.charAt(i)==b.charAt(i))
				str+='0';
			else
				str+='1';
		}
		return str;
	}

	static int totalOnes(char x,char y,char c)
	{
		int count=0;
		if(x=='1')
			count++;
		if(y=='1')
			count++;
		if(c=='1')
			count++;
		return count;
	}

	static String add(String a,String b)
	{
		int la=a.length(),lb=b.length();
		char x,y,c='0';
		if(la<lb)
			a=binary.equalizeLength(a,b.length());
		else if(lb<la)
			b=equalizeLength(b,a.length());
		String str="";
		for(int i=a.length()-1;i>=0;i--)
		{
			x=a.charAt(i);
			y=b.charAt(i);
			int n=binary.totalOnes(x,y,c);
			switch(n)
			{
				case 0:str='0'+str;
					   c='0';
					   break;
				case 1:str='1'+str;
					   c='0';
					   break;
				case 2:str='0'+str;
					   c='1';
					   break;
				case 3:str='1'+str;
					   c='1';
					   break;
			}
		}
		if(c=='1')
			str='1'+str;
		return str;
	}

	static String rightShift(String s)
	{
		return '0'+s.substring(0,s.length()-1);
	}

	static boolean isBinary(String s)
	{
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)!='0' && s.charAt(i)!='1')
				return false;
		return true;
	}

	static String equalizeLength(String s)
	{
		int l=s.length();
		String str="";		
		if(((Math.log(l)/Math.log(2))-(float)((int)(Math.log(l)/Math.log(2))))==0)
			return s;
		l=1+(int)(Math.log(l)/Math.log(2));
		if(l<3)
			l=3;
		l=(int)Math.pow(2,l);
		for(int i=0;i<l-s.length();i++)
			str+='0';
		return str+s;
	}

}