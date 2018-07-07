import java.io.*;
import java.util.*;
import java.net.*;

public class Client_Arraylist{

  public static void main(String arg[]){

    try{
    Socket s = new Socket("localhost",1234);

    DataInputStream dis = new DataInputStream(s.getInputStream());
    DataOutputStream dos = new DataOutputStream(s.getOutputStream());

    Scanner sc = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int choice;

    while(true){

      System.out.println("1.add \n2.display\n3.delete\n4.exit\n\nenter your choice : ");
      choice = sc.nextInt();

      dos.writeByte(choice);

      switch(choice){

        case 1:
                System.out.println("Enter total number of data to be enter : ");

                int n = sc.nextInt();

                dos.writeInt(n);

                System.out.println("Enter data : \n\n");
                for(int i = 0; i < n ; i++){
                  String str = br.readLine();
                  dos.writeUTF(str);
                }
                System.out.println(dis.readUTF());
                break;

        case 2:
                int size = dis.readInt();
                System.out.println("---------------------");
                for(int i = 0;i < size ;i++)
                System.out.println(dis.readUTF());
                System.out.println("---------------------");
                break;

        case 3:
                  System.out.println("Enter postion of data to be deleted : ");
                  int index = sc.nextInt();
                  dos.writeInt(index-1);
                  System.out.println("------------------");
                  System.out.println(dis.readUTF());
                  System.out.println("------------------");
                  break;

        case 4:
                    s.close();
                    System.exit(0);

        default : System.out.println("invalid choice");
                  break;

      }
    }
  }
  catch(UnknownHostException e){
    System.out.println("UnknownHostException occured...");
  }

  catch(IOException e){
    System.out.println("IOException occured...");
  }
  }
}
