package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.R;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.AdministratorRepository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.Impl.AdministratorRepositoryImpl;

public class thirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button submit = (Button) findViewById(R.id.btnSubmit);

        Intent i = getIntent();
        final Administrator myAdminCatch =(Administrator)i.getSerializableExtra("AdminValue");

        Toast.makeText(thirdActivity.this,myAdminCatch.toString(),Toast.LENGTH_LONG).show();

        EditText myEdit = (EditText ) findViewById(R.id.displayAlltxt);
        myEdit.setText(myAdminCatch.toString());





        submit.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                AdministratorRepository repo = new AdministratorRepositoryImpl(getApplicationContext());
                // CREATE
                //Administrator createEntity = AdministratorFactory.CreateAdministrator(myAdminCatch.getName(),myAdminCatch.getSurname(),myAdminCatch.getPersalNumber());
                        Administrator insertedEntity = repo.save(myAdminCatch);

                //Call the fourth sctivity
                Intent myIntent = new Intent(view.getContext(), FourthActivity.class);
                startActivityForResult(myIntent, 0);

            }
        });

    }
}

