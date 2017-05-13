package company.mfa7.joshankabir.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import company.mfa7.joshankabir.R;
import company.mfa7.joshankabir.adapter.VerseListAdapter;
import company.mfa7.joshankabir.resurce.ListResource;

/**
 * Created by Mohsen on 5/13/2017.
 */

public class VerseList extends Activity {

    VerseListAdapter verses_listAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verses_list_activity);

        final ListView verses_list = (ListView) findViewById(R.id.verse_listView);

        verses_listAdapter = new VerseListAdapter(VerseList.this, ListResource.verses);
        verses_list.setAdapter(verses_listAdapter);
        verses_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, final long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),id+"",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(VerseList.this , PlayActivity.class);
                                intent.putExtra("verse_id" , id);
                                startActivity(intent);
                                verses_listAdapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });
            }

        });
    }
}
