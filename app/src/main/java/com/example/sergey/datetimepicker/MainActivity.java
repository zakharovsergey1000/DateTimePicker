package com.example.sergey.datetimepicker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.android.datetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePickerDialog dialog, int year, int monthOfYear, int dayOfMonth) {
                            textView.setText(year + " " + monthOfYear + " " + dayOfMonth);
                        }
                    },
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
                dpd.show(getFragmentManager(), null);
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                android.app.DatePickerDialog datePickerDialog = new android.app.DatePickerDialog(MainActivity.this,
                    new android.app.DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            textView.setText(year + " " + month + " " + dayOfMonth);
                        }
                    },
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
    }
}
