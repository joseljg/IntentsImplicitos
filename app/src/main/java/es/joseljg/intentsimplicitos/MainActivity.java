package es.joseljg.intentsimplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edt_web = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_web = (EditText) findViewById(R.id.edt_web);
    }

    public void abrirweb(View view) {
        String textourl = String.valueOf(edt_web.getText());
        Uri urlweb = Uri.parse(textourl);
        Intent intent = new Intent(Intent.ACTION_VIEW, urlweb);
        if(intent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intent);
        }
        else{
            edt_web.setError("no puedo abrir esta pagina web");
        }
    }
}