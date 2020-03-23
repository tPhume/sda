package lab8.composite;

import java.util.ArrayList;

import java.util.Iterator;

public class Object extends Object_Component{

      private ArrayList<Object_Component> list;

      public Object() {
            list = new ArrayList<Object_Component>();
      }
      
      @Override
      Iterator createIterator() {
            return list.iterator();
      }

      void add(Object_Component o) {
            list.add(o);
      }

      @Override
      public void render() {
            for(Object_Component o:list){
                o.render();
            }
      }

      @Override
      public float volume() {
            float total=0;
            
            for(Object_Component o:list){
                total+=o.volume();
            }

            return total;
      }
}
