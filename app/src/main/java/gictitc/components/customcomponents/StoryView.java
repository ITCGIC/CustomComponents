package gictitc.components.customcomponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;

public class StoryView extends ConstraintLayout {
    public StoryView(Context context) {//create from code
        super(context);
    }

    public StoryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }// create when inflating

    public StoryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }//create when preview
    private void init(Context context, AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.view_story,this,true);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.StoryView);
        if(typedArray != null) {
            int count = typedArray.getIndexCount();
            for(int i=0;i<count;i++){
                int attr = typedArray.getIndex(i);
                if(attr == R.styleable.StoryView_contentText) {
                    TextView textView = findViewById(R.id.textView);
                    textView.setText(typedArray.getString(i));
                }else if(attr == R.styleable.StoryView_buttonLeft){
                    Button button = findViewById(R.id.button);
                    button.setText(typedArray.getString(i));
                }else if(attr == R.styleable.StoryView_buttonRight){
                    Button button = findViewById(R.id.button2);
                    button.setText(typedArray.getString(i));
                }
            }
            typedArray.recycle();
        }
    }
}
