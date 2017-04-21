function dem()
{
	if(Math.random()<0.5)
		return 0;
	return 1;
}
for(i=0;i<1000000;i++)
{
	str="";
	for(j=0;j<100;j++)
		str+=dem();
	console.log(str);
}
