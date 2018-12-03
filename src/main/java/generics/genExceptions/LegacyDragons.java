package generics.genExceptions;

import java.util.ArrayList;
import java.util.List;

class Dragon {}
class Unicorn { }
public class LegacyDragons {
   public static void main(String[] args) {
      List unicorns = new ArrayList();    // COMPILER WARNING
      unicorns.add(new Unicorn());
      printDragons(unicorns);
   }
   private static void printDragons(List<Dragon> dragons) {
      for (Dragon dragon: dragons) {   // ClassCastException
         System.out.println(dragon);
    } } }
