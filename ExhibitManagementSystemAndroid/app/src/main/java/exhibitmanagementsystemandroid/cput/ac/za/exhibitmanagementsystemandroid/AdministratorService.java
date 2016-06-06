package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl.AdministratorServiceImpl;

public class AdministratorService extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_service);


        Button adminStartService = (Button) findViewById(R.id.button_start_service);
        adminStartService.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent msgIntent = new Intent(getApplicationContext(), AdministratorService.class);
                msgIntent.putExtra(AdministratorServiceImpl.CONNECTIVITY_SERVICE, "");
                startService(msgIntent);

                Toast.makeText(getApplicationContext(), "Service Started\n", Toast.LENGTH_LONG).show();


            }
        });

    }
}
