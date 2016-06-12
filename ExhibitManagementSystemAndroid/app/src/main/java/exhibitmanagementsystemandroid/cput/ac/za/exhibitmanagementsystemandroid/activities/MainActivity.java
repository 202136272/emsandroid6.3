package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.R;

public class MainActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = (Button) findViewById(R.id.btnStart);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), secondScreen.class);
                startActivityForResult(myIntent, 0);
                

            }

        });

    }

}