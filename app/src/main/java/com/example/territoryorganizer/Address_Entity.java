package com.example.territoryorganizer;

/*
Creates the Address table entity in the local database
Includes all setters and getters
*/

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "address_table",
        foreignKeys = @ForeignKey(entity = Territory_Entity.class,
                parentColumns = "Territory_ID" , childColumns = "Territory_Assigned"))
public class Address_Entity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Address_id")
    private int mAddress_id;

    @ColumnInfo(name = "Street_Number")
    private String mStreetNumber;

    @ColumnInfo(name = "Street_Name")
    private String mStreetName;

    @ColumnInfo (name = "City")
    private String mCity;

    @ColumnInfo (name = "Zipcode")
    private String mZipcode;

    @ColumnInfo (name = "Apt_Num")
    private String mAptNum;

    @ColumnInfo (name = "Resdient")
    private String mResident;

    @ColumnInfo (name = "Notes")
    private String mNotes;

    @ColumnInfo (name = "Status")
    private String mStatus;

    @ColumnInfo (name = "Last_Visit")
    private String mLastVisit;

    @ColumnInfo (name = "Territory_Assigned")
    private int mTerritoryAssigned;

    public Address_Entity(
            int mAddress_id,
            String mStreetNumber,
            String mStreetName,
            String mCity,
            String mZipcode,
            String mAptNum,
            String mResident,
            String mNotes,
            String mStatus,
            String mLastVisit,
            int mTerritoryAssigned
    ) {
        this.mAddress_id = mAddress_id;
        this.mStreetNumber = mStreetNumber;
        this.mStreetName = mStreetName;
        this.mCity = mCity;
        this.mZipcode = mZipcode;
        this.mAptNum = mAptNum;
        this.mResident = mResident;
        this.mNotes = mNotes;
        this.mStatus = mStatus;
        this.mLastVisit = mLastVisit;
        this.mTerritoryAssigned = mTerritoryAssigned;
    }

    public int getAddress_id() { return this.mAddress_id; }
    public String getStreetNumber() { return this.mStreetNumber;}
    public String getStreetName() { return this.mStreetNumber;}
    public String getAptNum() { return this.mAptNum;}
    public String getResident() { return this.mResident; }
    public String getCity() { return this.mCity;}
    public String getZipcode() { return this.mZipcode;}
    public String getNotes() { return this.mNotes;}
    public String getStatus() { return this.mStatus;}
    public String getLastVisit() { return this.mLastVisit;}
    public int getTerritoryAssigned() { return this.mTerritoryAssigned; }


}
