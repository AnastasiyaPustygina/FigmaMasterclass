package com.example.figmamasterclass;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialToolbar toolbar = (MaterialToolbar) findViewById(R.id.topAppBar);

        toolbar.setTitle("Имя");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast back = Toast.makeText(MainActivity.this, "BACK", Toast.LENGTH_SHORT);
                ViewGroup view1 = (ViewGroup) back.getView();
                ((TextView)view1.getChildAt(0)).setTextSize(15);
                back.show();
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.edit:
                        item.setEnabled(false);
                        FloatingActionButton button = new FloatingActionButton(MainActivity.this);
                        CoordinatorLayout layout = findViewById(R.id.ll);
                        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        button.setPadding(0, 200, 20, 0);
                        button.setUseCompatPadding(true);
                        button.setTranslationY(200);
                        layoutParams.setAnchorId(R.id.et_info);
                        layoutParams.anchorGravity = GravityCompat.END | Gravity.BOTTOM;
                        layout.addView(button, layoutParams);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                TextInputLayout etTel = findViewById(R.id.et_tel);
                                etTel.setEnabled(false);
                                etTel.setBoxStrokeWidth(0);
                                TextInputLayout etEmail = findViewById(R.id.et_email);
                                etEmail.setBoxStrokeWidth(0);
                                etEmail.setEnabled(false);
                                TextInputLayout etInfo = findViewById(R.id.et_info);
                                etInfo.setBoxStrokeWidth(0);
                                etInfo.setEnabled(false);
                                layout.removeView(view);
                                item.setEnabled(true);
                            }
                        });
                        // в отдельный метод
                        TextInputLayout etTel = findViewById(R.id.et_tel);
                        etTel.setEnabled(true);
                        etTel.setBoxStrokeWidth(5);
                        TextInputLayout etEmail = findViewById(R.id.et_email);
                        etEmail.setBoxStrokeWidth(5);
                        etEmail.setEnabled(true);
                        TextInputLayout etInfo = findViewById(R.id.et_info);
                        etInfo.setBoxStrokeWidth(5);
                        etInfo.setEnabled(true);
                        etTel.requestFocus();
                        etTel.getEditText().setSelection(etTel.getEditText().getText().length());
                        break;
                    case R.id.more:
                        Toast exit = Toast.makeText(MainActivity.this, "EXIT", Toast.LENGTH_SHORT);
                        ViewGroup view1 = (ViewGroup) exit.getView();
                        ((TextView)view1.getChildAt(0)).setTextSize(15);
                        exit.show();
                }
                return false;
            }
    });

    }
}