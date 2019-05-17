package com.example.territoryorganizer;

/*Before the SQL implementation, I was using objects to create and instantiate
* the address entity. This is no longer used*/

public class Listing {
    private String streetNumber,streetName,city,state,zipcode,aptNumber,ownerName,notes,status,lastVisited;

    Listing(String streetNumber, String streetName, String city, String state, String zipcode, String aptNumber, String ownerName, String notes, String status, String lastVisited) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.aptNumber = aptNumber;
        this.ownerName= ownerName;
        this.notes = notes;
        this.status = status;
        this.lastVisited = lastVisited;
    }

    public String getStreetNumber() {
        return this.streetNumber;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public String getAptNumber() {
        return this.aptNumber;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public String getNotes() {
        return this.notes;
    }

    public String getStatus() {
        return this.status;
    }

    public String getLastVisited() {return this.lastVisited; }
}
