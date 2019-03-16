package com.example.prabal.campushaat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView editTotalRecord=null;
    TableControllerHostel tableControllerHostel=null;
    EditText editId=null;
    HostelRecord obj=null;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTotalRecord=(TextView)findViewById(R.id.editTotalRecord);
        obj=new HostelRecord();
    }
    public void clickedInsert(Context context) {
        try {
            tableControllerHostel = new TableControllerHostel(context);
            for (int i = 0; i < 100; i++) {
                tableControllerHostel.autoCreate();
            }
            int totalRecord = tableControllerHostel.count();
            editTotalRecord.setText((Integer.toString(totalRecord)));
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private class GetHostels extends AsyncTask<Void,Void,Void> {
        String searchFood;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //This creates the progress bar which shows loading please wait
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setCancelable(false);
            progressDialog.setTitle("Searching hostels nearby...");
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            clickedInsert(getApplicationContext());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(progressDialog.isShowing())
                progressDialog.dismiss();
            Intent intent=new Intent(MainActivity.this,ListActivity.class);
            startActivity(intent);
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    public void clickedRead(View view){
        new GetHostels().execute();
    }

}
