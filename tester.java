class tester
{
	public static void main(String arg[])
	{
		System.out.println(binary.toBinary(256));
		System.out.println(binary.fromBinary("100000"));
		System.out.println(binary.xor("101110110","10101"));
		System.out.println(binary.fromBinary(binary.add(binary.toBinary(12078),binary.toBinary(22))));
	}
}