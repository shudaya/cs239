import java.io.FileInputStream;

import miniX10.syntaxtree.*;
import miniX10.visitor.*;

public class Main {
   public static void main(String [] args) {
      try {
         // new MiniX10Parser(System.in).Goal();
    	 //File root = new MiniX10Parser(System.in).File();
    	 FileInputStream f = null;
    	 try{
    		 f = new FileInputStream("C:\\Users\\William\\workspace\\cs239\\src\\inputData\\example2.x10");
    	 }
    	 catch(Exception e){ System.out.println("File I/O exception");}
    	 File root = new MiniX10Parser(f).File(); 
    	 (new MiniX10Formatter()).visit(root);
         (new TreeDumper()).visit(root);
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
}

