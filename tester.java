class tester
{
	public static void main(String arg[])
	{
		System.out.println(binary.toBinary(256));
		System.out.println(binary.fromBinary("100000"));
		System.out.println(binary.xor("101110110","10101"));
		System.out.println(binary.fromBinary(binary.add(binary.toBinary(12078),binary.toBinary(22))));
		System.out.println(binary.rightShift("1011"));
		System.out.println(binary.isBinary("10101010101010a100010101010101"));
		System.out.println(binary.equalizeLength("101101101"));
	}
}