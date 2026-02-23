import java.util.*;
import java.io.*;

class program439
{
    public static void main(String A[]) 
    {
        try
        {
            Scanner sobj = new Scanner(System.in);

            System.out.println("Enter the name of file that you want to open : ");
            String Fname = sobj.nextLine();

            File fobj = new File(Fname);

        if(fobj.exists())
        {
            FileInputStream fiobj = new FileInputStream(fobj);
            
            byte Arr[] = new byte[10];

            int iRet = fiobj.read(Arr);
            String Str = new String(Arr);

            System.out.println("Data from file is : "+Str);
            System.out.println("Return value of read is : "+iRet);
        }
        else
        {
            System.out.println("File does not exists in current directory.");
            return;
        }
        fobj.createNewFile();
        }
        catch(IOException iobj)
        {}
        catch(Exception eobj)
        {}
    }
}
//ERROR SOLVED