package pos.model.application;

public class ItemType {

    private String name;

    public ItemType(String name) {
        if (name == null)
            throw new RuntimeException("ItemType name cannot be null.");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        if (name == null)
            return false;

        ItemType other = (ItemType) obj;
        return name.equals(other.name);
    }
}