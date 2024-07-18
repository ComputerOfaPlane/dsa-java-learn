import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class LearnIterator {

    public static void main(String[] args) {
        
        List<Integer> l = new ArrayList<>();

        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);

        Iterator<Integer> it = l.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}