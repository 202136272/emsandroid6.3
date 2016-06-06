package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;


import java.io.Serializable;
/**
 * Created by Bonga on 4/1/2016.
 */

public class Biology implements Serializable {
   private Long id;
    private String reference;
    private String name;
    private String type;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReference() {
        return reference;
    }

    public String getType() {
        return type;
    }

    public Biology(Builder builder) {

        id = builder.id;
        name = builder.name;
        reference = builder.reference;
        type = builder.type;

    }


    public static class Builder {

        //Equivalent to setters
        private String name;
        private String reference;
        private String type;
        public Long id;

        public Builder id(Long id) {
            this.id = id; //compalsury
            return  this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder reference(String reference) {
            this.reference = reference;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder copy(Biology biology){
            this.name = biology.getName();
            this.reference = biology.getReference();
            this.type = biology.getType();

            return this;
        }
        public Biology build() {
            return new Biology(this);
        }
    }

}
