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


public class EditChemicalActvity extends AppCompatActivity {
    String labName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        setContentView(R.layout.activity_edit_chemical);
        if (extras.containsKey("labName")) {
            labName = extras.getString("labName");
        } else {
            // TODO Edit chemical
        }
    }

    public void saveChemical(View view) {
        EditText chemicalNameEdit = (EditText) findViewById(R.id.edit_chemical_name);
        EditText chemicalCASEdit = (EditText) findViewById(R.id.edit_chemical_cas_number);
        EditText chemicalQuantityEdit = (EditText) findViewById(R.id.edit_chemical_quantity);
        EditText chemicalUnitEdit = (EditText) findViewById(R.id.edit_chemical_unit);

        String chemicalName = chemicalNameEdit.getText().toString();
        String chemicalCAS = chemicalCASEdit.getText().toString();
        Integer chemicalQuantity = Integer.parseInt(chemicalQuantityEdit.getText().toString());
        String chemicalUnit = chemicalUnitEdit.getText().toString();

        Realm realm = Realm.getInstance(this);

        LabModel lab = realm.where(LabModel.class).equalTo("name", labName).findFirst();

        realm.beginTransaction();
        ChemicalModel chemical = realm.createObject(ChemicalModel.class); // Create a new object
        chemical.setName(chemicalName);
        chemical.setChemicalAbstractServiceRegistryNumber(chemicalCAS);
        chemical.setQuantity(chemicalQuantity);
        chemical.setQuantityUnit(chemicalUnit);
        chemical.setLab(lab);
        realm.commitTransaction();

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
