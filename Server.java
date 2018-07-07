import java.io.*;
import java.net.*;

public class Server{
  public static void main(String a[]){
    try{
      ServerSocket ss = new ServerSocket(1234);
      Socket s = ss.accept();

      DataInputStream dis = new DataInputStream(s.getInputStream());

      String str = "";
      while( !str.equals("over")){
        str = (String)dis.readUTF();
      System.out.println(str);
    }

      ss.close();
      s.close();
    }
    catch(UnknownHostException e){
      System.out.println("Exception occur at socket ...");
    }
    catch(IOException e){
      System.out.println("Exception occur at reading at socket....");
    }
  }
}
