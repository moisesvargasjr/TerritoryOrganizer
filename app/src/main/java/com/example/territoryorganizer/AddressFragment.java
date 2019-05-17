package com.example.territoryorganizer;

/*This creates the AddressList Fragment that is supposed to be shown in the
CurrentTerritory activity. This is not currently present in the demo version because there
were some issues with setting the MyRecyclerAdapter. */


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class AddressFragment extends Fragment {

    /*
    private AddressViewModel mViewModel;
    private MyAddressRecyclerViewAdapter adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AddressViewModel.class);

        observerSetup();
        recyclerSetup();
    }

    private void observerSetup() {
        mViewModel.getAddressList().observe(this, new Observer<List<Address_Entity>>() {
            @Override
            public void onChanged(List<Address_Entity> address_entities) {
                adapter.setmAddresses(address_entities);
            }
        });
    }

    private void recyclerSetup() {
        RecyclerView recyclerView;

        adapter = new MyAddressRecyclerViewAdapter(getContext());
    }
*/
      // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private Territory mTerritory;
    private AddressViewModel mViewModel;
    private MyAddressRecyclerViewAdapter adapter;


    public AddressFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static AddressFragment newInstance(int columnCount) {
        AddressFragment fragment = new AddressFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        InputStream inputStream = getActivity().getResources().openRawResource(R.raw.addresslist);
        List<String[]> rows = new ArrayList<>();
        CSVFileReader csvFileReader = new CSVFileReader(inputStream);
        rows = csvFileReader.read();

        populateAddressRows(rows);

//        mTerritory = new Territory(72,"Poway","Mira Mesa");
//        mTerritory.insertFakeListings();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyAddressRecyclerViewAdapter(context));
        }
        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Listing item);
    }

    private void populateAddressRows(List<String[]> inputRows) {

    }



}
