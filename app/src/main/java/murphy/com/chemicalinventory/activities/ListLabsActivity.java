package murphy.com.chemicalinventory.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;
import murphy.com.chemicalinventory.R;
import murphy.com.chemicalinventory.adapters.LabListAdapter;
import murphy.com.chemicalinventory.models.LabModel;


public class ListLabsActivity extends AppCompatActivity {
    LabListAdapter labListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Realm realm = Realm.getInstance(this);
        RealmResults<LabModel> labs = realm.where(LabModel.class).findAll();

        labListAdapter = new LabListAdapter(getApplicationContext(), labs, true);
        setContentView(R.layout.activity_list_labs);
        ListView listView = (ListView) findViewById(R.id.lab_list);

        listView.setAdapter(labListAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Intent listChemicalsActivity = new Intent(parent.getContext(), ListChemicalsActivity.class);
                listChemicalsActivity.putExtra("name", labListAdapter.getRealmResults().get(position).getName());
                startActivity(listChemicalsActivity);
            }
        });
    }

    public void createLab(View view) {
        Intent createLabActivity = new Intent(this, EditLabActivity.class);
        startActivity(createLabActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_labs, menu);
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
