package com.everis.prj_12_dtedittext;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DTEditText extends android.support.v7.widget.AppCompatEditText implements View.OnClickListener{

    private Context context;

    private SimpleDateFormat dateFormat;

    public DTEditText(Context context) {
        super(context);

        initialize(context);
    }

    public DTEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        initialize(context);
    }

    public DTEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initialize(context);
    }

    private void initialize(Context context) {
        this.context = context;
        //
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //
        //Cancelar a exibicao do Teclado virtual
        setInputType(InputType.TYPE_NULL);
        //
        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Recupere as informacoes contidas na caixa
        String mConteudo = getText().toString();
        //
        // Data de Agora
        Calendar mDate = Calendar.getInstance();
        //
        try{
            mDate.setTime(dateFormat.parse(mConteudo));
        } catch (Exception e){
        }
        //
        int mAno = mDate.get(Calendar.YEAR);
        int mMes = mDate.get(Calendar.MONTH);
        int mDia = mDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDatePicker = new DatePickerDialog(
                context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // atualizar a caixa de texto
                        Calendar mDataCaptura = Calendar.getInstance();
                        mDataCaptura.set(year,month,dayOfMonth);
                        //
                        setText(dateFormat.format(mDataCaptura.getTime()));
                    }
                },
                mAno,
                mMes,
                mDia
        );
        //
        mDatePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Cancelar", (DialogInterface.OnClickListener) null);
        mDatePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ok", mDatePicker);
        //
        mDatePicker.show();
    }
}
