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
 * Created by eric on 2017/3/19.
 * 键盘
 */

public class KeyboardUtil {
    private KeyboardView keyboardView;
    private EditText editText;
    public boolean isShow = false;

    public KeyboardUtil(Activity context){
        Keyboard keyboard = new Keyboard(context, R.xml.custom_softkeyboard_v1);
        keyboardView = (KeyboardView) context.findViewById(R.id.keyboard_view);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setEnabled(true);
        keyboardView.setPreviewEnabled(false);
        keyboardView.setOnKeyboardActionListener(new OnKeyboardActionListener() {
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
            }


            @Override
            public void onKey(int primaryCode, int[] keyCodes) {
                Log.i("KeyBoard", "primaryCode=" + primaryCode);

                Editable editable = editText.getText();
                int start = editText.getSelectionStart();
                if (primaryCode == Keyboard.KEYCODE_CANCEL) {// 完成
                    hide();
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
        });
    }

    public KeyboardUtil setEditText(EditText editText){
        this.editText = editText;
        int inputType = editText.getInputType();
        editText.setInputType(InputType.TYPE_NULL);
        editText.setInputType(inputType);
        this.setSoftKeyboradHide((Activity) editText.getContext(), editText);
        return this;
    }


    private void setSoftKeyboradHide(Activity ctx, EditText edit) {
        ctx.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        try {
            Class<EditText> cls = EditText.class;
            String method_setSoftInputOnFocus = "setShowSoftInputOnFocus";
            if (android.os.Build.VERSION.SDK_INT > 16) {
                method_setSoftInputOnFocus = "setSoftInputOnFocus";
            }
            Method setShowSoftInputOnFocus = cls.getMethod(method_setSoftInputOnFocus, boolean.class);
            setShowSoftInputOnFocus.setAccessible(false);
            setShowSoftInputOnFocus.invoke(edit, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public void show() {
        int visibility = keyboardView.getVisibility();
        if (visibility == View.GONE || visibility == View.INVISIBLE) {
            keyboardView.setVisibility(View.VISIBLE);
            isShow = true;
        }
    }

    public void hide() {
        int visibility = keyboardView.getVisibility();
        if (visibility == View.VISIBLE) {
            keyboardView.setVisibility(View.GONE);
            isShow = false;
        }
    }


}