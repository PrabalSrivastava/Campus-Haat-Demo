package com.example.prabal.campushaat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(ListActivity.this);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("LoggedIn", true);
        editor.apply();
        clickedRead(getApplicationContext());
    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    /*public void clickedRead(Context context) {
        LinearLayout parent=(LinearLayout) findViewById(R.id.parent);
        parent.removeAllViews();
        //Context context=view.getRootView().getContext();
        List<HostelRecord> recordStudent=new TableControllerHostel(context).read();

        try {
            if (recordStudent.size() > 0) {
                for (HostelRecord obj : recordStudent) {
                    int id = obj.id;
                    String name = obj.getName();
                    String address = obj.getAddress();
                    String category =obj.getCategory();
                    LinearLayout linearLayoutParent=new LinearLayout(this);
                    linearLayoutParent.setOrientation(LinearLayout.HORIZONTAL);
                    linearLayoutParent.removeAllViews();
                    LinearLayout linearLayoutChild1=new LinearLayout(this);
                    linearLayoutChild1.setOrientation(LinearLayout.VERTICAL);
                    LinearLayout linearLayoutChild2=new LinearLayout(this);
                    linearLayoutChild2.setOrientation(LinearLayout.VERTICAL);
                    linearLayoutChild1.removeAllViews();
                    linearLayoutChild2.removeAllViews();
                    ImageButton imageButton = new ImageButton(this);
                    imageButton.setImageResource(R.drawable.ic_launcher_background);
                    linearLayoutChild1.addView(imageButton);
                    Typeface typeface=Typeface.createFromAsset(getAssets(),"oswald/oswaldbold.ttf");
                    TextView textView = new TextView(this);
                    textView.setText(name);
                    textView.setTextSize(20);
                    textView.setTypeface(typeface);
                    textView.setPadding(20, 20, 0, 0);
                    linearLayoutChild2.addView(textView);
                    TextView textView2 = new TextView(this);
                    textView2.setText(address);
                    textView2.setPadding(20, 10, 0, 0);
                    linearLayoutChild2.addView(textView2);

                    TextView textView3 = new TextView(this);
                    textView3.setText(category);
                    textView3.setPadding(20, 100, 0, 0);
                    linearLayoutChild2.addView(textView3);

                    linearLayoutParent.addView(linearLayoutChild1);
                    linearLayoutParent.addView(linearLayoutChild2);
                    parent.addView(linearLayoutParent);
                }
            }
            else {
                TextView locationItem = new TextView(this);
                locationItem.setPadding(8, 8, 8, 8);
                locationItem.setText("No records yet.");
                parent.addView(locationItem);
            }
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }*/
    public void clickedRead(Context context) {
        LinearLayout parent = (LinearLayout) findViewById(R.id.parent);
        parent.removeAllViews();
        //Context context=view.getRootView().getContext();
        List<HostelRecord> recordHostel = new TableControllerHostel(context).read();

        try {
            if (recordHostel.size() > 0) {
                for (HostelRecord obj : recordHostel) {
                    Fragment myObj = null;
                    FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                    Bundle bundle = new Bundle();
                    bundle.putString("name",obj.getName());
                    bundle.putString("address",obj.getAddress());
                    bundle.putString("category",obj.getCategory());
                    LinearLayout linearLayout=new LinearLayout(context);
                    int i=12345;
                    linearLayout.setId(i);
                    parent.addView(linearLayout);
                    if (obj.getCategory().equals("Hostel")) {
                        myObj = new HostelFragment();
                    }
                    if (obj.getCategory().equals("PG")) {
                        myObj = new PGFragment();
                    }
                    if (obj.getCategory().equals("Flat")) {
                        myObj = new FlatFragment();
                    }
                    myObj.setArguments(bundle);
                    ft1.add(R.id.parent, myObj);
                    ft1.commit();
                }
            } else {
                TextView locationItem = new TextView(this);
                locationItem.setPadding(8, 8, 8, 8);
                locationItem.setText("No records yet.");
                parent.addView(locationItem);
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "List" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
