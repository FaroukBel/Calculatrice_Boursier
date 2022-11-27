package com.example.calculatriseboursier.ui.gallery;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculatriseboursier.R;

public class MinMaxPourcentage extends Fragment {

    private GalleryViewModel galleryViewModel;
    private EditText cour;
    private EditText perc;
    private EditText plushaut;
    private EditText plusbas;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        ImageButton keyboard = (ImageButton) view.findViewById(R.id.keyboard2);
        TableLayout numTable = (TableLayout) view.findViewById(R.id.tableLayout);

        cour = view.findViewById(R.id.cour);
        cour.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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

        perc = view.findViewById(R.id.perc);
        perc.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
                if (cour.isFocused())
                    cour.setText("");
                else if(perc.isFocused())
                    perc.setText("");
            }
        });

        ImageButton backspace = (ImageButton) view.findViewById(R.id.backspace);
        backspace.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (cour.isFocused()) {
                    int cursorPos = cour.getSelectionStart();
                    int textLen = cour.getText().length();

                    if (cursorPos != 0 && textLen != 0) {
                        SpannableStringBuilder selection = (SpannableStringBuilder) cour.getText();
                        selection.replace(cursorPos - 1, cursorPos, "");
                        cour.setText(selection);
                        cour.setSelection(cursorPos - 1);
                    }
                }
                else if (perc.isFocused()) {
                    int cursorPos = perc.getSelectionStart();
                    int textLen = perc.getText().length();

                    if (cursorPos != 0 && textLen != 0) {
                        SpannableStringBuilder selection = (SpannableStringBuilder) perc.getText();
                        selection.replace(cursorPos - 1, cursorPos, "");
                        perc.setText(selection);
                        perc.setSelection(cursorPos - 1);
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



                if(!cour.getText().toString().equals("") && !perc.getText().toString().equals("")) {
                    float c = Float.parseFloat(cour.getText().toString());
                    float p = Float.parseFloat(perc.getText().toString());

                    float plusb = c - ((c*p)/100);
                    float plush = c + ((c*p)/100);
                    @SuppressLint("DefaultLocale") String pb = String.format("%.2f", plusb);
                    plusbas.setText(pb);
                    @SuppressLint("DefaultLocale") String ph = String.format("%.2f", plush);
                    plushaut.setText(ph);
                }


            }
        });


        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cour = view.findViewById(R.id.cour);
        cour.setShowSoftInputOnFocus(false);

        perc = view.findViewById(R.id.perc);
        perc.setShowSoftInputOnFocus(false);
        plushaut = view.findViewById(R.id.plushaut);
        plushaut.setShowSoftInputOnFocus(false);

        plusbas = view.findViewById(R.id.plusbas);
        plusbas.setShowSoftInputOnFocus(false);


    }
    private void updateText(String strToAdd){
        String oldStr = cour.getText().toString();
        int cursorPos = cour.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        String oldStrqte = perc.getText().toString();
        int cursorPosqte = perc.getSelectionStart();
        String leftStrqte = oldStrqte.substring(0, cursorPosqte);
        String rightStrqte = oldStrqte.substring(cursorPosqte);


        if(cour.isFocused() && getString(R.string.prix).equals(cour.getText().toString())){
            cour.setText(strToAdd);
            cour.setSelection(cursorPos + 1);
        }

        else if (cour.isFocused()){
            cour.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            cour.setSelection(cursorPos + 1);
        }

        else if(perc.isFocused() && getString(R.string.pourcentage).equals(perc.getText().toString())){
            perc.setText(strToAdd);
            perc.setSelection(cursorPosqte + 1);

        }
        else if (perc.isFocused()){
            perc.setText(String.format("%s%s%s", leftStrqte, strToAdd, rightStrqte));
            perc.setSelection(cursorPosqte + 1);
        }

    }
}