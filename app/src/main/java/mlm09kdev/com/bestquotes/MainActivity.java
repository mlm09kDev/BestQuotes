package mlm09kdev.com.bestquotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mlm09kdev.com.bestquotes.Data.QuoteData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new QuoteData().getQoutes();
    }
}
