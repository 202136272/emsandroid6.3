package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;

import java.io.Serializable;
/**
 * Created by Bonga on 4/1/2016.
 */
public class QuestionedDoc implements Serializable{
    private Long id;
    private String reference;
    private String name;
    private  String date;

    public Long getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public QuestionedDoc(Builder builder) {
        id = builder.id;
        name = builder.name;
        reference = builder.reference;
        date = builder.date;
        //date = builder.date;
    }

    public static class Builder {
        //Equivalent to setters
        private Long id;
        private String name;
        private String reference;
        private String date;

        public Builder id(Long id) {
            this.id= id; //compalsury
            return this;
        }

        public Builder name(String name) {
            this.name = name; //compalsury
            return this;
        }

        public Builder reference(String reference) {
            this.reference = reference;
            return this;
        }
        public Builder date(String date) {
            this.date = date;
            return this;
        }

        public Builder copy(QuestionedDoc questionedDoc){
            this.id = questionedDoc.getId();
            this.name = questionedDoc.getName();
            this.reference = questionedDoc.getReference();
            this.date = questionedDoc.getDate();

            return this;
        }
        public QuestionedDoc build() {
            return new QuestionedDoc(this);
        }
    }

}
