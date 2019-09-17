package com.example.tuan2p2bai4;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    private ArrayList<String> mylist;
    private ArrayAdapter<String> adapter;
    private Button btnnhap;
    private TextView tvkq;
    private EditText etten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mylist=new ArrayList<String>();
        etten=findViewById(R.id.editText_ten);
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mylist);
        setListAdapter(adapter);
        btnnhap=findViewById(R.id.button_nhap);
        btnnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylist.add(etten.getText()+"");
                adapter.notifyDataSetChanged();
            }
        });
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        tvkq=findViewById(R.id.textView_kq);
        String item= (String) getListAdapter().getItem(position);
        tvkq.setText("Position: "+position+";Value: "+item+"");
    }
}
