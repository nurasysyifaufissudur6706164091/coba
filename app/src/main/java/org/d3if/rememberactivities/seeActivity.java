package org.d3if.rememberactivities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class seeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see);

        setupActionBar();
    }
    private void getAll(){
        EditText namaKegiatan=(EditText)findViewById(R.id.activitiename);
        Spinner pengingatsebelum=(Spinner) findViewById(R.id.remindme);
        Spinner pengulangan=(Spinner)findViewById(R.id.repeat);
        EditText catatan=(EditText)findViewById(R.id.note);
        EditText date=(EditText)findViewById(R.id.date);
        EditText datedone=(EditText)findViewById(R.id.datedone);
        EditText time=(EditText)findViewById(R.id.timee);
        EditText timedone=(EditText)findViewById(R.id.timedone);
        String namaaktivitas=namaKegiatan.getText().toString();
        String tanggalmulai=date.getText().toString();
        String jammulai=time.getText().toString();
        String tanggalselesai=datedone.getText().toString();
        String jamselesai=timedone.getText().toString();
        String pengingat=pengingatsebelum.getSelectedItem().toString();
        String pengulanganwaktu=pengulangan.getSelectedItem().toString();
        String catat=catatan.getText().toString();

        List kegiatan =new ArrayList<>();
        kegiatan.add(new simpankegiatan(namaaktivitas,tanggalmulai,jammulai,tanggalselesai,jamselesai,pengingat,pengulanganwaktu,catat));
        ListView lis=(ListView)findViewById(R.id.myactivites);
        custom_adapter adapter=new custom_adapter(this,R.layout.customlayoutlistview,kegiatan);
        lis.setAdapter(adapter);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //if(v.getId()==R.id.myactivites){
          //  AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)menuInfo;
          //  menu.setHeaderTitle(arr.get(info.position));
            //String [] menuitem=getResources().getStringArray(R.array.menu);
           // for (int i = 0; i <menuitem.length ; i++) {
           //     menu.add(Menu.NONE,i,i,menuitem[i]);
            //}
        //}

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
       // AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
       // int menuItemIndex=item.getItemId();
        //String [] menuItem=getResources().getStringArray(R.array.menu);
        //String  menuItemName=menuItem[menuItemIndex];
        //String ListitemName=arr.get(info.position);
        //for (int i = 0; i <menuItem.length ; i++) {
          //  if(menuItem[i].equalsIgnoreCase("Edit")){
            //    startActivity(new Intent(seeActivity.this,detailingActivity.class));
            //}else if(menuItem[i].equalsIgnoreCase("Hapus")) {
                /*to do*/
            //}
        //}
       return true;
    }
    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent in=new Intent(seeActivity.this,firstActivity.class);
            startActivity(in);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
