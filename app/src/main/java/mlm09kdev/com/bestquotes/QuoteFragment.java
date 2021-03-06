package mlm09kdev.com.bestquotes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {


    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View quoteView = inflater.inflate(R.layout.fragment_quote, container, false);
        TextView quoteText = quoteView.findViewById(R.id.quoteTextView);
        TextView authorText = quoteView.findViewById(R.id.authorTextView);
        CardView cardView = quoteView.findViewById(R.id.cardView);

        String quote = getArguments().getString("quote");
        String author = getArguments().getString("author");


        int colors[] = new int[] {R.color.blue_500, R.color.pink_900, R.color.green_400,
                R.color.lime_400, R.color.orange_400, R.color.amber_800, R.color.pink_800,
                R.color.grey_700, R.color.blue_grey_800, R.color.amber_100, R.color.cyan_A400, R.color.dark_purple_A400};

        quoteText.setText(quote);
        authorText.setText("-" + author);
        cardView.setBackgroundResource(getRandomQuote(colors));


        return quoteView;
    }

    public static final QuoteFragment newInstance(String quote, String author) {
        QuoteFragment fragment = new QuoteFragment();

        Bundle bundle = new Bundle();
        bundle.putString("quote", quote);
        bundle.putString("author", author);
        fragment.setArguments(bundle);

        return fragment;

    }

    int getRandomQuote(int[] colorArray) {
        int color;
        int quotesArrayLength = colorArray.length;

        int randomNum = ThreadLocalRandom.current().nextInt(quotesArrayLength);
        color = colorArray[randomNum];
        return color;
    }

}
