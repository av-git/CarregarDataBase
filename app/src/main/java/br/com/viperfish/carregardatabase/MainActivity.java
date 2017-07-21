package br.com.viperfish.carregardatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBaseHelper db = new DataBaseHelper(this);

        try
        {
            db.CriarDataBase();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try {
            db.abrirDataBase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<String> names =   db.selecionaTodos("Marca","_id");
        StringBuilder sb = new StringBuilder();
        sb.append("Clientes Cadastrados:\n");
        for (String name : names)
        {
            sb.append(name + "\n");
            Log.i("av", sb.toString());
        }
    }
}
