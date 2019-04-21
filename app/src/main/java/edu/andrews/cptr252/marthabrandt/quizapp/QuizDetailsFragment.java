package edu.andrews.cptr252.marthabrandt.quizapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuizDetailsFragment extends Fragment {

    /** Tag for logging fragment messages */
    public static final String TAG = "BugDetailsFragment";
    /** Bug that is begin viewed/edited */
    private quiz mQuiz;
    /** Reference to title field for bug*/
    private EditText mTitleField;


    public QuizDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mQuiz = new quiz(); // create new bug
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_quiz_details, container, false);
        // get reference to EditText box for bug title
        mTitleField = v.findViewById(R.id.question_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // left intentionally blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // user typed text, update the bug title
                mQuiz.setTitle(s.toString());
                // write the new title to the message log for debugging
                Log.d(TAG, "Title changed to " + mQuiz.getTitle());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // left intentionally blank
            }
        });
        return v;

    }

}
