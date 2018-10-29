package dsrtecnologia.com.br.petindermobile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class Cadastro extends AppCompatActivity {

    dbHelper db;
    private Button btnRegistrar;
    private EditText tUser, tPassword, tConfirmPassword, tEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        db = new dbHelper(this);

        iniciarComponentes();
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                String username = tUser.getText().toString();
                String password = tPassword.getText().toString();
                String confirmPassword = tConfirmPassword.getText().toString();
                String email = tEmail.getText().toString();
                if(username.equals("")){
                    tUser.setError("Campo usuário não pode ser vazio!");
                }else if (email.equals("")){
                    tEmail.setError("Campo Email não pode ser vazio!");
                }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    tEmail.setError("Por favor informar um email valido");
                }else if(password.equals("")){
                    tPassword.setError("Campo senha não pode ser vazio!");
                }else if(confirmPassword.equals("")){
                    tConfirmPassword.setError("Campo Confirmar senha não pode ser vazio!");
                }else if (!password.equals(confirmPassword)){
                    tConfirmPassword.setError("As senhas não são iguais, tente novamente!");
                }else{
                    long res = db.Cadastrar(username, password, email);
                    if(res > 0){
                        Toast.makeText(Cadastro.this,"Cadastro Realizado com Sucesso!",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Cadastro.this, Login.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(Cadastro.this,"Cadastro Inválido, tente novamente!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private String codeImg(Bitmap p){
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        p.compress(Bitmap.CompressFormat.JPEG, 100, b);
        byte[] b1 = b.toByteArray();
        return Base64.encodeToString(b1, Base64.DEFAULT);
    }

    private void iniciarComponentes(){
        btnRegistrar = findViewById(R.id.btnRegistrar);
        tUser = findViewById(R.id.tUser);
        tPassword = findViewById(R.id.tPassword);
        tConfirmPassword = findViewById(R.id.tConfirmPassword);
        tEmail = findViewById(R.id.tEmail);
    }

    public void btnVoltar(View View){
        Intent i = new Intent(Cadastro.this, Login.class);
        startActivity(i);
    }
}