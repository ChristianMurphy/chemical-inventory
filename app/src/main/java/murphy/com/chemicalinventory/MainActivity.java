package murphy.com.chemicalinventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;
import murphy.com.chemicalinventory.adapters.LabAdapter;
import murphy.com.chemicalinventory.models.Lab;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Realm realm = Realm.getInstance(this);

//        realm.beginTransaction();
//
//        Lab lab = realm.createObject(Lab.class); // Create a new object
//        lab.setName("John");
//
//
//        realm.commitTransaction();


        RealmResults<Lab> labs = realm.where(Lab.class).findAll();

        LabAdapter adapter = new LabAdapter(getApplicationContext(), labs, false);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.lab_list);

        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
