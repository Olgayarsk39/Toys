package ToysPrize;
public class Toy{
    int id;
    String name;
    int count;
    double weight;
    public Toy (int id, String name, int count, double weight) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.weight = weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public int getCount() {
        return count;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Игрушка - [id = " + id + ", name = " + name + ", count = " + count +", weight = " + weight + "]" +"\n";
    }
}