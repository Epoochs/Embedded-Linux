

class IpParse
{
	public static void main(String[] args) {
        String str = args[0];
        
        int beginIndex = 0;
        
        while(str.indexOf('.', beginIndex) != -1)
        {
            System.out.println(str.substring(beginIndex,str.indexOf('.', beginIndex)));
            beginIndex = str.indexOf('.', beginIndex) + 1;
        }
        if(str.indexOf('.', beginIndex) < str.length())
        {
            System.out.println(str.substring(beginIndex, str.length()));
        }
    }
}
