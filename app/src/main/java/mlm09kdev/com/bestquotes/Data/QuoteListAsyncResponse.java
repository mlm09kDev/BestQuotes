package mlm09kdev.com.bestquotes.Data;

import java.util.ArrayList;

import mlm09kdev.com.bestquotes.Model.Quote;

/**
 * Created by Manuel Montes de Oca on 8/9/2018.
 */
public interface QuoteListAsyncResponse {
    void processFinished(ArrayList<Quote> quotes);
}
