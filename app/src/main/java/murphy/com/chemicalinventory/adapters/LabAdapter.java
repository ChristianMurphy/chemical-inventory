package murphy.com.chemicalinventory.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;
import murphy.com.chemicalinventory.models.Lab;

public class LabAdapter extends RealmBaseAdapter<Lab> implements ListAdapter {

    private static class LabViewHolder {
        TextView name;
    }

    public LabAdapter(Context context, RealmResults<Lab> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LabViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            viewHolder = new LabViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (LabViewHolder) convertView.getTag();
        }

        Lab item = realmResults.get(position);
        viewHolder.name.setText(item.getName());
        return convertView;
    }

    public RealmResults<Lab> getRealmResults() {
        return realmResults;
    }
}