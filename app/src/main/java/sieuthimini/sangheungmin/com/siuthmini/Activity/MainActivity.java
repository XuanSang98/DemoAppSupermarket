package sieuthimini.sangheungmin.com.siuthmini.Activity;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import sieuthimini.sangheungmin.com.siuthmini.Adapter.LoaiSanPhamAdapter;
import sieuthimini.sangheungmin.com.siuthmini.Entity.LoaiSanPham;
import sieuthimini.sangheungmin.com.siuthmini.Internet.CheckConnection;
import sieuthimini.sangheungmin.com.siuthmini.Internet.Server;
import sieuthimini.sangheungmin.com.siuthmini.R;

public class MainActivity extends AppCompatActivity {
    private Toolbar tb;
    private DrawerLayout mDrawerLayout;
    int ID_ThucDon =0;
    String Ten_Thuc_Don ="";
    String HinhAnh_ThucDon ="";
    private ArrayList<LoaiSanPham> mangloaiSp = new ArrayList<>();;
    private LoaiSanPhamAdapter loaispAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        ActionbarCustom();
        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
            layDuLieu();
        }else{
            CheckConnection.ShowToas_Short(getApplicationContext(),"Không Có Kết Nối Mạng");
        }
        loaispAdapter = new LoaiSanPhamAdapter(mangloaiSp,this);
      //  StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        System.out.println("========================================Mang Loai San Pham : "+mangloaiSp.size());
        loaispAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DanhSachSanPhamActivity.class);
                intent.putExtra("id_loaisp",""+mangloaiSp.get(recyclerView.getChildAdapterPosition(v)).getId_loaisanpham());
                startActivity(intent);
                System.out.println("+++++++++++++"+mangloaiSp.get(recyclerView.getChildAdapterPosition(v)).getId_loaisanpham());
            }
        });
        recyclerView.setAdapter(loaispAdapter);

    }
    //AnhXaXml
    private void AnhXa(){
        tb = findViewById(R.id.tb_main);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        recyclerView = findViewById(R.id.recyclerview_main);
    }
    //Custom ActionBar
    private void  ActionbarCustom(){
        setSupportActionBar(tb);
        tb.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.menu);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("Danh Mục Thực Phẩm");

    }
    //LayDuLieuTuServer
    private void layDuLieu(){
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdandanhsachthucdon, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response!=null){
                    for (int i=0;i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            ID_ThucDon =jsonObject.getInt("ID_LoaiSanPham");
                            Ten_Thuc_Don =jsonObject.getString("Ten_LoaiSanPham");
                            HinhAnh_ThucDon =jsonObject.getString("Link_AnhLoaiSanPham");
                            System.out.println("=====================================ID Thuc Don"+ID_ThucDon);
                            mangloaiSp.add(new LoaiSanPham(ID_ThucDon,Ten_Thuc_Don,HinhAnh_ThucDon));
                            System.out.println("Mang==========================="+mangloaiSp.get(i).getTenloaisanpham());
                            loaispAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToas_Short(getApplicationContext(),"Không Có Kết Nối Mạng");
            }
        });
        requestQueue.add(jsonArrayRequest);
      //  System.out.println("=====================================KT"+mangloaiSp.size());
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
