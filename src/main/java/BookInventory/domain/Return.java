package BookInventory.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/04/25.
 */
@Entity
public class Return implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)//makes the code unique
    private String code;
    private Date dateReturned;
    private int quantity;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "return_id")
    private List<User> userList;

    private Return(){

    }

    public Return(Builder builder){
        this.id=builder.id;
        this.code=builder.code;
        this.quantity=builder.quantity;
        this.dateReturned=builder.dateReturned;
        this.userList =builder.userList;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<User> getUserList() {
        return userList;
    }

    public static class Builder {
        private Long id;
        private String code;
        private Date dateReturned;
        private int quantity;
        private List<User> userList;

        public Builder(String code) {
            this.code = code;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder quantity(int value) {
            this.quantity = value;
            return this;
        }

        public Builder dateReturned(Date value) {
            this.dateReturned = value;
            return this;
        }

        public Builder customerList(List<User> value) {
            this.userList = value;
            return this;
        }

        public Builder copy(Return value) {
            this.code = value.getCode();
            this.id = value.getId();
            this.quantity = value.getQuantity();
            this.dateReturned = value.getDateReturned();
            this.userList = value.getUserList();
            return this;
        }

        public Return build(){
            return new Return(this);
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
