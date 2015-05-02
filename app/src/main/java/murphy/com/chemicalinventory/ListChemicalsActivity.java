package murphy.com.chemicalinventory;

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
import murphy.com.chemicalinventory.adapters.ChemicalAdapter;
import murphy.com.chemicalinventory.models.Chemical;


public class ListChemicalsActivity extends AppCompatActivity {
    ChemicalAdapter chemicalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Realm realm = Realm.getInstance(this);
        RealmResults<Chemical> chemicals = realm.where(Chemical.class).equalTo("lab.name", getIntent().getExtras().getString("name")).findAll();

        chemicalAdapter = new ChemicalAdapter(getApplicationContext(), chemicals, true);
        setContentView(R.layout.activity_list_chemicals);
        ListView listView = (ListView) findViewById(R.id.chemical_list);

        listView.setAdapter(chemicalAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Intent editChemicalActivity = new Intent(parent.getContext(), ListChemicalsActivity.class);
                editChemicalActivity.putExtra("name", chemicalAdapter.getRealmResults().get(position).getName());
                startActivity(editChemicalActivity);
            }
        });
    }

    public void createChemical(View view) {
        Intent createLabActivity = new Intent(this, ChemicalActvity.class);
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
