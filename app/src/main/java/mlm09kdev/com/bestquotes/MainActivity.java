package mlm09kdev.com.bestquotes;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import mlm09kdev.com.bestquotes.Data.QuoteData;
import mlm09kdev.com.bestquotes.Data.QuoteListAsyncResponse;
import mlm09kdev.com.bestquotes.Data.QuoteViewPagerAdapter;
import mlm09kdev.com.bestquotes.Model.Quote;


/**
 * Created by Manuel Montes de Oca on 8/8/2018.
 */
public class MainActivity extends AppCompatActivity {

    private QuoteViewPagerAdapter quoteViewPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteViewPagerAdapter = new QuoteViewPagerAdapter(getSupportFragmentManager(), getFragments());
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(quoteViewPagerAdapter);

    }

    private List<Fragment> getFragments() {
      final  List<Fragment> fragmentList = new ArrayList<>();

        new QuoteData().getQuotes(new QuoteListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Quote> quotes) {
                for (int i = 0; i < quotes.size(); i++) {
                    QuoteFragment quoteFragment = QuoteFragment.newInstance(quotes.get(i).getQuote(), quotes.get(i).getAuthor());
                    fragmentList.add(quoteFragment);
                }
                quoteViewPagerAdapter.notifyDataSetChanged();
            }
        });


        return fragmentList;
    }
}
