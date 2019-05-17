package com.example.territoryorganizer;

/*
Creates the Territory table entity in the local database
Includes all setters and getters
*/

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "territory_table")
public class Territory_Entity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Territory_ID")
    private int mTerritory_id;

    @NonNull
    @ColumnInfo(name = "Cong_ID")
    private String mCong_id;

    @ColumnInfo(name = "Service_Area")
    private String mServiceArea;

    @ColumnInfo(name = "Preacher_ID")
    private String mPreacher_id;

    public Territory_Entity(int mTerritory_id, String mCong_id, String mServiceArea, String mPreacher_id) {
        this.mTerritory_id = mTerritory_id;
        this.mCong_id = mCong_id;
        this.mServiceArea = mServiceArea;
        this.mPreacher_id = mPreacher_id;
    }

    public int getTerritory_id() {return this.mTerritory_id;}
    public String getCong_id() {return this.mCong_id;}
    public String getServiceArea() {return this.mServiceArea;}
    public String getPreacher_id() {return this.mPreacher_id;}


}
