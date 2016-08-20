package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.activities;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.R;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.AdministratorService;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.Impl.AdministratorServiceImpl;

public class secondScreen extends AppCompatActivity {

    AdministratorService service = new AdministratorServiceImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        Button preview = (Button) findViewById(R.id.btnPreview);
        LayoutInflater factory = LayoutInflater.from(this);

        Toast.makeText(secondScreen.this,"Welcome Administrator",Toast.LENGTH_LONG).show();

        // allow connection to web --- very important point
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(secondScreen.this,"IN Administrator",Toast.LENGTH_LONG).show();

                final EditText myId =(EditText)findViewById(R.id.txtIdno);
                Administrator admin = service.findById(Long.parseLong(myId.getText().toString()));    //convert to long

                if(admin == null){
                    Toast.makeText(secondScreen.this,"Administrator Empty",Toast.LENGTH_LONG).show();
                }else {
                    // exception handling

                    final EditText myName = (EditText) findViewById(R.id.txtName);
                    final EditText mySurname = (EditText) findViewById(R.id.txtSurname);
                    final EditText myPersal = (EditText) findViewById(R.id.txtPersalNo);

                    myPersal.setText(admin.getPersalNumber());
                    myName.setText(admin.getName());
                    mySurname.setText(admin.getSurname());
                }
            }

        });

    }



}
