package BookInventory.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/25.
 */
@Entity
public class InventoryItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)//makes the code unique
    private String code;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;


    private InventoryItem(){
    }

    public InventoryItem(Builder builder){
        this.id=builder.id;
        this.code=builder.code;
        this.name=builder.name;
        this.description=builder.description;
        this.supplier=builder.supplier;

    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public static class Builder{
        private Long id;
        private String code;
        private String name;
        private String description;
        private Supplier supplier;

        public Builder(String code){
            this.code=code;
        }

        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder name(String value){
            this.name=value;
            return this;
        }

        public Builder description(String value){
            this.description=value;
            return this;
        }

        public Builder supplier(Supplier value){
            this.supplier=value;
            return this;
        }

        public Builder copy(InventoryItem value){
            this.id = value.id;
            this.code = value.getCode();
            this.name = value.getName();
            this.description = value.getDescription();
            this.supplier=value.getSupplier();
            return this;
        }

        public InventoryItem build(){
            return new InventoryItem(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Builder builder = (Builder) o;

            if (id != null ? !id.equals(builder.id) : builder.id != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "id=" + id +
                    ", code='" + code + '\'' +
                    '}';
        }
    }
}
