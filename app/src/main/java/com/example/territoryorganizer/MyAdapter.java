package com.example.territoryorganizer;

/*This is a temporary adapter for the CurrentTerritoryBeta RecyclerView*/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[][] mDataset;
    private Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public final View mView;
        public final TextView mStreetNumberView;
        public final TextView mStreetNameView;
        public final TextView mAptNumberView;
        public final Spinner mAddressResultView;
        public final ImageButton mNotesView;
        public final TextView mDateVisitedView;

        public MyViewHolder(View view) {
            super(view);
            mView = view;
            mStreetNumberView = (TextView) view.findViewById(R.id.streetNumber);
            mStreetNameView = (TextView) view.findViewById(R.id.streetName);
            mAptNumberView = (TextView) view.findViewById(R.id.aptNumber);
            mAddressResultView = (Spinner) view.findViewById(R.id.addressResultSpinner);
            mNotesView = (ImageButton) view.findViewById(R.id.notes);
            mDateVisitedView = (TextView) view.findViewById(R.id.lastVisited);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[][] myDataset, Context context) {

        mDataset = myDataset;
        mContext = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_address, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        String[][] current = mDataset;

        holder.mStreetNumberView.setText(current[position][0]);
        holder.mStreetNameView.setText(current[position][1]);
        holder.mAptNumberView.setText(current[position][2]);
        holder.mDateVisitedView.setText(current[position][3]);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(mContext,R.array.address_statuses,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.mAddressResultView.setAdapter(adapter);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}

