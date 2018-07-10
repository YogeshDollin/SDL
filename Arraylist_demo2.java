import java.util.*;

public class Arraylist_demo2{
  ArrayList <String> str_array = new ArrayList <String>(10);

  void insert(String s){

    str_array.add(s);
  }

  int sizeof(){
    return str_array.size();
  }

  String display(int index){
    return str_array.get(index);
  }

  void delete(int index){
    str_array.remove(index);
  }
}
