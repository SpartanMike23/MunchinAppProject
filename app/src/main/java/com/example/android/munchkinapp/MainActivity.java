package com.example.android.munchkinapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int valueFrmPower;
    private int power;
    private Button increment;
    private Button decrement;
    private EditText editPowerLvl;
    private String powerLvl;
    private Button clearBtn;

    /**
     * TextWatcher Class created for user input on the EditText view
     * Methods include beforeTextChanged, onTextChanged, afterTextChanged
     *
     * @param charSequence length of user input
     * @param editable notification when changed
     */
    private final TextWatcher mTextEditorWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            //created to prevent crash if user inputs a no length number.
            if (charSequence.length() == 0) {
                return;
            }
            powerLvl = editPowerLvl.getText().toString();

        }

        @Override
        public void afterTextChanged(Editable editable) {
            power = Integer.parseInt(powerLvl);
            valueFrmPower = power;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Global variable instances created.
        increment = (Button) findViewById(R.id.increment);
        decrement = (Button) findViewById(R.id.decrement);
        editPowerLvl = (EditText) findViewById(R.id.powerLvlEdit);
        clearBtn = (Button) findViewById(R.id.clearBtn);

        editPowerLvl.addTextChangedListener(mTextEditorWatcher);

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueFrmPower += 1;
                editPowerLvl.setText(Integer.toString(valueFrmPower));
            }
        });

        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueFrmPower -= 1;
                if (valueFrmPower < 0) {
                    valueFrmPower = 0;
                }
                editPowerLvl.setText(Integer.toString(valueFrmPower));
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueFrmPower = 0;
                editPowerLvl.setText(Integer.toString(valueFrmPower));
            }
        });

    }
}
