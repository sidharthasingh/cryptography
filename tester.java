class tester
{
	public static void main(String arg[])
	{
		Number n=new Number(0);
		try
		{
			System.out.println(n.sub(new Number("10000000000000000000000000000000000000000")).retNum());
		}
		catch(Exception e)
		{

		}
	}
}