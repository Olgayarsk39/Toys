package ToysPrize;

import java.util.ArrayList;
import java.util.List;
public class ToysStore {
    public static List<Toy> toys;
    public static  List<Toy> allToys = new ArrayList<Toy>();
    public static List<Toy> prizeToys = new ArrayList<Toy>();


    public ToysStore(List<Toy> toys) {
        this.toys = toys;
    }

    @Override
    public String toString() {
        return "toys=" + toys ;
    }

    public Toy changeToyWeight() {
        SelectToys select = new SelectToys();
        Toy toy = select.selectOnWeight(toys);
        return  toy;
    }
}
