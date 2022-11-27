package com.example.calculatriseboursier.ui.slideshow;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculatriseboursier.R;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private EditText premierC;
    private EditText secondC;
    private EditText premierQ;
    private EditText secondQ;
    private EditText courP;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);
        ImageButton keyboard = (ImageButton) view.findViewById(R.id.keyboard4);
        TableLayout numTable = (TableLayout) view.findViewById(R.id.tableLayout);

        premierC = view.findViewById(R.id.premierC);
        premierC.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    keyboard.setImageResource(R.drawable.ic_keyboard_hide);
                    numTable.setVisibility(View.VISIBLE);
                } else {
                    keyboard.setImageResource(R.drawable.ic_keyboard);
                    numTable.setVisibility(View.GONE);
                }
            }
        });

        secondC = view.findViewById(R.id.secondC);
        secondC.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    keyboard.setImageResource(R.drawable.ic_keyboard_hide);
                    numTable.setVisibility(View.VISIBLE);
                } else {
                    keyboard.setImageResource(R.drawable.ic_keyboard);
                    numTable.setVisibility(View.GONE);
                }
            }
        });

        premierQ = view.findViewById(R.id.premierQ);
        premierQ.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    keyboard.setImageResource(R.drawable.ic_keyboard_hide);
                    numTable.setVisibility(View.VISIBLE);
                } else {
                    keyboard.setImageResource(R.drawable.ic_keyboard);
                    numTable.setVisibility(View.GONE);
                }
            }
        });

        secondQ = view.findViewById(R.id.secondQ);
        secondQ.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    keyboard.setImageResource(R.drawable.ic_keyboard_hide);
                    numTable.setVisibility(View.VISIBLE);
                } else {
                    keyboard.setImageResource(R.drawable.ic_keyboard);
                    numTable.setVisibility(View.GONE);
                }
            }
        });

        keyboard.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(numTable.getVisibility() == View.GONE){
                    keyboard.setImageResource(R.drawable.ic_keyboard_hide);
                    numTable.setVisibility(View.VISIBLE);
                }
                else{
                    keyboard.setImageResource(R.drawable.ic_keyboard);
                    numTable.setVisibility(View.GONE);
                }
            }
        });

        Button button0 = (Button) view.findViewById(R.id.zeroBTN);
        button0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateText("0");
            }
        });

        Button button1 = (Button) view.findViewById(R.id.oneBTN);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateText("1");
            }
        });

        Button button2 = (Button) view.findViewById(R.id.twoBTN);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateText("2");
            }
        });

        Button button3 = (Button) view.findViewById(R.id.threeBTN);
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateText("3");
            }
        });

        Button button4 = (Button) view.findViewById(R.id.fourBTN);
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateText("4");
            }
        });

        Button button5 = (Button) view.findViewById(R.id.fiveBTN);
        button5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateText("5");
            }
        });

        Button button6 = (Button) view.findViewById(R.id.sixBTN);
        button6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateText("6");
            }
        });

        Button button7 = (Button) view.findViewById(R.id.sevenBTN);
        button7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateText("7");
            }
        });

        Button button8 = (Button) view.findViewById(R.id.eightBTN);
        button8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateText("8");
            }
        });

        Button button9 = (Button) view.findViewById(R.id.nineBTN);
        button9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateText("9");
            }
        });

        Button clearBTN = (Button) view.findViewById(R.id.clearBTN);
        clearBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (premierC.isFocused())
                    premierC.setText("");
                else if(secondC.isFocused())
                    secondC.setText("");
                else if(premierQ.isFocused())
                    premierQ.setText("");
                else if(secondQ.isFocused())
                    secondQ.setText("");
            }
        });

        ImageButton backspace = (ImageButton) view.findViewById(R.id.backspace4);
        backspace.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (premierC.isFocused()) {
                    int cursorPos = premierC.getSelectionStart();
                    int textLen = premierC.getText().length();

                    if (cursorPos != 0 && textLen != 0) {
                        SpannableStringBuilder selection = (SpannableStringBuilder) premierC.getText();
                        selection.replace(cursorPos - 1, cursorPos, "");
                        premierC.setText(selection);
                        premierC.setSelection(cursorPos - 1);
                    }
                }
                else if (secondC.isFocused()) {
                    int cursorPos = secondC.getSelectionStart();
                    int textLen = secondC.getText().length();

                    if (cursorPos != 0 && textLen != 0) {
                        SpannableStringBuilder selection = (SpannableStringBuilder) secondC.getText();
                        selection.replace(cursorPos - 1, cursorPos, "");
                        secondC.setText(selection);
                        secondC.setSelection(cursorPos - 1);
                    }
                }
                else if (premierQ.isFocused()) {
                    int cursorPos = premierQ.getSelectionStart();
                    int textLen = premierQ.getText().length();

                    if (cursorPos != 0 && textLen != 0) {
                        SpannableStringBuilder selection = (SpannableStringBuilder) premierQ.getText();
                        selection.replace(cursorPos - 1, cursorPos, "");
                        premierQ.setText(selection);
                        premierQ.setSelection(cursorPos - 1);
                    }
                }
                else if (secondQ.isFocused()) {
                    int cursorPos = secondQ.getSelectionStart();
                    int textLen = secondQ.getText().length();

                    if (cursorPos != 0 && textLen != 0) {
                        SpannableStringBuilder selection = (SpannableStringBuilder) secondQ.getText();
                        selection.replace(cursorPos - 1, cursorPos, "");
                        secondQ.setText(selection);
                        secondQ.setSelection(cursorPos - 1);
                    }
                }

            }
        });

        Button signBTN = (Button) view.findViewById(R.id.signBTN);
        signBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateText("-");
            }
        });

        Button commaBTN = (Button) view.findViewById(R.id.commaBTN);
        commaBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateText(".");
            }
        });

        Button equalBTN = (Button) view.findViewById(R.id.equalBTN);
        equalBTN.setOnClickListener(new View.OnClickListener()
        {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view)
            {



                if(!premierC.getText().toString().equals("") && !secondC.getText().toString().equals("") && !premierQ.getText().toString().equals("") && !secondQ.getText().toString().equals("")) {
                    float preC = Float.parseFloat(premierC.getText().toString());
                    float secC = Float.parseFloat(secondC.getText().toString());

                    float preQ = Float.parseFloat(premierQ.getText().toString());
                    float secQ = Float.parseFloat(secondQ.getText().toString());

                    float courPond = ((preQ*preC)+(secQ*secC))/(preQ+secQ);
                    @SuppressLint("DefaultLocale") String pb = String.format("%.2f", courPond);
                    courP.setText(pb);

                }


            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        premierC = view.findViewById(R.id.premierC);
        premierC.setShowSoftInputOnFocus(false);

        secondC = view.findViewById(R.id.secondC);
        secondC.setShowSoftInputOnFocus(false);

        premierQ = view.findViewById(R.id.premierQ);
        premierQ.setShowSoftInputOnFocus(false);

        secondQ = view.findViewById(R.id.secondQ);
        secondQ.setShowSoftInputOnFocus(false);

        courP = view.findViewById(R.id.courP);
        courP.setShowSoftInputOnFocus(false);




    }
    private void updateText(String strToAdd){
        String oldStr = premierC.getText().toString();
        int cursorPos = premierC.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        String oldStrqte = secondC.getText().toString();
        int cursorPosqte = secondC.getSelectionStart();
        String leftStrqte = oldStrqte.substring(0, cursorPosqte);
        String rightStrqte = oldStrqte.substring(cursorPosqte);

        String oldStrPreQ = premierQ.getText().toString();
        int cursorPosPreQ = premierQ.getSelectionStart();
        String leftStrPreQ = oldStrPreQ.substring(0, cursorPosPreQ);
        String rightStrPreQ = oldStrPreQ.substring(cursorPosPreQ);

        String oldStrSecQ = secondQ.getText().toString();
        int cursorPosSecQ = secondQ.getSelectionStart();
        String leftStrSecQ = oldStrSecQ.substring(0, cursorPosSecQ);
        String rightStrSecQ = oldStrSecQ.substring(cursorPosSecQ);


        if(premierC.isFocused() && getString(R.string.premierPrix).equals(premierC.getText().toString())){
            premierC.setText(strToAdd);
            premierC.setSelection(cursorPos + 1);
        }

        else if (premierC.isFocused()){
            premierC.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            premierC.setSelection(cursorPos + 1);
        }

        else if(secondC.isFocused() && getString(R.string.secondPrix).equals(secondC.getText().toString())){
            secondC.setText(strToAdd);
            secondC.setSelection(cursorPosqte + 1);

        }
        else if (secondC.isFocused()){
            secondC.setText(String.format("%s%s%s", leftStrqte, strToAdd, rightStrqte));
            secondC.setSelection(cursorPosqte + 1);
        }

        else if(premierQ.isFocused() && getString(R.string.premierQte).equals(premierQ.getText().toString())){
            premierQ.setText(strToAdd);
            premierQ.setSelection(cursorPosPreQ + 1);

        }
        else if (premierQ.isFocused()){
            premierQ.setText(String.format("%s%s%s", leftStrPreQ, strToAdd, rightStrPreQ));
            premierQ.setSelection(cursorPosPreQ + 1);
        }

        else if(secondQ.isFocused() && getString(R.string.secondQte).equals(secondQ.getText().toString())){
            secondQ.setText(strToAdd);
            secondQ.setSelection(cursorPosSecQ + 1);

        }
        else if (secondQ.isFocused()){
            secondQ.setText(String.format("%s%s%s", leftStrSecQ, strToAdd, rightStrSecQ));
            secondQ.setSelection(cursorPosSecQ + 1);
        }

    }
}