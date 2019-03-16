package com.example.prabal.campushaat;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FlatFragment extends Fragment {
    private String name, address, category;

    public FlatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (getArguments() != null) {
            name = getArguments().getString("name");
            address = getArguments().getString("address");
            category = getArguments().getString("category");

        }
        View mContainer = inflater.inflate(R.layout.fragment_hostel, null);
        LinearLayout linearLayout = mContainer.findViewById(R.id.linearlayout);

        LinearLayout linearLayoutParent = new LinearLayout(getActivity());
        linearLayoutParent.setOrientation(LinearLayout.HORIZONTAL);
        linearLayoutParent.removeAllViews();
        LinearLayout linearLayoutChild1 = new LinearLayout(getActivity());
        linearLayoutChild1.setOrientation(LinearLayout.VERTICAL);
        LinearLayout linearLayoutChild2 = new LinearLayout(getActivity());
        linearLayoutChild2.setOrientation(LinearLayout.VERTICAL);
        linearLayoutChild1.removeAllViews();
        linearLayoutChild2.removeAllViews();
        ImageButton imageButton = new ImageButton(getActivity());
        imageButton.setImageResource(R.drawable.ic_launcher_background);
        linearLayoutChild1.addView(imageButton);
        //Typeface typeface = Typeface.createFromAsset(getAssets(), "oswald/oswaldbold.ttf");
        TextView textView = new TextView(getActivity());
        textView.setText(name);
        textView.setTextSize(20);
        //textView.setTypeface(typeface);
        textView.setPadding(20, 20, 0, 0);
        linearLayoutChild2.addView(textView);
        TextView textView2 = new TextView(getActivity());
        textView2.setText(address);
        textView2.setPadding(20, 10, 0, 0);
        linearLayoutChild2.addView(textView2);
        Button button=new Button(getActivity());
        button.setPadding(20,10,0,0);
        int random = (int )(Math.random() * 2 + 1);
        if(random==1) { button.setText("Call Owner"); }
        else if(random==2) { button.setText("Contact Broker"); }
        linearLayoutChild2.addView(button);


        TextView textView3 = new TextView(getActivity());
        textView3.setText(category);
        textView3.setPadding(20, 10, 0, 0);
        linearLayoutChild2.addView(textView3);

        linearLayoutParent.addView(linearLayoutChild1);
        linearLayoutParent.addView(linearLayoutChild2);
        linearLayout.addView(linearLayoutParent);
        return mContainer;
        //return inflater.inflate(R.layout.fragment_flat, container, false);
    }

}
