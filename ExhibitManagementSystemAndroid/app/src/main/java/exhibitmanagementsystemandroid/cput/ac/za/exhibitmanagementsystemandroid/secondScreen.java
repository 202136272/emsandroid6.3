package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;

public class secondScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        Button preview = (Button) findViewById(R.id.btnPreview);

        LayoutInflater factory = LayoutInflater.from(this);

         final EditText myId =(EditText)findViewById(R.id.txtIdno);
         final EditText myName = (EditText)findViewById(R.id.txtName);
         final EditText mySurname = (EditText)findViewById(R.id.txtSurname);
         final EditText myPersal = (EditText)findViewById(R.id.txtPersalNo);



        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fisrtName =myName.getText().toString();

                String surName = mySurname.getText().toString();
                Long idNo = Long.parseLong(myId.getText().toString());
                String persal = myPersal.getText().toString();


                Administrator myAdmin = new Administrator.Builder()
                        .id(idNo)
                        .name(fisrtName)
                        .surname(surName)
                        .persalNumber(persal)
                        .build();

                Intent myIntent = new Intent(view.getContext(), thirdActivity.class);
                myIntent.putExtra("AdminValue", myAdmin);

                startActivityForResult(myIntent, 0);


            }

        });

    }



}
