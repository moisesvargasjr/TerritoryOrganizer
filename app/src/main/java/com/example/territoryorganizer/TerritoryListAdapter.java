package com.example.territoryorganizer;

/*RecyclerView adapter for the AssignedTerritories activity*/

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TerritoryListAdapter extends RecyclerView.Adapter<TerritoryListAdapter.TerritoryViewHolder> {

    class TerritoryViewHolder extends RecyclerView.ViewHolder {
        public TextView territoryIdItemView;
        public TextView territoryCongItemView;
        public TextView territoryPreacherItemView;
        public TextView territoryServiceAreaItemView;

        public TerritoryViewHolder(View itemView) {
            super(itemView);
            territoryIdItemView = itemView.findViewById(R.id.territoryId);
            territoryCongItemView = itemView.findViewById(R.id.territoryCongregation);
            territoryPreacherItemView = itemView.findViewById(R.id.territoryPreacher);
            territoryServiceAreaItemView = itemView.findViewById(R.id.territoryServiceArea);
        }
    }

    private LayoutInflater mInflator;
    private List<Territory_Entity> mTerritories;

    public TerritoryListAdapter(Context context) {
        mInflator = LayoutInflater.from(context);
    }

    @Override
    public TerritoryListAdapter.TerritoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mTerritoryView = mInflator.inflate(R.layout.activity_assigned_territories_item,viewGroup,false);
        return new TerritoryViewHolder(mTerritoryView);
    }

    @Override
    public void onBindViewHolder(TerritoryViewHolder holder, int position) {
        if (mTerritories != null) {
            Territory_Entity current = mTerritories.get(position);

            int mCurrentId = current.getTerritory_id();
            String mCurrentCong = current.getCong_id();
            String mCurrentPreacher = current.getPreacher_id();
            String mCurrentServiceArea = current.getServiceArea();

            holder.territoryIdItemView.setText(Integer.toString(mCurrentId));
            holder.territoryCongItemView.setText(mCurrentCong);
            holder.territoryPreacherItemView.setText(mCurrentPreacher);
            holder.territoryServiceAreaItemView.setText(mCurrentServiceArea);
        } else {
            holder.territoryIdItemView.setText(0);
            holder.territoryCongItemView.setText("no data");
            holder.territoryPreacherItemView.setText("no data");
            holder.territoryServiceAreaItemView.setText("no data");
        }
    }

    void setTerritories(List<Territory_Entity> territories) {
        mTerritories = territories;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mTerritories != null)
            return mTerritories.size();
        else return 0;
    }
}
