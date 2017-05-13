package company.mfa7.joshankabir.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import company.mfa7.joshankabir.R;
import company.mfa7.joshankabir.resurce.ListResource;

/**
 * Created by Mohsen on 5/13/2017.
 */

public class PlayActivity extends Activity {
    TextView arabic_txt ;
    TextView persian_txt ;
    Button next_verse_btn;
    Button previous_verse_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);

        arabic_txt = (TextView) findViewById(R.id.arabic_txt);
        persian_txt = (TextView) findViewById(R.id.persian_txt);
        next_verse_btn = (Button) findViewById(R.id.next_verse_btn);
        previous_verse_btn = (Button) findViewById(R.id.previous_verse_btn);

        Intent intent = getIntent();
        final long[] id = {intent.getLongExtra("verse_id", 0)};

        setNewVerse(id);

        next_verse_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id[0]++;
                setNewVerse(id);
            }
        });

        previous_verse_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id[0]--;
                setNewVerse(id);
            }
        });

    }

    public void setNewVerse(long[] id){
        if (id[0]==0)
            previous_verse_btn.setVisibility(View.INVISIBLE);
        else if (id[0]==100)
            next_verse_btn.setVisibility(View.INVISIBLE);
        else{
            next_verse_btn.setVisibility(View.VISIBLE);
            previous_verse_btn.setVisibility(View.VISIBLE);
        }
        arabic_txt.setText(ListResource.arabic_txt[(int) id[0]]);
        persian_txt.setText(ListResource.persian_txt[(int) id[0]]);
    }
}
