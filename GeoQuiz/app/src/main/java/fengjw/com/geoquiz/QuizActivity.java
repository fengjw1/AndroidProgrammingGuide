package fengjw.com.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private Button mCheatButton;

    private static final int REQUEST_CODE_CHEAT = 0;

    private boolean mIsCheater;

    private Question[] mQuestions = new Question[]{
            new Question(R.string.question_africa,true),
            new Question(R.string.question_americas,false),
            new Question(R.string.question_mideast,true),
            new Question(R.string.question_oceans,false)

    };

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mNextButton = (Button) findViewById(R.id.next_button);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view) ;
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestions.length; //这里相当于每次加一操作,
                mIsCheater = false;
                updateQuestion();
            }
        });

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                checkAnswer(true);
            }
        });
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast toast = Toast.makeText(QuizActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.TOP,0,0);
//                toast.show();
                checkAnswer(false);
            }
        });
        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start     CheatActivity
                //updateQuestion();
//                Intent intent = new Intent(QuizActivity.this, CheatActivity.class);
//                startActivity(intent);
                boolean answerIsTrue = mQuestions[mCurrentIndex].isAnswerTrue();
                Intent intent = CheatActivity.newIntent(QuizActivity.this, answerIsTrue);
                startActivityForResult(intent, REQUEST_CODE_CHEAT);
            }
        });


    }

    private void updateQuestion(){
        int question = mQuestions[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestions[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;

        if (mIsCheater){
            messageResId = R.string.judgment_toast;
        }else {
            if (userPressedTrue == answerIsTrue){
                messageResId = R.string.correct_toast;
            }else {
                messageResId = R.string.incorrect_toast;
            }
        }

//        if (userPressedTrue == answerIsTrue){
//            messageResId = R.string.correct_toast;
//        }else {
//            messageResId = R.string.incorrect_toast;
//        }
        Toast.makeText(QuizActivity.this,messageResId,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK){
            return;
        }
        if (requestCode == REQUEST_CODE_CHEAT){
            if (data == null){
                return;
            }
            mIsCheater = CheatActivity.wasAnswerShown(data);
        }
    }
}
