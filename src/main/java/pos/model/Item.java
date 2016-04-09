package pos.model;

import com.google.common.base.Objects;

public class Item {

    private long id;
    private ItemType type;
    private String name;
    private Price price;

    public static class ItemBuilder {

        private long id;
        private final ItemType type;
        private final Price price;
        private String name;

        public ItemBuilder(ItemType type, Price price) {
            this.type = type;
            this.price = price;
        }

        public ItemBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ItemBuilder id(long id) {
            this.id = id;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }

    private Item(ItemBuilder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.name = builder.name;
        this.price = builder.price;
    }

    public long getId() {
        return id;
    }

    public ItemType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public String getItemName() {
        if (name != null && name.length() > 0)
            return this.type.getName() + " " + name;
        return this.type.getName();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;

        return Objects.equal(this.id, other.id) && Objects.equal(this.name, other.name)
                && Objects.equal(this.price, other.price) && Objects.equal(this.type, other.type);
    }

}