package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;

import java.io.Serializable;

/**
 * Created by Bonga on 4/1/2016.
 */
public class PreciousMetals implements Serializable{
    private Long id;
    private String density;
    private String mass;
    private String type;
    private  String meltingPoint;

    public String getMass() {
        return mass;
    }

    public String getType() {
        return type;
    }

    public String getDensity() {
        return density;
    }

    public String getMeltingPoint() {
        return meltingPoint;
    }

    public Long getId() {
        return id;
    }

    public PreciousMetals(Builder builder) {
        id = builder.id;
        mass = builder.mass;
        type = builder.type;
        density = builder.density;
        meltingPoint = builder.meltingPoint;
    }


    public static class Builder {
        //Equivalent to setters
        private Long id;
        private String mass;
        private String type;
        private String density;
        private String meltingPoint;

        public Builder id(Long id) {
            this.id = id; //compalsury
            return this;
        }

        public Builder mass(String mass) {
            this.mass = mass; //compalsury
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }


        public Builder density(String density) {
            this.density = density;
            return this;
        }

        public Builder meltingPoint(String meltingPoint) {
            this.meltingPoint = meltingPoint;
            return this;
        }

        public Builder copy(PreciousMetals preciousMetals){
            this.id = preciousMetals.getId();
            this.mass = preciousMetals.getMass();
            this.type = preciousMetals.getType();
            this.density = preciousMetals.getDensity();
            this.meltingPoint = preciousMetals.getMeltingPoint();
            return this;
        }
        public PreciousMetals build() {
            return new PreciousMetals(this);
        }
    }
}
