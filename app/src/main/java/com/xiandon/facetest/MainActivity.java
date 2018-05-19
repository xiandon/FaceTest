package com.xiandon.facetest;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.xiandon.facetest.base.BaseActivity;
import com.xiandon.facetest.broadcast.BroadcastActivity;
import com.xiandon.facetest.fragment.FragmentBaseActivity;
import com.xiandon.facetest.intent.FirstActivity;
import com.xiandon.facetest.life_cycle.LifeCycleActivity;
import com.xiandon.facetest.list_view.ListViewActivity;
import com.xiandon.facetest.list_view.adapter.Title;
import com.xiandon.facetest.list_view.adapter.TitleAdapter;
import com.xiandon.facetest.nine_patch.NinePatchChatActivity;
import com.xiandon.facetest.recycler_view.RecyclerViewActivity;
import com.xiandon.facetest.service.ServiceTextActivity;
import com.xiandon.facetest.storage.StorageActivity;
import com.xiandon.facetest.ui.ProgressActivity;
import com.xiandon.facetest.ui.TitleLayoutActivity;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.PermissionListener;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private List<Title> titleList = new ArrayList<>();
    private Context context;

    @BindView(R.id.lv_main_lv_title)
    ListView lvMainLvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        ButterKnife.bind(this);

        initTitles();

        moreApply();

        TitleAdapter adapter = new TitleAdapter(this, R.layout.layout_main_list_view_item, titleList);
        lvMainLvTitle.setAdapter(adapter);

        lvMainLvTitle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = titleList.get(i).getTitleName();
                switch (name) {
                    case "Service":
                        startActivity(new Intent(context, ServiceTextActivity.class));
                        break;
                    case "Intent":
                        startActivity(new Intent(context, FirstActivity.class));
                        break;
                    case "LifeCycle":
                        startActivity(new Intent(context, LifeCycleActivity.class));
                        break;
                    case "Progress":
                        startActivity(new Intent(context, ProgressActivity.class));
                        break;
                    case "TitleLayout":
                        startActivity(new Intent(context, TitleLayoutActivity.class));
                        break;
                    case "ListView":
                        startActivity(new Intent(context, ListViewActivity.class));
                        break;
                    case "recyclerView":
                        startActivity(new Intent(context, RecyclerViewActivity.class));
                        break;
                    case "ninePatchChat":
                        startActivity(new Intent(context, NinePatchChatActivity.class));
                        break;
                    case "fragment":
                        startActivity(new Intent(context, FragmentBaseActivity.class));
                        break;
                    case "broadcast":
                        startActivity(new Intent(context, BroadcastActivity.class));
                        break;
                    case "storage":
                        startActivity(new Intent(context, StorageActivity.class));
                        break;
                }
            }
        });


    }


    /**
     * 隐藏标题栏
     */
    private void actionBarHide() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    private void initTitles() {
        Title service = new Title("Service", R.drawable.ic_launcher_foreground);
        titleList.add(service);

        Title intent = new Title("Intent", R.drawable.ic_launcher_foreground);
        titleList.add(intent);

        Title lifeCycle = new Title("LifeCycle", R.drawable.ic_launcher_foreground);
        titleList.add(lifeCycle);

        Title progress = new Title("Progress", R.drawable.ic_launcher_foreground);
        titleList.add(progress);

        Title titleLayout = new Title("TitleLayout", R.drawable.ic_launcher_foreground);
        titleList.add(titleLayout);

        Title listView = new Title("ListView", R.drawable.ic_launcher_foreground);
        titleList.add(listView);

        Title recyclerView = new Title("recyclerView", R.drawable.ic_launcher_foreground);
        titleList.add(recyclerView);

        Title ninePatchChat = new Title("ninePatchChat", R.drawable.ic_launcher_foreground);
        titleList.add(ninePatchChat);

        Title fragment = new Title("fragment", R.drawable.ic_launcher_foreground);
        titleList.add(fragment);

        Title broadcast = new Title("broadcast", R.drawable.ic_launcher_foreground);
        titleList.add(broadcast);

        Title storage = new Title("storage", R.drawable.ic_launcher_foreground);
        titleList.add(storage);


    }


    /**
     * 多个权限同时申请
     */
    private void moreApply() {
        AndPermission.with(this)
                .permission(Permission.CAMERA, Permission.STORAGE, Permission.CONTACTS)
                .callback(permissionListener)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                        // 这里的对话框可以自定义，只要调用rationale.resume()就可以继续申请。
                        AndPermission.rationaleDialog(MainActivity.this, rationale).show();
                    }
                })
                .start();
    }


    /**
     * 外部存储权限申请
     */
    private void storageApply() {
        AndPermission.with(this)
                .permission(Permission.STORAGE)
                .callback(permissionListener)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                        // 这里的对话框可以自定义，只要调用rationale.resume()就可以继续申请。
                        AndPermission.rationaleDialog(MainActivity.this, rationale).show();
                    }
                })
                .start();
    }

    /**
     * 相机权限申请
     */
    private void cameraApply() {
        AndPermission.with(this)
                .permission(Permission.CAMERA)
                .callback(permissionListener)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                        // 这里的对话框可以自定义，只要调用rationale.resume()就可以继续申请。
                        AndPermission.rationaleDialog(MainActivity.this, rationale).show();
                    }
                })
                .start();
    }

    /**
     * 通讯录权限申请
     */
    private void cantactsApply() {
        AndPermission.with(this)
                .permission(Permission.CONTACTS)
                .callback(permissionListener)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                        // 这里的对话框可以自定义，只要调用rationale.resume()就可以继续申请。
                        AndPermission.rationaleDialog(MainActivity.this, rationale).show();
                    }
                })
                .start();
    }

    /**
     * 位置权限申请
     */
    private void locationApply() {
        AndPermission.with(this)
                .permission(Permission.LOCATION)
                .callback(permissionListener)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                        // 这里的对话框可以自定义，只要调用rationale.resume()就可以继续申请。
                        AndPermission.rationaleDialog(MainActivity.this, rationale).show();
                    }
                })
                .start();
    }

    /**
     * 回调监听。
     */
    private PermissionListener permissionListener = new PermissionListener() {
        @Override
        public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
            Toast.makeText(MainActivity.this, "申请成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
            // 用户否勾选了不再提示并且拒绝了权限，那么提示用户到设置中授权。
            if (AndPermission.hasAlwaysDeniedPermission(MainActivity.this, deniedPermissions)) {
                // 第一种：用默认的提示语。
                AndPermission.defaultSettingDialog(MainActivity.this, 300).show();
            }
        }
    };

}
