package lab8.menu;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenuIterator implements Iterator {
    ArrayList items;
    int position = 0;
    public PancakeHouseMenuIterator(ArrayList menu){
        items = menu;
    }

    public Object next(){
        Object next = items.get(position);
        position = position + 1;
        return next;
    }
    public boolean hasNext(){
        int size = items.size();
        for(int i=0;i<size-1;i++)
            if(items.get(position) == items.get(i)){
                return true;
            }
        return false;
    }

}
