import java.net.*;
import java.io.*;

public class Client{
  public static void main(String a[]){
    try{
      Socket s = new Socket("localhost",1234);

      DataOutputStream dos = new DataOutputStream(s.getOutputStream());

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      System.out.println("Enter message.....");
      String str = "";
      while(!str.equals("over")){
        str = br.readLine();
        dos.writeUTF(str);
      }
    dos.flush();
    s.close();
    }
    catch(UnknownHostException e){
      System.out.println("error in socket creating...");
    }

    catch(IOException e){
      System.out.println("error at getOutputStream...");
    }
  }
}
