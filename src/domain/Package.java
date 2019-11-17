package domain;

/**
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */

public class Package {
    private String name;
    private String material;
    private int capacity;
    
    public Package(){
       this.setName("");
       this.setMaterial("");
       this.setCapacity(0);
    }
    
    public Package(String name, String material, int capacity){
        this.setName(name);
        this.setMaterial(material);
        this.setCapacity(capacity);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }
    

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return  ""+name;
    }
    
}


