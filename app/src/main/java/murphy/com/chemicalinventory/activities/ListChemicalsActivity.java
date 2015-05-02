package murphy.com.chemicalinventory.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;
import murphy.com.chemicalinventory.R;
import murphy.com.chemicalinventory.adapters.ChemicalListAdapter;
import murphy.com.chemicalinventory.models.ChemicalModel;


public class ListChemicalsActivity extends AppCompatActivity {
    String labName;
    ChemicalListAdapter chemicalListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        labName = getIntent().getExtras().getString("name");

        Realm realm = Realm.getInstance(this);
        RealmResults<ChemicalModel> chemicals = realm
                .where(ChemicalModel.class)
                .equalTo("lab.name", labName)
                .findAll();

        chemicalListAdapter = new ChemicalListAdapter(getApplicationContext(), chemicals, true);
        setContentView(R.layout.activity_list_chemicals);
        ListView listView = (ListView) findViewById(R.id.chemical_list);

        listView.setAdapter(chemicalListAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Intent editChemicalActivity = new Intent(parent.getContext(), EditChemicalActvity.class);
                editChemicalActivity.putExtra("chemicalName", chemicalListAdapter.getRealmResults().get(position).getName());
                editChemicalActivity.putExtra("labName", labName);
                startActivity(editChemicalActivity);
            }
        });
    }

    public void createChemical(View view) {
        Intent createLabActivity = new Intent(this, EditChemicalActvity.class);
        createLabActivity.putExtra("labName", labName);
        startActivity(createLabActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_chemicals, menu);
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
