package com.example.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView table;
    int product;
    ArrayList<String> timesTable;//initial default times table on opening the app
    ArrayList<String> properTT;//proper way to show the Times table.
    EditText input;



    public void searchOnClick(View view){
        input = (EditText) findViewById(R.id.numberET);
        TextView currentTable = (TextView) findViewById(R.id.tableDisplayedTV);
        int numEntered = Integer.parseInt(input.getText().toString());
        properTT = new ArrayList<String>();
        timesTable.clear(); //Clears the ArrayList that was initialized on create.
        currentTable.setText(" " + numEntered);

        for(int i = 1; i <=12; i++){
            product = numEntered *i;
            properTT.add(" "+ numEntered + " x " + i + " = " + product );
            ArrayAdapter<String> UpdatedTimesTableAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,properTT);//passes ArrayLists's data to the list view
            table.setAdapter(UpdatedTimesTableAdapter);//connects the arrayList (UpdatedTimesTableAdapter) with the list view

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        
        //Set up the 1 times table as the default table when app is launched
        table = (ListView) findViewById(R.id.timesTableListView);
        timesTable = new ArrayList<String>();
        for(int i = 1; i <=12; i++){
            product = 1 *i;
            timesTable.add("1 x "+ i + " = " + product);
        }

        ArrayAdapter<String> timesTableAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,timesTable);
        table.setAdapter(timesTableAdapter);
    }

}
