import java.io.*;
import java.util.*;
import java.net.*;
//import Arraylist_demo2.*;

public class Server_Arraylist{

  public static void main(String arg[]){

    try{
      Arraylist arr = new Arraylist();

    ServerSocket ss = new ServerSocket(1234);
    Socket skt = ss.accept();

    Scanner sc = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    DataInputStream dis = new DataInputStream(skt.getInputStream());
    DataOutputStream dos = new DataOutputStream(skt.getOutputStream());

    int choice,index;
    while(true){

      choice = dis.readByte();

      switch(choice){

        case 1:
                int n = dis.readInt();

                for(int i = 0; i < n ; i++)
                arr.insert(dis.readUTF());

                dos.writeUTF("\n---data added Successfully---\n");
                break;

        case 2:
                  dos.writeInt(arr.sizeof());
                  for(int i = 0 ; i < arr.sizeof() ; i++)
                  dos.writeUTF(arr.display(i));
                  break;

        case 3:
                    index = dis.readInt();
                    arr.delete(index);
                    dos.writeUTF("data deleted");
                    break;

        case 4:
                dos.flush();
                ss.close();
                skt.close();
                System.exit(0);

        default : break;
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
