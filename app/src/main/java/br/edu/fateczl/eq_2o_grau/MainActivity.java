package br.edu.fateczl.eq_2o_grau;

import static br.edu.fateczl.eq_2o_grau.R.*;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {

    private EditText etA;
    private EditText etB;
    private EditText etC;
    private TextView tvRes;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etA=findViewById(R.id.etA);
        etA.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etB=findViewById(R.id.etB);
        etB.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etC=findViewById(R.id.etC);
        etC.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        Button btnCalc=findViewById(R.id.btnCalc);
        tvRes=findViewById(R.id.tvRes);

        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc(){

    int a=Integer.parseInt(etA.getText().toString());
    int b=Integer.parseInt(etB.getText().toString());
    int c=Integer.parseInt(etC.getText().toString());


    int delta=((b*b)-4*a*c);
    if(delta<0){
        tvRes.setText(getString(R.string.Nao_Possui_Raizes));
    }
    if(delta>0) {
        int x1 = (int) ((-b + Math.sqrt(delta)) / 2 * a);
        int x2 = (int) ((-b - Math.sqrt(delta)) / 2 * a);
        String res=getString(R.string.Delta) +"= "+delta +", "+getString(R.string.X1)+"= "+x1+", "
                +getString(R.string.X2)+"= "+x2;
        tvRes.setText(res);
    }
    if (delta==0){
    tvRes.setText(R.string.Raiz_unica);
    }
    }

}