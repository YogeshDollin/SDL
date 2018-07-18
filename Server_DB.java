import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;

public class Server_DB{

  public static void main(String arg[]){

    try{

      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL = false","user","1pass23");
      PreparedStatement pstmt;

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
                pstmt = con.prepareStatement("insert into person values(?,?)");
                int n = dis.readInt();

                for(int i = 0; i < n ; i++){
                    pstmt.setString(1,dis.readUTF());
                    pstmt.setInt(2,dis.readInt());
                    pstmt.executeUpdate();
                }

                dos.writeUTF("\n---data added Successfully---\n");
                break;

        case 2:
                  pstmt = con.prepareStatement("select * from person");
                  ResultSet rs = pstmt.executeQuery();
                  while(rs.next()){
                    dos.writeUTF(rs.getString(1));
                    dos.writeInt(rs.getInt(2));
                    if(rs.isLast())
                      dos.writeUTF("over");
                  }
                  break;

        case 3:
                    pstmt = con.prepareStatement("delete from person where roll = ?");
                    pstmt.setInt(1,dis.readInt());
                    pstmt.executeUpdate();
                    dos.writeUTF("---data deleted Successfully---");
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

    catch(Exception e){
      System.out.println("Exception occured...");
    }
  }
}
