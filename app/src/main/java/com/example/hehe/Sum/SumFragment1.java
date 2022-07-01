package com.example.hehe.Sum;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.hehe.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class SumFragment1 extends Fragment {

    PieChart pieChart;
    BarChart barChart;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sum1, container, false);

        pieChart = v.findViewById(R.id.piechart);
        barChart = v.findViewById(R.id.barchart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(10,10,10,0);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        barChart.getDescription().setEnabled(false);
        barChart.setTouchEnabled(false);
        barChart.getLegend().setEnabled(true);
        barChart.setExtraOffsets(30f, 0f, 40f, 0f);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawAxisLine(false);
        xAxis.setGranularity(1f);
        xAxis.setTextSize(15f);
        xAxis.setGridLineWidth(25f);
        xAxis.setGridColor(Color.parseColor("#80E5E5E5"));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis axisLeft = barChart.getAxisLeft();
        axisLeft.setDrawGridLines(false);
        axisLeft.setDrawAxisLine(false);
        axisLeft.setAxisMinimum(0f); // 최솟값
        axisLeft.setAxisMaximum(100f); // 최댓값
        axisLeft.setGranularity(1f); // 값만큼 라인선 설정
        axisLeft.setDrawLabels(false); // label 삭제

        // YAxis(Right) (수평 막대 기준 위쪽) - 사이즈, 선 유무
        YAxis axisRight = barChart.getAxisRight();
        axisRight.setTextSize(15f);
        axisRight.setDrawLabels(false); // label 삭제
        axisRight.setDrawGridLines(false);
        axisRight.setDrawAxisLine(false);


        //가운데 원형 뚫는거
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setEntryLabelTextSize(10);
        pieChart.setTransparentCircleRadius(0f);
        pieChart.getDescription().setEnabled(false);

        //원형 차트 고정
        pieChart.setRotationEnabled(false);



        // 범례 표시
        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);

        // 범례 표시
        Legend ll = barChart.getLegend();
        ll.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        ll.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        ll.setOrientation(Legend.LegendOrientation.HORIZONTAL);


        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();


        yValues.add(new PieEntry(30f,"교통비"));
        yValues.add(new PieEntry(30f,"생활용품"));
        yValues.add(new PieEntry(30f,"식비"));
        yValues.add(new PieEntry(30f,"취미"));
        yValues.add(new PieEntry(30f,"기타"));

        ArrayList<BarEntry> values = new ArrayList<BarEntry>();

        values.add(new BarEntry(2, 10,"10"));
        values.add(new BarEntry(2, 10,"10"));
        values.add(new BarEntry(1, 10,"10"));
        values.add(new BarEntry(4, 50,"10"));
        values.add(new BarEntry(6, 100,"10"));





        BarDataSet set2 = new BarDataSet(values,"Data Set");
        set2.setDrawIcons(false);
        set2.setDrawValues(true);
        set2.setColor(Color.parseColor("#66767676")); // 색상 설정

        BarData dataSet12 = new BarData(set2);
        dataSet12.setBarWidth(0.5f);
        dataSet12.setValueTextSize(15);





        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic); //애니메이션

        PieDataSet dataSet = new PieDataSet(yValues,"");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(15f);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setData(data);




        barChart.animateX(10, Easing.EasingOption.EaseInOutCubic); //애니메이션

        BarDataSet dataSet1 = new BarDataSet(values,"");
//        dataSet1.setSliceSpace(3);
//        dataSet1.setSelectionShift(5);
        dataSet1.setColors(ColorTemplate.JOYFUL_COLORS);

        BarData DataSet1 = new BarData((dataSet1));
        // 퍼센트 글씨 크기 조절
        dataSet1.setValueTextSize(15f);
        dataSet1.setValueTextColor(Color.GREEN);

        barChart.setData(DataSet1);

        return v;
    }

    private ArrayList<String> getXAxisValues(){
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("Tue");
        xAxis.add("Web");
        xAxis.add("Thu");
        xAxis.add("Fri");
        xAxis.add("Sat");
        xAxis.add("Sun");
        return xAxis;
    }


}