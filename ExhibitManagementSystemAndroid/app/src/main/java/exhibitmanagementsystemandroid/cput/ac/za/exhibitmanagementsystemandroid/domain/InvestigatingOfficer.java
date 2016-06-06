package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;

import java.io.Serializable;

/**
 * Created by Leonard Dukashe on 2016/03/28.
 */
public class InvestigatingOfficer implements Serializable {
    private Long id;
    private String persalNumber;
    private String name;
    private String rank;
    private String station;


    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public String getStation() {
        return station;
    }

    public String getPersalNumber() {
        return persalNumber;
    }

    public Long getId() {
        return id;
    }

    public InvestigatingOfficer(Builder builder) {
        id = builder.id;
        name = builder.name;
        rank = builder.rank;
        station = builder.station;
        persalNumber = builder.persalNumber;

    }


    public static class Builder {
        //Equivalent to setters
        private Long id;
        private String name;
        private String rank;
        private String station;
        private String persalNumber;


        public Builder id(Long id) {
            this.id= id; //compalsury
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder rank(String rank) {
            this.rank = rank;
            return this;
        }

        public Builder station(String station) {
            this.station = station;
            return this;
        }


        public Builder persalNumber(String persalNumber) {
            this.persalNumber = persalNumber;
            return this;
        }
        public Builder copy(InvestigatingOfficer investigatingOfficer){
            this.id = investigatingOfficer.getId();
            this.name = investigatingOfficer.getName();
            this.rank = investigatingOfficer.getRank();
            this.station = investigatingOfficer.getStation();
            this.persalNumber = investigatingOfficer.getPersalNumber();
            return this;
        }
        public InvestigatingOfficer build() {
            return new InvestigatingOfficer(this);
        }
    }

}

