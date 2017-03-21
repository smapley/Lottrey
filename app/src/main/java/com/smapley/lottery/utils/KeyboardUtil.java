package com.smapley.lottery.utils;

import android.app.Activity;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import com.smapley.lottery.R;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by smapley on 2017/3/19.
 */

public class KeyboardUtil {
    private KeyboardView keyboardView;
    private Keyboard k1;
    public boolean isShow = false;

    private EditText inputEditText;

    private static KeyboardUtil instance;

    public static KeyboardUtil getInstance(EditText editText){
        if(instance==null){
            instance=new KeyboardUtil();
        }
        int inputType = editText.getInputType();
        editText.setInputType(InputType.TYPE_NULL);
        editText.setInputType(inputType);
       if(instance.inputEditText!=editText){
           System.out.println("is not the edittext");
           instance.inputEditText= editText;
           Activity act = (Activity) editText.getContext();

           instance.k1 = new Keyboard(act, R.xml.custom_softkeyboard_v1);
           instance.keyboardView = (KeyboardView) act.findViewById(R.id.keyboard_view);
           instance.keyboardView.setKeyboard(instance.k1);
           instance.keyboardView.setEnabled(true);


           instance.keyboardView.setOnKeyboardActionListener(instance.listener);

           instance.setSoftKeyboradHide(act, editText);
       }
        if(!instance.isShow){
            instance.showKeyboard();
        }

        return instance;
    }



    private void setSoftKeyboradHide(Activity ctx, EditText edit) {
        ctx.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        try {
            Class<EditText> cls = EditText.class;
            Method setShowSoftInputOnFocus = null;
            String method_setSoftInputOnFocus = "setShowSoftInputOnFocus";
            if (android.os.Build.VERSION.SDK_INT > 16) {
                method_setSoftInputOnFocus = "setSoftInputOnFocus";
            }
            setShowSoftInputOnFocus = cls.getMethod(method_setSoftInputOnFocus, boolean.class);
            setShowSoftInputOnFocus.setAccessible(false);
            setShowSoftInputOnFocus.invoke(edit, false);
        } catch (Exception e) {
        }
    }

    private OnKeyboardActionListener listener = new OnKeyboardActionListener() {
        @Override
        public void swipeUp() {
        }

        @Override
        public void swipeRight() {
        }

        @Override
        public void swipeLeft() {
        }

        @Override
        public void swipeDown() {
        }

        @Override
        public void onText(CharSequence text) {
        }

        @Override
        public void onRelease(int primaryCode) {
        }

        @Override
        public void onPress(int primaryCode) {
            checkIShowPrewiew(primaryCode);
        }

        private void checkIShowPrewiew(int primaryCode) {
            List<Integer> list = Arrays.asList(Keyboard.KEYCODE_CANCEL, Keyboard.KEYCODE_DELETE, Keyboard.KEYCODE_SHIFT, 46, 32, 44);
            if (list.contains(primaryCode)) {
                keyboardView.setPreviewEnabled(false);
            } else {
                keyboardView.setPreviewEnabled(true);
            }
        }

        @Override
        public void onKey(int primaryCode, int[] keyCodes) {
            checkIShowPrewiew(primaryCode);
            Log.i("KeyBoard", "primaryCode=" + primaryCode);

            Editable editable = inputEditText.getText();
            int start = inputEditText.getSelectionStart();
            if (primaryCode == Keyboard.KEYCODE_CANCEL) {// 完成
                hideKeyboard();
            } else if (primaryCode == Keyboard.KEYCODE_DELETE) {// 回退
                if (editable != null && editable.length() > 0) {
                    if (start > 0) {
                        editable.delete(start - 1, start);
                    }
                }
            } else {
                editable.insert(start, Character.toString((char) primaryCode));
            }
        }
    };



    public void showKeyboard() {
        int visibility = keyboardView.getVisibility();
        if (visibility == View.GONE || visibility == View.INVISIBLE) {
            keyboardView.setVisibility(View.VISIBLE);
            isShow = true;
        }
    }

    public void hideKeyboard() {
        int visibility = keyboardView.getVisibility();
        if (visibility == View.VISIBLE) {
            keyboardView.setVisibility(View.GONE);
            isShow = false;
        }
    }


}