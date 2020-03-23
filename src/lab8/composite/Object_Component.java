package lab8.composite;

import java.util.Iterator;

public abstract class Object_Component{
      abstract Iterator createIterator();
      public abstract void render();
      public abstract float volume();
}