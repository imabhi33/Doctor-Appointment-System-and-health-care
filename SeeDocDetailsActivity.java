package com.example.healthcare;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
public class SeeDocDetailsActivity extends AppCompatActivity {
    private String[][] doctor_detailsl1 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katrai", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_detailsl2 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katrai", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_detailsl3 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katrai", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_detailsl4 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katrai", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_detailsl5 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katrai", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };
    TextView tv;
    String[][] doctor_details = {};
    ArrayList list;
    SimpleAdapter sa;

    HashMap<String, String> item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_details);
        tv = findViewById(R.id.textViewDOCTitle);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        if (title.compareTo("Family physicians") == 0)
            doctor_details = doctor_detailsl1;
        else if (title.compareTo("Dietician") == 0)
            doctor_details = doctor_detailsl2;
        else if (title.compareTo("Dentists") == 0)
            doctor_details = doctor_detailsl3;
        else if (title.compareTo("Surgeon") == 0)
            doctor_details = doctor_detailsl4;
        else
            doctor_details = doctor_detailsl5;


        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fee" + doctor_details[i][4] + "/-");
            list.add(item);

        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);

        lst.setAdapter(sa);
    }
}