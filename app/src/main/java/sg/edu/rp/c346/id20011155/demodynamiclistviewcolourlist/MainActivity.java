package sg.edu.rp.c346.id20011155.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etColour;
    EditText etPos;
    Button addBtn;
    Button rmvBtn;
    Button upBtn;
    ListView lvColour;

    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etColour = findViewById(R.id.editTextColour);
        etPos = findViewById(R.id.editTextNumber);
        addBtn = findViewById(R.id.buttonAddItem);
        rmvBtn = findViewById(R.id.buttonRmvItem);
        upBtn = findViewById(R.id.buttonUpdItem);
        lvColour = findViewById(R.id.listViewColour);

        alColours = new ArrayList<>();
        alColours.add("Orange");
        alColours.add("Red");

        aaColour= new ArrayAdapter<> (MainActivity.this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String colour = etColour.getText().toString();
                int pos = Integer.parseInt(etPos.getText().toString());

                if (!etColour.getText().toString().equalsIgnoreCase("")) {
                    if (pos > alColours.size()) {
                        Toast.makeText(MainActivity.this, "Please Indicate a smaller number!", Toast.LENGTH_LONG).show();
                    } else {
                        alColours.add(pos,colour);
                        aaColour.notifyDataSetChanged();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please Indicate Colour!", Toast.LENGTH_LONG).show();
                }
            }
        });

        rmvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etPos.getText().toString().equalsIgnoreCase("")) {
                    String num = etPos.getText().toString();
                    if (Integer.parseInt(num) > alColours.size()-1) {
                        Toast.makeText(MainActivity.this, "Please Indicate a smaller number!", Toast.LENGTH_LONG).show();
                    } else {
                        alColours.remove(Integer.parseInt(etPos.getText().toString()));
                        aaColour.notifyDataSetChanged();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please Indicate Position!", Toast.LENGTH_LONG).show();
                }
            }
        });

        upBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etPos.getText().toString().equalsIgnoreCase("") && !etColour.getText().toString().equalsIgnoreCase("")) {
                    String num = etPos.getText().toString();
                    if (Integer.parseInt(num) > alColours.size()-1) {
                        Toast.makeText(MainActivity.this, "Please Indicate a smaller number!", Toast.LENGTH_LONG).show();
                    } else {
                        alColours.set(Integer.parseInt(etPos.getText().toString()), etColour.getText().toString());
                        aaColour.notifyDataSetChanged();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please Indicate Colour and Position!", Toast.LENGTH_LONG).show();
                }
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
            }
        });
    }
}