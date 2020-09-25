package in.bitcode.customdialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnLogin = findViewById(R.id.btnLogin);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog signInDialog = new Dialog(MainActivity.this);
                signInDialog.setTitle("BitCode");
                signInDialog.setContentView(R.layout.sign_in_dialog);

                final EditText edtUsername = signInDialog.findViewById(R.id.edtUsername);
                final EditText edtPassword = signInDialog.findViewById(R.id.edtPassword);
                final Button btnSignIn = signInDialog.findViewById(R.id.btnSignIn);

                btnSignIn.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if( edtUsername.getText().toString().equals("bitcode@gmail.com") && edtPassword.getText().toString().equals("bitcode@123")) {
                            signInDialog.dismiss();
                            mt("Successfully signed in");
                        }
                        else {
                            mt("Sign in failed");
                        }
                    }
                });

                signInDialog.show();
            }
        });
    }

    private void mt(String text) {
        Toast.makeText( this, text, Toast.LENGTH_LONG).show();
    }
}