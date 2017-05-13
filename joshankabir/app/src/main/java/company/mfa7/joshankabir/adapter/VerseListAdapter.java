package company.mfa7.joshankabir.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import company.mfa7.joshankabir.R;

/**
 * Created by Mohsen on 5/13/2017.
 */

public class VerseListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public VerseListAdapter(Context context, String[] values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.verse_num_txt);
        textView.setText(values[position]);
        // change the icon for Windows and iPhone
        String s = values[position];


        return rowView;
    }
}
