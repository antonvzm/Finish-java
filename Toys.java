public class Toys {
    String id;
    String name;
    String chance;

    public Toys(String id, String name, String chance){
        this.id = id;
        this.name = name;
        this.chance = chance;
    
}
public String toString() {
    return "ID: " + id + " Имя: " + name + " Шанс: " + chance;
}

public String getId() {
    return id;
}
public void editChance(String chance) {
    this.chance = chance;
}
public String getChance() {
    return chance;
}

}