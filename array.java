public class array
{
	static int[] toArray(String s)
	{
		int arr[]=new int[s.length()];
		for(int i=0;i<s.length();i++)
			arr[i]=(int)s.charAt(i);
		return arr;
	}
}