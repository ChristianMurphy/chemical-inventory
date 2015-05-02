package murphy.com.chemicalinventory.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import io.realm.Realm;
import murphy.com.chemicalinventory.R;
import murphy.com.chemicalinventory.models.ChemicalModel;
import murphy.com.chemicalinventory.models.LabModel;

/**
 * EditChemicalActivity
 * @author Christian Murphy
 * @version March 1, 2015
 * License: MIT http://opensource.org/licenses/MIT
 */
public class EditChemicalActvity extends AppCompatActivity {
    String labName;
    String oldChemicalName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        setContentView(R.layout.activity_edit_chemical);
        if (extras.containsKey("chemicalName")) {
            // Get the lab name
            labName = extras.getString("labName");

            // Get the ChemicalModel
            oldChemicalName = extras.getString("chemicalName");
            Realm realm = Realm.getInstance(this);
            ChemicalModel chemical = realm
                    .where(ChemicalModel.class)
                    .equalTo("name", oldChemicalName)
                    .equalTo("lab.name", labName)
                    .findFirst();
            realm.close();

            // Get the EditText
            EditText chemicalNameEdit = (EditText) findViewById(R.id.edit_chemical_name);
            EditText chemicalCASEdit = (EditText) findViewById(R.id.edit_chemical_cas_number);
            EditText chemicalQuantityEdit = (EditText) findViewById(R.id.edit_chemical_quantity);
            EditText chemicalUnitEdit = (EditText) findViewById(R.id.edit_chemical_unit);

            // Set the EditText values
            chemicalNameEdit.setText(chemical.getName());
            chemicalCASEdit.setText(chemical.getChemicalAbstractServiceRegistryNumber());
            chemicalQuantityEdit.setText(((Integer) chemical.getQuantity()).toString());
            chemicalUnitEdit.setText(chemical.getQuantityUnit());
        } else {
            oldChemicalName = null;
            labName = extras.getString("labName");
        }
    }

    public void saveChemical(View view) {
        // Get the EditText
        EditText chemicalNameEdit = (EditText) findViewById(R.id.edit_chemical_name);
        EditText chemicalCASEdit = (EditText) findViewById(R.id.edit_chemical_cas_number);
        EditText chemicalQuantityEdit = (EditText) findViewById(R.id.edit_chemical_quantity);
        EditText chemicalUnitEdit = (EditText) findViewById(R.id.edit_chemical_unit);

        // Convert EditText to variables
        String chemicalName = chemicalNameEdit.getText().toString();
        String chemicalCAS = chemicalCASEdit.getText().toString();
        Integer chemicalQuantity = Integer.parseInt(chemicalQuantityEdit.getText().toString());
        String chemicalUnit = chemicalUnitEdit.getText().toString();

        Realm realm = Realm.getInstance(this);

        // Get the lab that this ChemicalModel is associated with
        LabModel lab = realm
                .where(LabModel.class)
                .equalTo("name", labName)
                .findFirst();

        realm.beginTransaction();
        // Remove old ChemicalModel
        if (oldChemicalName != null) {
            ChemicalModel oldChemical = realm
                    .where(ChemicalModel.class)
                   .equalTo("name", oldChemicalName)
                   .equalTo("lab.name", labName)
                   .findFirst();
            oldChemical.removeFromRealm();
        }
        // Save the new ChemicalModel
        ChemicalModel chemical = realm.createObject(ChemicalModel.class);
        chemical.setName(chemicalName);
        chemical.setChemicalAbstractServiceRegistryNumber(chemicalCAS);
        chemical.setQuantity(chemicalQuantity);
        chemical.setQuantityUnit(chemicalUnit);
        chemical.setLab(lab);

        realm.commitTransaction();
        realm.close();

        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_chemical, menu);
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
