package murphy.com.chemicalinventory.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import io.realm.Realm;
import murphy.com.chemicalinventory.R;
import murphy.com.chemicalinventory.models.LabModel;


public class EditLabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_lab);
    }

    public void createLab(View view) {
        // Get the Edit Text fields
        EditText labNameEdit = (EditText) findViewById(R.id.edit_lab_name);
        EditText labLocationEdit = (EditText) findViewById(R.id.edit_lab_location);
        EditText labManagerEdit = (EditText) findViewById(R.id.edit_lab_manager);

        // Convert Edit Text to Variables
        String labName = labNameEdit.getText().toString();
        String labLocation = labLocationEdit.getText().toString();
        String labManager = labManagerEdit.getText().toString();

        Realm realm = Realm.getInstance(this);
        realm.beginTransaction();

        // Create new LabModel
        LabModel lab = realm.createObject(LabModel.class);
        lab.setName(labName);
        lab.setLocation(labLocation);
        lab.setManager(labManager);

        realm.commitTransaction();
        realm.close();

        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_lab, menu);
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
