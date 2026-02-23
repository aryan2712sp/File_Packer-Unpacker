import java.util.*;
import java.io.*;

class MarvellousPacker
{
    private String PackName;
    private String DirName;

    public MarvellousPacker(String A, String B)
    {
        this.PackName = A;
        this.DirName = B;
    }

    public void PackingActivity()
    {
        try
        {
            System.out.println("----------------------------------------------------------------");
            System.out.println("-------------------Marvellous Packer Unpacker-------------------");
            System.out.println("----------------------------------------------------------------");
            System.out.println("------------------------Packing Activity------------------------");
            System.out.println("----------------------------------------------------------------");

            int i = 0, j = 0, iRet = 0, iCountFile = 0;

            File fobj = new File(DirName);

            // Check the existence of Directory
            if((fobj.exists()) && (fobj.isDirectory()))
            {
                System.out.println(DirName + "is successfully opened");

                File Packobj = new File(PackName);

            Packobj.createNewFile();

            // Create a packed file
            boolean bRet = Packobj.createNewFile();

            if(bRet == false)
            {
                System.out.println("Unable to create pack file");
                return;
            }

            System.out.println("Packed file gets successfully created with name : "+PackName);

                // Retive all files from directory
                File Arr[] = fobj.listFiles();

                //Packed File Object
                FileOutputStream foobj = new FileOutputStream(Packobj);

                //Buffer for read and write activity
                byte Buffer[] = new byte[1024];

                String Header = null;

                // Directory Traversal
                for(i = 0; i < Arr.length; i++)
                {
                    Header = Arr[i].getName() + " " + Arr[i].length();
                    System.out.println(Header+ "Length of header is : "+Header.length());


                    //Loop to form 100 bytes header
                    for(j = Header.length(); j < 100; j++)
                    {
                        Header = Header + " ";
                    }
                    System.out.println(Header+ "Length of header is : "+Header.length());

                }

                //Write header into packed file
                foobj.write(Header.getBytes());

                FileOutputStream foobj = new FileOutputStream(Packobj);

                byte Buffer[] = new byte[1024];
                int iRet = 0;

                for(i = 0; i < Arr.length; i++)
                {
                    System.out.println("File name is : "+Arr[i].getName()+"; File size is : "+Arr[i].length());

                    // Open file from directory for reading
                    FileInputStream fiobj = new FileInputStream(Arr[i]);

                    // Write contents of file into packed file
                     while((iRet = fiobj.read(Buffer)) != -1)
                    {
                        foobj.write(Buffer,0,iRet);
                        System.out.println("File name Scanned : "+Arr[i].getName());
                        System.out.println("File size read is : "+iRet);
                    }

                    fiobj.close();
                    iCountFile++;

                System.out.println("Packing activity done");

                System.out.println("----------------------------------------------------------------");
                System.out.println("---------------------Statistical Report-------------------------");
                System.out.println("----------------------------------------------------------------");

                // To be add
                System.out.println("Total files packed :"+iCountFile);

                System.out.println("----------------------------------------------------------------");
                System.out.println("--------------Thank you for using our application---------------");
                System.out.println("----------------------------------------------------------------");
                }
                else
                {
                System.out.println("There is no such Directory");
                }
            }

        }// End of try
        catch(Exception eobj)
        {}

    }// End of PackingActivity Function
} // End of MarvellousPacker Class

class program467
{
    public static void main(String A[])
    {
        try
        {
            Scanner sobj = new Scanner(System.in);

            System.out.println("Enter the name of Directory that you want to pack : ");
            String DirName = sobj.nextLine();

            System.out.println("Enter the name of file that you want to create for packing : ");
            String PackName = sobj.nextLine();

            MarvellousPacker mobj = new MarvellousPacker(PackName, DirName);

            mobj.PackingActivity();

        }
        catch(Exception eobj)
        {}
    }// End of main
}// End of program467 class

