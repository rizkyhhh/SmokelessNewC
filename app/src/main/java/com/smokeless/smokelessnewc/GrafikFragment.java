package com.smokeless.smokelessnewc;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GrafikFragment extends Fragment {

    private LineChart mChart;

    public GrafikFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_grafik, container, false);

        mChart = (LineChart) rootView.findViewById(R.id.linechart);

//        mChart.setOnChartGestureListener(MainActivity.this);
//        mChart.setOnChartValueSelectedListener(MainActivity.this);
//
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false);
//LIMIT
//        LimitLine upper_limit = new LimitLine(5f,"Bahaya");
//        upper_limit.setLineWidth(4f);
//        upper_limit.enableDashedLine(10f,10f,0f);
//        upper_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
//        upper_limit.setTextSize(15f);
//
//        YAxis leftAxis = mChart.getAxisLeft();
//        leftAxis.removeAllLimitLines();
//        leftAxis.addLimitLine(upper_limit);
//        leftAxis.enableGridDashedLine(2f,2f,0);
//        leftAxis.setDrawLimitLinesBehindData(true);


        ArrayList<Entry> yValues = new ArrayList<>();

        yValues.add(new Entry(0,4f));
        yValues.add(new Entry(1,10f));
        yValues.add(new Entry(2,2f));
        yValues.add(new Entry(3,5f));
        yValues.add(new Entry(4,2f));
        yValues.add(new Entry(5,1f));
        yValues.add(new Entry(6,0f));

        LineDataSet set1 = new LineDataSet(yValues, "Jumlah Batang Rokok");

        set1.setFillAlpha(110);

        set1.setColor(Color.BLUE);
        set1.setLineWidth(3f);
        set1.setValueTextSize(10f);
        set1.setValueTextColor(Color.RED);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        mChart.setData(data);


        String[] months = new String[] {"Senin", "Selasa" ,"Rabu" , "Kamis" , "Jumat" , "Sabtu", "Minggu"};
        XAxis xAxis = mChart.getXAxis();
        xAxis.setValueFormatter(new MainActivity.MyXAxisValueFormatter(months));

        return rootView;
    }

}
