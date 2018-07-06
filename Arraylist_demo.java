import java.util.*;

public class Arraylist_demo{

  public static void main(String a[]){
    ArrayList <String> str_array = new ArrayList <String>(5);

      Scanner s = new Scanner(System.in);

      int choice , n,index;

      String c;

      while(true){

        System.out.print("1.add \n 2.display \n 3.remove \n 4.exit\n\nEnter choice : ");

        choice = s.nextInt();

        switch (choice) {

          case 1:
                  System.out.print("Enter total number of data to be enter : ");
                  n = s.nextInt();
                  c = s.next();
                  System.out.println("Enter data : ");
                  for (int i = 0;i < n ;i++ ) {
                    str_array.add(s.nextLine());
                  }
                  break;

          case 2:
                  System.out.println("1.for loop \n2.enhanced for loop\n3.iterator\n\nEnter choice : ");
                  choice = s.nextInt();
                  switch(choice){
                    case 1:
                            for(int i = 0; i < str_array.size();i++)
                            System.out.println(str_array.get(i));
                            break;

                    case 2:
                            for(String str : str_array)
                            System.out.println(str);
                            break;

                    case 3:
                            Iterator it = str_array.iterator();
                            while(it.hasNext())
                            System.out.println(it.next());
                            break;
                  }

                  break;

          case 3:
                  System.out.print("Enter total number of data to be enter : ");
                  n = s.nextInt();
                  System.out.print("\nEnter the position of element to be removed : ");
                  for(int i = 0;i<n;i++){
                    index = s.nextInt() - 1;
                    str_array.remove(index);
                  }
                    break;

          case 4:
                  System.exit(0);
                  break;

          default :
                    System.out.println("Invalid choice");
                    break;

        }
      }
  }
}
