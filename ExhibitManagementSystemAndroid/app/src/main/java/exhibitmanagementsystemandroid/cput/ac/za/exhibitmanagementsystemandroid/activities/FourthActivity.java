package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.activities;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;


import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.R;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;

/* REFERENCE FOR THIS CODE GO TO :
       http://www.coderzheaven.com/2011/12/26/show-data-in-columns-in-a-tableview-dynamically-in-android/
        */
public class FourthActivity extends Activity {


    TableLayout tl;
    TableRow tr;
    TextView idTextView,nameTextView, surnameTextView, persalNoTextView;
    Set<Administrator> settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        tl = (TableLayout) findViewById(R.id.maintable);
        Button myHomebtn= (Button)findViewById(R.id.btnHome);


        myHomebtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
             //   AdministratorRepository repo = new AdministratorRepositoryImpl(getApplicationContext());
                //READ ALL
               // settings = repo.findAll();

                Toast.makeText(FourthActivity.this, settings.toString(), Toast.LENGTH_LONG).show();
                addHeaders();
                addData();
            }
        });

    }

    public void addHeaders(){

        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));

        /** Creating a TextView to add to the row **/
        TextView adminid = new TextView(this);
        adminid.setText("ID");
        adminid.setTextColor(Color.GRAY);
        adminid.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        adminid.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        adminid.setPadding(5, 5, 5, 0);
        tr.addView(adminid);  // Adding textView to tablerow.

        /** Creating another textview **/
        TextView colname = new TextView(this);
        colname.setText("Name");
        colname.setTextColor(Color.GRAY);
        colname.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        colname.setPadding(5, 5, 5, 0);
        colname.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(colname); // Adding textView to tablerow.

        /** Creating another textview **/
        TextView colSurname = new TextView(this);
        colSurname.setText("Surname");
        colSurname.setTextColor(Color.GRAY);
        colSurname.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        colSurname.setPadding(5, 5, 5, 0);
        colSurname.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(colSurname); // Adding textView to tablerow.

        /** Creating another textview **/
        TextView persanlNo = new TextView(this);
        persanlNo.setText("Persal no");
        persanlNo.setTextColor(Color.GRAY);
        persanlNo.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        persanlNo.setPadding(5, 5, 5, 0);
        persanlNo.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(persanlNo); // Adding textView to tablerow.


        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));

        // we are adding two textviews for the divider because we have two columns
        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));


    }

    /** This function add the data to the table **/
    public void addData() {

        for (Administrator admin : settings) {
            {


                /** Create a TableRow dynamically **/
                tr = new TableRow(this);
                tr.setLayoutParams(new LayoutParams(
                        LayoutParams.FILL_PARENT,
                        LayoutParams.WRAP_CONTENT));

                /** Creating a TextView to add to the row **/
                idTextView = new TextView(this);
                //idTextView.setText(admin.getId().toString());
                idTextView.setTextColor(Color.RED);
                idTextView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                idTextView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
                idTextView.setPadding(5, 5, 5, 5);
                tr.addView(idTextView);  // Adding textView to tablerow.

                /** Creating another textview **/
                nameTextView = new TextView(this);
                nameTextView.setText(admin.getName().toString());
                nameTextView.setTextColor(Color.GREEN);
                nameTextView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
                nameTextView.setPadding(5, 5, 5, 5);
                nameTextView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                tr.addView(nameTextView); // Adding textView to tablerow.*/

                /** Creating another textview **/
                surnameTextView = new TextView(this);
                surnameTextView.setText(admin.getSurname().toString());
                surnameTextView.setTextColor(Color.GREEN);
                surnameTextView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
                surnameTextView.setPadding(5, 5, 5, 5);
                surnameTextView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                tr.addView(surnameTextView); // Adding textView to tablerow.*/

                /** Creating another textview **/
                persalNoTextView = new TextView(this);
                persalNoTextView.setText(admin.getPersalNumber().toString());
                persalNoTextView.setTextColor(Color.GREEN);
                persalNoTextView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
                persalNoTextView.setPadding(5, 5, 5, 5);
                persalNoTextView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                tr.addView(persalNoTextView); // Adding textView to tablerow.*/

                // Add the TableRow to the TableLayout
                tl.addView(tr, new TableLayout.LayoutParams(
                        LayoutParams.FILL_PARENT,
                        LayoutParams.WRAP_CONTENT));
            }
        }


    }





}
