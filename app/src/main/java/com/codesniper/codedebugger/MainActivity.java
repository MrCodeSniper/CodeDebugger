package com.codesniper.codedebugger;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.codesniper.codedebugger.base.FloatPageManager;
import com.codesniper.codedebugger.base.PageIntent;
import com.codesniper.codedebugger.utils.PermissionUtil;
import com.codesniper.codedebugger.widget.FloatIconPage;

public class MainActivity extends AppCompatActivity {

    private static boolean sHasRequestPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatPageManager.getInstance().init(this);
        if (PermissionUtil.canDrawOverlays(MainActivity.this)) {
            showFloatIcon(this);
        } else {
            requestPermission(this);
        }
    }

    private  void requestPermission(Context context) {
        if (!PermissionUtil.canDrawOverlays(context) && !sHasRequestPermission) {
            Toast.makeText(context, context.getText(R.string.dk_float_permission_toast), Toast.LENGTH_SHORT).show();
            PermissionUtil.requestDrawOverlays(context);
            sHasRequestPermission = true;
        }
    }

    private void showFloatIcon(Context context) {
        PageIntent intent = new PageIntent(FloatIconPage.class);
        intent.mode = PageIntent.MODE_SINGLE_INSTANCE;
        FloatPageManager.getInstance().add(intent);
    }
}
