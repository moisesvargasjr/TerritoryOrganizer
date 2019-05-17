package com.example.territoryorganizer;

/*Before the SQL implementation, I was using objects to create and instantiate
 * the Territory entity. This is no longer used*/

import java.util.ArrayList;
import java.util.List;

public class Territory {

    int territoryId;
    String congregationId;
    String preacherId;
    String serviceArea;
    ArrayList<Listing> listingList = new ArrayList<Listing>();


    Territory(int id, String cong, String area) {
        territoryId = id;
        congregationId = cong;
        serviceArea = area;
        preacherId = "undefined";
    }

    public int getTerritoryId() {
        return territoryId;
    }

    public String getCongregationId() {
        return congregationId;
    }

    public String getPreacherId() {
        return preacherId;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void insertFakeListings() {
        Listing listing1 = new Listing("10267","Black Mountain Rd","San Diego","CA","92126","L6","","","","05/08/19");
        Listing listing2 = new Listing("10267","Black Mountain Rd","San Diego","CA","92126","L7","Lilliana Rodriguez","","","05/07/19");
        Listing listing3 = new Listing("10293","Black Mountain Rd","San Diego","CA","92126","M7","Emlyn Cartajel","","","05/01/19");
        Listing listing4 = new Listing("10771","Black Mountain Rd","San Diego","CA","92126","2","Antonto Ferrer","","","05/04/19");
        Listing listing5 = new Listing("10771","Black Mountain Rd","San Diego","CA","92126","5","Alfonso Rodriguez","","","05/02/19");
        listingList.add(listing1);
        listingList.add(listing2);
        listingList.add(listing3);
        listingList.add(listing4);
        listingList.add(listing5);
    }
}
