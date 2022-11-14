package com.example.boursecalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private EditText qte;
    private EditText buy;
    private EditText sell;
    private EditText profit;
    private EditText totalb;
    private EditText totala;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qte = findViewById(R.id.qteINP);
        qte.setShowSoftInputOnFocus(false);

        buy = findViewById(R.id.buyINP);
        buy.setShowSoftInputOnFocus(false);

        sell = findViewById(R.id.sellINP);
        sell.setShowSoftInputOnFocus(false);

        profit = findViewById(R.id.profitINP);
        profit.setShowSoftInputOnFocus(false);

        totalb = findViewById(R.id.totalb);
        totalb.setShowSoftInputOnFocus(false);

        totala = findViewById(R.id.totala);
        totala.setShowSoftInputOnFocus(false);

        display = findViewById(R.id.input);
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
            BigDecimal parsed = new BigDecimal(cleanString).setScale(2, RoundingMode.FLOOR).divide(new BigDecimal(100), RoundingMode.FLOOR);
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


    public void zeroBTN(View view) {
        updateText("0");
    }
    public void oneBTN(View view) {
        updateText("1");
    }

    public void twoBTN(View view) {
        updateText("2");
    }

    public void threeBTN(View view) {
        updateText("3");
    }
    public void fourBTN(View view) {
        updateText("4");
    }

    public void fiveBTN(View view) {
        updateText("5");
    }

    public void sixBTN(View view) {
        updateText("6");
    }

    public void sevenBTN(View view) {
        updateText("7");
    }

    public void eightBTN(View view) {
        updateText("8");
    }
    public void nineBTN(View view) {
        updateText("9");

    }
    public void clearBTN(View view) {
        if (display.isFocused())
        display.setText("");
        else if(qte.isFocused())
            qte.setText("");
        else if (buy.isFocused())
            buy.setText("");
        else if (sell.isFocused())
            sell.setText("");
    }

    public void backspaceBTN(View view) {
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

    public void plusBTN(View view) {
        if (display.isFocused())
            updateText("+");

    }

    public void minusBTN(View view) {
        if (display.isFocused())
            updateText("-");

    }

    public void multiBTN(View view) {
        if (display.isFocused())
            updateText("x");

    }

    public void divisionBTN(View view) {
        if (display.isFocused())
            updateText("÷");

    }

    public void signBTN(View view) {
        if (display.isFocused())
            updateText("-");
    }

    public void parantBTN(View view) {
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

    public void powBTN(View view) {
        if (display.isFocused())
            updateText("^");
    }

    @SuppressLint("SuspiciousIndentation")
    public void commaBTN(View view) {
        if (display.isFocused() || buy.isFocused() || sell.isFocused())
        updateText(".");
    }

    @SuppressLint("SetTextI18n")
    public void equalBTN(View view) {
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
            float d_e = (float) (qt * by * 0.0077);
            float d_s = (float) (qt * sll * 0.0077);
            float p_e = (qt * by) + d_e;
            float p_s = (qt * sll) - d_s;
            float tva = (float) ((p_s - p_e) * 0.15);

            @SuppressLint("DefaultLocale") String tb = String.format("%.2f",(qt * by));
            totalb.setText(tb + " DH");

            if ( p_s < p_e ){
                @SuppressLint("DefaultLocale") String p = String.format("%.2f",(qt*sll)-(qt*by));
                profit.setText(p + " DH");
                @SuppressLint("DefaultLocale") String ta = String.format("%.2f",((qt*sll)-(qt*by)) + (qt*by));
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
}