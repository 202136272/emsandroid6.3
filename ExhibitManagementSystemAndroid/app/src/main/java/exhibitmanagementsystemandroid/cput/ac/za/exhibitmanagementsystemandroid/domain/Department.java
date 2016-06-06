package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;

import java.io.Serializable;

/**
 * Created by Bonga on 4/2/2016.
 */
public class Department implements Serializable{
    private Long id;
    private String name;
    private  String location;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Department(Builder builder) {
        id = builder.id;
        name = builder.name;
        location = builder.location;

    }
    public static class Builder {
        //Equivalent to setters
        private Long id;
        private String name;
        private String location;

        public Builder id(Long id) {
            this.id = id; //compalsury
            return this;
        }
        public Builder name(String name) {
            this.name = name; //compalsury
            return this;
        }
        public Builder location(String location) {
            this.location = location;
            return this;
        }
        public Builder copy(Department department){
            this.id = department.getId();
            this.name = department.getName();
            this.location = department.getLocation();
            return this;
        }
        public Department build() {
            return new Department(this);
        }
    }
}
