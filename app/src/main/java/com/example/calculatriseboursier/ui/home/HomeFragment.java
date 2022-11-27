package com.example.calculatriseboursier.ui.home;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.text.NumberFormat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.calculatriseboursier.R;



public class HomeFragment<v> extends Fragment {

    private EditText display;
    private EditText qte;
    private EditText buy;
    private EditText sell;
    private EditText profit;
    private EditText totalb;
    private EditText totala;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageButton keyboard = (ImageButton) view.findViewById(R.id.keyboard);
        TableLayout numTable = (TableLayout) view.findViewById(R.id.tableLayout);

        display = view.findViewById(R.id.input);
        display.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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

        qte = view.findViewById(R.id.qteINP);
        qte.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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

        buy = view.findViewById(R.id.buyINP);
        buy.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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

        sell = view.findViewById(R.id.sellINP);
        sell.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
                if (display.isFocused())
                    display.setText("");
                else if(qte.isFocused())
                    qte.setText("");
                else if (buy.isFocused())
                    buy.setText("");
                else if (sell.isFocused())
                    sell.setText("");
            }
        });

        ImageButton backspace = (ImageButton) view.findViewById(R.id.backspace2);
        backspace.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (display.isFocused()) {
                    int cursorPos = display.getSelectionStart();
                    int textLen = display.getText().length();

                    if (cursorPos != 0 && textLen != 0) {
                        SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                        selection.replace(cursorPos - 1, cursorPos, "");
                        display.setText(selection);
                        display.setSelection(cursorPos - 1);
                    }
                }
                else if (qte.isFocused()) {
                    int cursorPos = qte.getSelectionStart();
                    int textLen = qte.getText().length();

                    if (cursorPos != 0 && textLen != 0) {
                        SpannableStringBuilder selection = (SpannableStringBuilder) qte.getText();
                        selection.replace(cursorPos - 1, cursorPos, "");
                        qte.setText(selection);
                        qte.setSelection(cursorPos - 1);
                    }
                }
                else if (buy.isFocused()) {
                    int cursorPos = buy.getSelectionStart();
                    int textLen = buy.getText().length();

                    if (cursorPos != 0 && textLen != 0) {
                        SpannableStringBuilder selection = (SpannableStringBuilder) buy.getText();
                        selection.replace(cursorPos - 1, cursorPos, "");
                        buy.setText(selection);
                        buy.setSelection(cursorPos - 1);
                    }
                }
                else if (sell.isFocused()) {
                    int cursorPos = sell.getSelectionStart();
                    int textLen = sell.getText().length();

                    if (cursorPos != 0 && textLen != 0) {
                        SpannableStringBuilder selection = (SpannableStringBuilder) sell.getText();
                        selection.replace(cursorPos - 1, cursorPos, "");
                        sell.setText(selection);
                        sell.setSelection(cursorPos - 1);
                    }
                }
            }
        });
        Button plus = (Button) view.findViewById(R.id.plusBTN);
        plus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (display.isFocused())
                    updateText("+");
            }
        });

        Button minusBTN = (Button) view.findViewById(R.id.minusBTN);
        minusBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (display.isFocused())
                    updateText("-");
            }
        });
        Button multiBTN = (Button) view.findViewById(R.id.multiBTN);
        multiBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (display.isFocused())
                    updateText("x");
            }
        });
        Button divisionBTN = (Button) view.findViewById(R.id.divisionBTN);
        divisionBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (display.isFocused())
                    updateText("÷");
            }
        });
        Button signBTN = (Button) view.findViewById(R.id.signBTN);
        signBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (display.isFocused())
                    updateText("-");
            }
        });
        Button parantBTN = (Button) view.findViewById(R.id.parantBTN);
        parantBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (display.isFocused()) {
                    int cursorPos = display.getSelectionStart();
                    int openPar = 0;
                    int closePar = 0;
                    int textLen = display.getText().length();

                    for (int i = 0; i < cursorPos; i++) {
                        if (display.getText().toString().startsWith("(", i)) {

                            openPar += 1;
                        }
                        if (display.getText().toString().startsWith(")", i)) {

                            closePar += 1;
                        }
                    }
                    if (openPar == closePar || display.getText().toString().startsWith("(", textLen - 1)) {
                        updateText("(");
                    } else if (closePar < openPar && !display.getText().toString().startsWith("(", textLen - 1)) {
                        updateText(")");
                    }
                    display.setSelection(cursorPos + 1);
                }
            }
        });
        Button powerBTN = (Button) view.findViewById(R.id.powerBTN);
        powerBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (display.isFocused())
                    updateText("^");
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
                if (display.isFocused()) {
                    String userExp = display.getText().toString();
                    userExp = userExp.replaceAll("÷", "/");
                    userExp = userExp.replaceAll("x", "*");

                    Expression exp = new Expression(userExp);
                    String result = String.valueOf(exp.calculate());

                    display.setText(result);
                    display.setSelection(result.length());
                }
                else if ((qte.isFocused() || buy.isFocused() || sell.isFocused()) && (!qte.getText().toString().equals("") && !buy.getText().toString().equals("") && !sell.getText().toString().equals(""))){
                    int qt = Integer.parseInt(qte.getText().toString());
                    float by = Float.parseFloat(buy.getText().toString());
                    float sll = Float.parseFloat(sell.getText().toString());
                    float d_e = (float) (qt * by * 0.0099);
                    float d_s = (float) (qt * sll * 0.0099);
                    float p_e = (qt * by) + d_e;
                    float p_s = (qt * sll) - d_s;
                    float tva = (float) ((p_s - p_e) * 0.15);

                    @SuppressLint("DefaultLocale") String tb = String.format("%.2f",(qt * by));
                    totalb.setText(tb + " DH");

                    if ( p_s < p_e ){
                        float v = p_s - p_e;
                        @SuppressLint("DefaultLocale") String p = String.format("%.2f", v);
                        profit.setText(p + " DH");
                        @SuppressLint("DefaultLocale") String ta = String.format("%.2f", v + (qt*by));
                        totala.setText(ta + " DH");
                    }
                    else if (p_s > p_e){
                        float v = (p_s - p_e) - Math.abs(tva);
                        @SuppressLint("DefaultLocale") String p = String.format("%.2f", v);
                        profit.setText(p + " DH");
                        @SuppressLint("DefaultLocale") String ta = String.format("%.2f", v + (qt*by));
                        totala.setText(ta + " DH");
                    }

                }
            }
        });

        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        qte = view.findViewById(R.id.qteINP);
        qte.setShowSoftInputOnFocus(false);

        buy = view.findViewById(R.id.buyINP);
        buy.setShowSoftInputOnFocus(false);

        sell = view.findViewById(R.id.sellINP);
        sell.setShowSoftInputOnFocus(false);

        profit = view.findViewById(R.id.profitINP);
        profit.setShowSoftInputOnFocus(false);

        totalb = view.findViewById(R.id.totalb);
        totalb.setShowSoftInputOnFocus(false);

        totala = view.findViewById(R.id.totala);
        totala.setShowSoftInputOnFocus(false);

        display = view.findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);


        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (getString(R.string.display).equals(display.getText().toString()))
                    display.setText("");
            }
        });

    }


    public static class MoneyTextWatcher implements TextWatcher {
        private final WeakReference<EditText> editTextWeakReference;

        public MoneyTextWatcher(EditText editText) {
            editTextWeakReference = new WeakReference<EditText>(editText);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            EditText editText = editTextWeakReference.get();
            if (editText == null) return;
            String s = editable.toString();
            if (s.isEmpty()) return;
            editText.removeTextChangedListener(this);
            String cleanString = s.replaceAll("[H,.]", "");
            BigDecimal parsed = new BigDecimal(cleanString).setScale(2, BigDecimal.ROUND_FLOOR).divide(new BigDecimal(100), BigDecimal.ROUND_FLOOR);
            String formatted = NumberFormat.getCurrencyInstance().format(parsed);
            editText.setText(formatted);
            editText.setSelection(formatted.length());
            editText.addTextChangedListener(this);
        }
    }


    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        String oldStrqte = qte.getText().toString();
        int cursorPosqte = qte.getSelectionStart();
        String leftStrqte = oldStrqte.substring(0, cursorPosqte);
        String rightStrqte = oldStrqte.substring(cursorPosqte);

        String oldStrbuy = buy.getText().toString();
        int cursorPosbuy = buy.getSelectionStart();
        String leftStrbuy = oldStrbuy.substring(0, cursorPosbuy);
        String rightStrbuy = oldStrbuy.substring(cursorPosbuy);

        String oldStrsell = sell.getText().toString();
        int cursorPossell = sell.getSelectionStart();
        String leftStrsell = oldStrsell.substring(0, cursorPossell);
        String rightStrsell = oldStrsell.substring(cursorPossell);

        if(qte.isFocused() && getString(R.string.qte).equals(qte.getText().toString())){
            int i = 1;
            System.out.println(i);
            qte.setText(strToAdd);
            qte.setSelection(cursorPosqte + 1);
        }

        else if (qte.isFocused()){
            qte.setText(String.format("%s%s%s", leftStrqte, strToAdd, rightStrqte));
            qte.setSelection(cursorPosqte + 1);
        }

        else if(buy.isFocused() && getString(R.string.buy).equals(buy.getText().toString())){
            int i = 0;
            System.out.println(i);
            buy.setText(strToAdd);
            buy.setSelection(cursorPosbuy + 1);

        }
        else if (buy.isFocused()){
            buy.setText(String.format("%s%s%s", leftStrbuy, strToAdd, rightStrbuy));
            buy.setSelection(cursorPosbuy + 1);
        }
        else if(display.isFocused() && getString(R.string.display).equals(display.getText().toString())){
            int i = 3;
            System.out.println(i);
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else if (display.isFocused()){
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }
        else if(sell.isFocused() && getString(R.string.sell).equals(sell.getText().toString())){
            int i = 3;
            System.out.println(i);
            sell.setText(strToAdd);
            sell.setSelection(cursorPossell + 1);
        }
        else if (sell.isFocused()){
            sell.setText(String.format("%s%s%s", leftStrsell, strToAdd, rightStrsell));
            sell.setSelection(cursorPossell + 1);
        }
    }


}