package dsrtecnologia.com.br.petindermobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText tLogin, tSenha;
    private Button btLogin;
    dbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iniciarComponentes();
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                String user = tLogin.getText().toString();
                String password = tSenha.getText().toString();
                db.ValidarLogin(user, password);
                if(user.equals("")){
                    alert("Favor informar o Usuário!");
                }else if(password.equals("")){
                    alert("Senha não inserida!");
                }else{
                    String result = db.ValidarLogin(user, password);
                    if(result.equals("OK")){
                        Intent i = new Intent(Login.this, Like.class);
                        startActivity(i);
                    }else{
                        alert("Usuário não cadastrado ou senha incorreta.");
                    }

                }
            }
        });
    }

    private void alert(String m){
        Toast.makeText(this,m,Toast.LENGTH_LONG).show();
    }

    private void iniciarComponentes() {
        tLogin = findViewById(R.id.tLogin);
        tSenha = findViewById(R.id.tSenha);
        btLogin = findViewById(R.id.btLogin);
        db = new dbHelper(this);
    }

    public void btnCad(View View){
        Intent i = new Intent(Login.this, Cadastro.class);
        startActivity(i);
    }
}