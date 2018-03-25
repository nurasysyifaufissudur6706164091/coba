package org.d3if.rememberactivities;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class detailingActivity extends AppCompatActivity {
    EditText date,time,datedone,timedone;
    DatePickerDialog datePickerDialog,datePickerDialogdone;
    public List arr;
    private Button batal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailing);
        setupActionBar();
        datebeginshow();
        timebeginshow();
        datedoneshow();
        timedoneshow();
        Button btn = (Button) findViewById(R.id.tambahdata);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText namakegiatan = (EditText) findViewById(R.id.activitiename);
                Spinner pengingatsebelum = (Spinner) findViewById(R.id.remindme);
                Spinner pengulangan = (Spinner) findViewById(R.id.repeat);
                EditText catatan = (EditText) findViewById(R.id.note);
                String namaAktivitas = namakegiatan.getText().toString();
                String pengingat = pengingatsebelum.getSelectedItem().toString();
                String pengulanganwaktu = pengulangan.getSelectedItem().toString();
                arr = new ArrayList<>();
                arr.add(new simpankegiatan(namaAktivitas, date.getText().toString(), time.getText().toString(), datedone.getText().toString(), timedone.getText().toString(), pengingat, pengulanganwaktu, catatan.getText().toString()));
                ListView list = (ListView) findViewById(R.id.myactivites);
                custom_adapter adapter = new custom_adapter(getApplicationContext(), R.layout.customlayoutlistview, arr);
                startActivity(new Intent(detailingActivity.this, seeActivity.class));
            }
        });
        Button batal = (Button) findViewById(R.id.batal);
        final String message = "ini adalah contoh notifikasi";
        final String title = "ini adalah judul";

        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifTemplate(message,title);


            }
        });
    }

    private void notifTemplate(String tittle, String message) {
        final Intent intent = new Intent(detailingActivity.this,detailNotifikasiActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(detailingActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder)new NotificationCompat.Builder(detailingActivity.this).
                setSmallIcon(R.mipmap.ic_launcher).setContentTitle(tittle).setContentText(message).setContentIntent(pendingIntent)
                .setAutoCancel(true).setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND | Notification.FLAG_AUTO_CANCEL);
        NotificationManager notificationManager =
                (NotificationManager)detailingActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,mBuilder.build());

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
            Intent in=new Intent(detailingActivity.this,firstActivity.class);
            startActivity(in);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void datebeginshow(){
        date =(EditText)findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c= Calendar.getInstance();
                int mYear=c.get(Calendar.YEAR);
                int mMont=c.get(Calendar.MONTH);
                int mDay=c.get(Calendar.DAY_OF_MONTH);
                datePickerDialog=new DatePickerDialog(detailingActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        date.setText(day+"/"+month+"/"+year);
                    }
                },mYear,mMont,mDay);
                datePickerDialog.show();
            }
        });
    }
    private void datedoneshow(){
        datedone =(EditText)findViewById(R.id.datedone);
        datedone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c= Calendar.getInstance();
                int mYear=c.get(Calendar.YEAR);
                int mMont=c.get(Calendar.MONTH);
                int mDay=c.get(Calendar.DAY_OF_MONTH);
                datePickerDialogdone=new DatePickerDialog(detailingActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        datedone.setText(day+"/"+month+"/"+year);
                    }
                },mYear,mMont,mDay);
                datePickerDialogdone.show();
            }
        });
    }
    private void timebeginshow(){
        time=(EditText)findViewById(R.id.timee);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mCurentTime=Calendar.getInstance();
                int hour=mCurentTime.get(Calendar.HOUR_OF_DAY);
                int minute=mCurentTime.get(Calendar.MINUTE);
                TimePickerDialog mtimepicker;
                mtimepicker=new TimePickerDialog(detailingActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        time.setText(hour+":"+minute);
                    }
                },hour,minute,true);
                mtimepicker.setTitle("Select Time");
                mtimepicker.show();
            }
        });
    }
    private void timedoneshow(){
        timedone=(EditText)findViewById(R.id.timedone);
        timedone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mCurentTime=Calendar.getInstance();
                int hour=mCurentTime.get(Calendar.HOUR_OF_DAY);
                int minute=mCurentTime.get(Calendar.MINUTE);
                TimePickerDialog mtimepickerdone;
                mtimepickerdone=new TimePickerDialog(detailingActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        timedone.setText(hour+":"+minute);
                    }
                },hour,minute,true);
                mtimepickerdone.setTitle("Select Time");
                mtimepickerdone.show();
            }
        });
    }


}
