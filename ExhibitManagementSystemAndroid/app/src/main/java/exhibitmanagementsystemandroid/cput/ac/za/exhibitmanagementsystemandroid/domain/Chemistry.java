package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;

import java.io.Serializable;


/**
 * Created by Bonga on 4/1/2016.
 */

public class Chemistry implements Serializable{

    private  Long id;
    private  String mass;
    private  String amount;
    private String type;
    private String effect;

    public Long getId() {
        return id;
    }

    public String getMass() {
        return mass;
    }

    public String getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getEffect() {
        return effect;
    }

    public Chemistry(Builder builder) {
        id = builder.id;
        mass = builder.mass;
        amount= builder.amount;
        type = builder.type;
        effect = builder.effect;
    }


    public static class Builder {
        private  Long id;
        private  String mass;
        private  String amount;
        private String type;
        private String effect ;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder mass(String mass) {
            this.mass = mass; //compulsary
            return this;
        }
        public Builder amount(String amount) {
            this.amount= amount;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }
        public Builder effect(String effect) {
            this.effect= effect;
            return this;
        }

        public Builder copy(Chemistry chemistry){
            this.id = chemistry.getId();
            this.mass= chemistry.getMass();
            this.amount= chemistry.getAmount();
            this.type= chemistry.getType();
            this.effect = chemistry.getEffect();
            return this;
        }
        public Chemistry build() {
            return new Chemistry( this);
        }
    }

}
