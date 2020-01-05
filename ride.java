/*ID: 02charl1
TASK: ride
LANG: JAVA
*/

//         PROBLEM ID: Your Ride Is Here

import java.io.*;
public class ride
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output 
        RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new 
        FileWriter("ride.out")));
        
        //Declares two strings--reads and assigns them from the input file
        String cometName=in.readLine();
        String groupName=in.readLine();
        
        //Declares and initializes two integer variables for storing calculations
        int cometNum = 1, groupNum= 1;
        
        //Declares and initializes two constant variables
        final int ASCII_OFFSET_UPPERCASE = 64, MOD_VALUE = 47;
        
        //Translates letters to ASCII code
        for (int k = 0; k<cometName.length(); k++)
        {
            cometNum *= cometName.charAt(k) - ASCII_OFFSET_UPPERCASE;
            cometNum %= MOD_VALUE;
        }
        for (int k = 0; k<groupName.length(); k++)
        {
            groupNum *= groupName.charAt(k) - ASCII_OFFSET_UPPERCASE;
            groupNum %= MOD_VALUE;
        }
        
        //Checks if group and comet numbers are equal
        if (groupNum == cometNum)
        out.println("GO");
        else
        out.print("STAY\n");
        
        //Ensures program ends properly
        out.close();
        System.exit(0);
    }
}
