package com.seyed.nazanin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.seyed.nazanin.myapplication.core.PersianCalendarHandler;
import com.seyed.nazanin.myapplication.core.interfaces.OnDayClickedListener;
import com.seyed.nazanin.myapplication.core.interfaces.OnMonthChangedListener;
import com.seyed.nazanin.myapplication.core.models.CalendarEvent;
import com.seyed.nazanin.myapplication.core.models.PersianDate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final PersianCalendarView persianCalendarView  = (PersianCalendarView)findViewById(R.id.persian_calendar);
        final PersianCalendarHandler calendar = persianCalendarView.getCalendar();
        final PersianDate today = calendar.getToday();
        calendar.addLocalEvent(new CalendarEvent(
                today, "Custom event", false
        ));
        calendar.addLocalEvent(new CalendarEvent(
                today.clone().rollDay(2,true), "Custom event 2", true
        ));
        calendar.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onChanged(PersianDate date) {
                Toast.makeText(MainActivity.this, calendar.getMonthName(date),Toast.LENGTH_SHORT).show();
            }
        });
        persianCalendarView.setOnDayClickedListener(new OnDayClickedListener() {
            @Override
            public void onClick(PersianDate date) {
                for(CalendarEvent e : calendar.getAllEventsForDay(date))
                    Toast.makeText(MainActivity.this, e.getTitle(), Toast.LENGTH_LONG).show();


                calendar.addLocalEvent(new CalendarEvent(
                        today.clone().rollDay(2, false), "Some event that will be added in runtime", false
                ));
                persianCalendarView.update();
            }
        });

        calendar.setHighlightOfficialEvents(false);
        TextView txtDayMonth = (TextView) findViewById(R.id.txt_day_month);
        TextView txtYear = (TextView) findViewById(R.id.txt_year);

        String dayAndMonth = calendar.getWeekDayName(today) + calendar.formatNumber(today.getDayOfMonth())
                + calendar.getMonthName(today);
        txtDayMonth.setText(dayAndMonth);
        txtYear.setText(calendar.formatNumber(today.getYear()));

        calendar.setColorBackground(getResources().getColor(android.R.color.holo_blue_dark));
        persianCalendarView.update();
    }
}
