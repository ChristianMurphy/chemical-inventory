package murphy.com.chemicalinventory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import io.realm.Realm;
import murphy.com.chemicalinventory.models.Lab;


public class LabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab);
    }

    public void createLab(View view) {
        EditText labNameEdit = (EditText) findViewById(R.id.edit_lab_name);
        EditText labLocationEdit = (EditText) findViewById(R.id.edit_lab_location);
        EditText labManagerEdit = (EditText) findViewById(R.id.edit_lab_manager);

        String labName = labNameEdit.getText().toString();
        String labLocation = labLocationEdit.getText().toString();
        String labManager = labManagerEdit.getText().toString();

        Realm realm = Realm.getInstance(this);

        realm.beginTransaction();
        Lab lab = realm.createObject(Lab.class); // Create a new object
        lab.setName(labName);
        lab.setLocation(labLocation);
        lab.setManager(labManager);
        realm.commitTransaction();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
