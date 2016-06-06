package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;

import java.io.Serializable;

/**
 * Created by Bonga on 3/30/2016.
 */
public class Station implements Serializable{
    private Long id;
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Long getId() {
        return id;
    }

    public Station(Builder builder) {
        id = builder.id;
        name = builder.name;
        address = builder.address;
    }

    public static class Builder {

        //Equivalent to setters
        private Long id;
        private String name;
        private String address;

        public Builder id(Long id) {
            this.id= id; //compalsury
            return this;
        }
        public Builder name(String name) {
            this.name = name; //compalsury
            return this;
        }
        public Builder address(String address) {
            this.address = address;
            return this;
        }
        public Builder copy(Station station) {
            this.id = station.getId();
            this.name = station.getName();
            this.address = station.getAddress();
            return this;
        }

        public Station build() {
            return new Station(this);
        }
    }
}







