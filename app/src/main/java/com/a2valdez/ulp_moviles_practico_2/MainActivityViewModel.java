package com.a2valdez.ulp_moviles_practico_2;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Double> mCambio;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Double> getmCambio() {
        if(mCambio == null){
            mCambio = new MutableLiveData<>();
        }
        return mCambio;
    }

    public void convertirMoneda(String ctEuros, String ctDolares, boolean rbDolaresEuros, boolean rbEurosDolares){
        //Logica de conversion y seteo a mCambio
        Log.d("salida", ctDolares);
        Double cambio = (double) 0;
        if(rbDolaresEuros){
            cambio = Double.parseDouble(ctDolares) * 0.92;
        }
        if(rbEurosDolares){
            cambio = Double.parseDouble(ctEuros) * 1.09;
        }
        mCambio.setValue(cambio);
    }

}
