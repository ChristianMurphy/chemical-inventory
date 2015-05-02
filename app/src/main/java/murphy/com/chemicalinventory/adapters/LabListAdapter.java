package murphy.com.chemicalinventory.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;
import murphy.com.chemicalinventory.models.LabModel;

/**
 * LabListAdapter
 * @author Christian Murphy
 * @version March 1, 2015
 * License: MIT http://opensource.org/licenses/MIT
 */
public class LabListAdapter extends RealmBaseAdapter<LabModel> implements ListAdapter {

    private static class LabViewHolder {
        TextView name;
        TextView location;
    }

    public LabListAdapter(Context context, RealmResults<LabModel> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LabViewHolder viewHolder;
        if (convertView == null) {
            // Create Item and Holder
            convertView = inflater.inflate(android.R.layout.simple_list_item_2, parent, false);
            viewHolder = new LabViewHolder();

            // Attach TextAreas to Holder
            viewHolder.name = (TextView) convertView.findViewById(android.R.id.text1);
            viewHolder.location = (TextView) convertView.findViewById(android.R.id.text2);

            // Set TextArea color
            viewHolder.name.setTextColor(Color.BLACK);
            viewHolder.location.setTextColor(Color.BLACK);

            // Tag TextArea for retrieval later
            convertView.setTag(viewHolder);
        } else {
            // Retrieve Holder information from Tag
            viewHolder = (LabViewHolder) convertView.getTag();
        }

        // Get the LabModel
        LabModel item = realmResults.get(position);

        // Set the Holder TextAreas values
        viewHolder.name.setText(item.getName());
        viewHolder.location.setText(item.getLocation());

        return convertView;
    }

    public RealmResults<LabModel> getRealmResults() {
        return realmResults;
    }
}