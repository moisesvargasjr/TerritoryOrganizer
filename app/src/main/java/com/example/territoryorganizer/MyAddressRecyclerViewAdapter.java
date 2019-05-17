package com.example.territoryorganizer;

/*This is the adapter for the AddressList fragment that was not implemented in the
* final demo. This will be used later on when the fragment is implemented*/

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

//import com.example.territoryorganizer.AddressFragment.OnListFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;

public class MyAddressRecyclerViewAdapter extends RecyclerView.Adapter<MyAddressRecyclerViewAdapter.AddressViewHolder> {

    public class AddressViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mStreetNumberView;
        public final TextView mStreetNameView;
        public final TextView mAptNumberView;
        //        public final Spinner mAddressResultView;
        public final ImageButton mNotesView;
        public final TextView mDateVisitedView;

        public AddressViewHolder(View view) {
            super(view);
            mView = view;
            mStreetNumberView = (TextView) view.findViewById(R.id.streetNumber);
            mStreetNameView = (TextView) view.findViewById(R.id.streetName);
            mAptNumberView = (TextView) view.findViewById(R.id.aptNumber);
//            mAddressResultView = (Spinner) view.findViewById(R.id.addressResultSpinner);
            mNotesView = (ImageButton) view.findViewById(R.id.notes);
            mDateVisitedView = (TextView) view.findViewById(R.id.lastVisited);
        }
    }

    private LayoutInflater mInflator;
    private List<Address_Entity> mAddresses;

    public MyAddressRecyclerViewAdapter(Context context) {
        mInflator = LayoutInflater.from(context);
    }

    @Override
    public MyAddressRecyclerViewAdapter.AddressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflator
                .inflate(R.layout.fragment_address, parent, false);
        return new AddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AddressViewHolder holder, int position) {
        if (mAddresses !=null) {
            Address_Entity current = mAddresses.get(position);

            holder.mStreetNumberView.setText(current.getStreetNumber());
            holder.mStreetNameView.setText(current.getStreetName());
            holder.mAptNumberView.setText(current.getAptNum());
            holder.mDateVisitedView.setText(current.getLastVisit());
        }

        else {
            holder.mStreetNumberView.setText("no data");
            holder.mStreetNameView.setText("no data");
            holder.mAptNumberView.setText("no data");
            holder.mDateVisitedView.setText("no data");
        }
    }

    void setmAddresses(List<Address_Entity> addresses) {
        mAddresses = addresses;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mAddresses !=null) {
            return mAddresses.size();
        }
        else return 0;
    }

//    private ArrayList<Listing> mAddresses;
//    private final OnListFragmentInteractionListener mListener;
//    private Context mContext;
//
//
//    public MyAddressRecyclerViewAdapter(ArrayList<Listing> items, OnListFragmentInteractionListener listener, Context context) {
//        mAddresses = items;
//        mListener = listener;
//        mContext = context;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.fragment_address, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(final ViewHolder holder, int position) {
//
//     //   holder.mItem = mAddresses.get(position);
//        holder.mStreetNumberView.setText(mAddresses.get(position).getStreetNumber());
//        holder.mStreetNameView.setText(mAddresses.get(position).getStreetName());
//        holder.mAptNumberView.setText(mAddresses.get(position).getAptNumber());
//        holder.mDateVisitedView.setText(mAddresses.get(position).getLastVisited());
//
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(mContext,R.array.address_statuses,android.R.layout.simple_spinner_item);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
////        holder.mAddressResultView.setAdapter(adapter);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return mAddresses.size();
//    }
//

}
