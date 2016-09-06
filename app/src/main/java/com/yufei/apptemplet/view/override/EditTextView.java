package com.yufei.apptemplet.view.override;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import com.yufei.apptemplet.R;

/**
 * Created by wangyufei on 16/9/6.
 */
public class EditTextView extends EditText {

    private Drawable clearBtn;

    public EditTextView(Context context, AttributeSet attrs) {

        /**
         * this constructor method is very important
         * a lot of this attribute can not be defined inside XML without it
         */
        this(context, attrs, android.R.attr.editTextStyle);
    }

    public EditTextView(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);

        init();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (getCompoundDrawables()[2] == null)
            return super.onTouchEvent(event);

        //determine whether the click the clear button
        boolean touchable = event.getX() > (getWidth() - getTotalPaddingRight()) && (event.getX() < ((getWidth() - getPaddingRight())));

        //handle touch down
        touchDown(event, touchable);
        //handle touch up
        touchUp(event, touchable);

        return super.onTouchEvent(event);
    }

    private void touchDown(MotionEvent event, boolean touchable) {

        if (event.getAction() != MotionEvent.ACTION_DOWN)
            return;

        if (!touchable)
            return;

        clearBtn = getResources().getDrawable(R.drawable.edit_view_clear_press_icon);
        clearBtn.setBounds(0, 0, clearBtn.getIntrinsicWidth(), clearBtn.getIntrinsicHeight());

        setClearIconVisible(true);
    }

    private void touchUp(MotionEvent event, boolean touchable) {

        if(event.getAction() != MotionEvent.ACTION_UP)
            return;

        clearBtn = getResources().getDrawable(R.drawable.edit_view_clear_icon);
        clearBtn.setBounds(0, 0, clearBtn.getIntrinsicWidth(), clearBtn.getIntrinsicHeight());

        if (this.getText() != null && !this.getText().equals("")) {

            setClearIconVisible(true);
        } else {

            setClearIconVisible(false);
        }

        if (touchable)
            this.setText("");
    }

    private void init() {

        //get drawableRight of editText, if null, set the default image
        clearBtn = getCompoundDrawables()[2];

        if (clearBtn == null)
            clearBtn = getResources().getDrawable(R.drawable.edit_view_clear_icon);

        clearBtn.setBounds(0, 0, clearBtn.getIntrinsicWidth(), clearBtn.getIntrinsicHeight());

        //hide icon by default
        setClearIconVisible(false);
        //set the input listener to monitor content changes
        addTextChangedListener(textWatcher);
    }

    private void setClearIconVisible(boolean visible) {

        Drawable right = visible ? clearBtn : null;

        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], right, getCompoundDrawables()[3]);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            setClearIconVisible(charSequence.length() > 0);
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
