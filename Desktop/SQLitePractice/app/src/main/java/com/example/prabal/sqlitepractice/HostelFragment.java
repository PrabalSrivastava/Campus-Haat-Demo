package com.example.prabal.sqlitepractice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HostelFragment extends Fragment {
    private String name,address,category;

    public HostelFragment() {
        // Required empty public constructor
    }
    public HostelFragment(Student obj) {
        // Required empty public constructor
        this.name=obj.firstname;
        this.address=obj.email;
        this.category=obj.category;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mContainer = inflater.inflate(R.layout.fragment_hostel, null);
        TextView textViewName =mContainer.findViewById(R.id.hostelname);
        textViewName.setText(name);
        TextView textViewAddress =mContainer.findViewById(R.id.hosteladdress);
        textViewName.setText(address);
        TextView textViewCategory =mContainer.findViewById(R.id.hostelcategory);
        textViewName.setText(category);
        return mContainer;
        //return inflater.inflate(R.layout.fragment_hostel, container, false);
    }

}
