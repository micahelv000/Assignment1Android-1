package com.example.assigemnt1_recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DataModel> dataSet;
    private ArrayList<DataModel> filteredDataSet;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CustomeAdapter adapter;
    private EditText editTextSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSet = new ArrayList<>();
        filteredDataSet = new ArrayList<>();
        recyclerView = findViewById(R.id.resView);
        editTextSearch = findViewById(R.id.editText); // Correctly reference the EditText
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterDataSet(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < myData.nameArray.length; i++) {
            dataSet.add(new DataModel(
                    myData.nameArray[i],
                    myData.Number_of_EPS_Array[i],
                    myData.drawableArray[i],
                    myData.id_[i],
                    myData.DescrbcetionArray[i]
            ));
        }
        filteredDataSet.addAll(dataSet);

        adapter = new CustomeAdapter(filteredDataSet, this); // Pass context here
        recyclerView.setAdapter(adapter);
    }

    private void filterDataSet(String query) {
        filteredDataSet.clear();

        for (DataModel dataModel : dataSet) {
            if (dataModel.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredDataSet.add(dataModel);
            }
        }

        adapter.notifyDataSetChanged();
    }
}
