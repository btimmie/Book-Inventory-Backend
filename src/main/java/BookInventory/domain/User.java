package BookInventory.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/25.
 */
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)//makes the code unique
    private String code;
    private String firstName;
    private String lastName;
    private String password;

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinColumn(name = "consumtion_id")
//    private List<Consumtion>consumtionList;

    private User(){

    }

    public User(Builder builder){
        this.id=builder.id;
        this.code=builder.code;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.password=builder.password;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }


    public static class Builder{
        private Long id;
        private String code;
        private String firstName;
        private String lastName;
        private String password;

        public Builder(String code){
            this.code=code;
        }

        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder firstName(String value){
            this.firstName=value;
            return this;
        }

        public Builder lastName(String value){
            this.lastName=value;
            return this;
        }

        public Builder password(String value){
            this.password=value;
            return this;
        }



        public Builder copy(User value){
            this.code = value.getCode();
            this.id = value.getId();
            this.firstName = value.getFirstName();
            this.lastName = value.getLastName();
            this.password = value.getPassword();
            return this;
        }

        public User build(){
            return new User(this);
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
                    "code='" + code + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}
