package com.example.forminformation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText dateTXT;
    private  int mDate, mMonth, mYear;

    RadioGroup nganh_hoc;
    EditText mssv, ho_ten, cccd, sdt, email, date, que_quan, hien_tai;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTXT = findViewById(R.id.date);

        mssv = findViewById(R.id.mssv);
        ho_ten = findViewById(R.id.ho_ten);
        cccd = findViewById(R.id.cccd);
        sdt = findViewById(R.id.sdt);
        email = findViewById(R.id.email);
        date = findViewById(R.id.date);
        que_quan = findViewById(R.id.que_quan);
        hien_tai = findViewById(R.id.hien_tai);
        submit = findViewById(R.id.submit);
        nganh_hoc = findViewById(R.id.nganh_hoc);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String etmssv = mssv.getText().toString();
                String etho_ten = ho_ten.getText().toString();
                String etcccd = cccd.getText().toString();
                String etsdt = sdt.getText().toString();
                String etemail = email.getText().toString();
                String etdate = date.getText().toString();
                String etque_quan = que_quan.getText().toString();
                String ethien_tai = hien_tai.getText().toString();

                boolean check = validateinfo(etmssv,etho_ten,etcccd,etsdt,etemail,etdate,etque_quan,ethien_tai);
                if (check == true){
                    Toast.makeText(getApplicationContext(), "Data is valid", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry check information again", Toast.LENGTH_SHORT).show();
                }
                ValidationCheckRadio();
            }
        });

        dateTXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar Cal = Calendar.getInstance();
                mDate = Cal.get(Calendar.DATE);
                mMonth = Cal.get(Calendar.MONTH);
                mYear = Cal.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                        dateTXT.setText(date+"-"+month+"-"+year);
                    }
                }, mYear, mMonth, mDate);
                datePickerDialog.show();
            }
        });
    }

    private void ValidationCheckRadio() {
        int isSelected = nganh_hoc.getCheckedRadioButtonId();
        if (isSelected == -1){
            Toast.makeText(MainActivity.this, "Please select study", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validateinfo(String etmssv, String etho_ten, String etcccd, String etsdt, String etemail, String etdate, String etque_quan, String ethien_tai) {
        if(etmssv.length()==0){
            mssv.requestFocus();
            mssv.setError("Please enter ");
            return false;
        }
        if(etho_ten.length()==0){
            ho_ten.requestFocus();
            ho_ten.setError("Please enter ");
            return false;
        }
        if(etcccd.length()==0){
            cccd.requestFocus();
            cccd.setError("Please enter");
            return false;
        }
        if(etsdt.length()==0){
            sdt.requestFocus();
            sdt.setError("Please enter");
            return false;
        }
        if(etemail.length()==0){
            email.requestFocus();
            email.setError("Please enter");
            return false;
        }
        if(etdate.length()==0){
            date.requestFocus();
            date.setError("Please enter");
            return false;
        }
        if(etque_quan.length()==0){
            que_quan.requestFocus();
            que_quan.setError("Please enter");
            return false;
        }
        if(ethien_tai.length()==0){
            hien_tai.requestFocus();
            hien_tai.setError("Please enter");
            return false;
        }
        return true;
    }

}