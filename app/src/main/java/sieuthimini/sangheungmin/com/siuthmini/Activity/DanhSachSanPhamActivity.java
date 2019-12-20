package sieuthimini.sangheungmin.com.siuthmini.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import sieuthimini.sangheungmin.com.siuthmini.Adapter.DanhSachSanPhamAdapter;
import sieuthimini.sangheungmin.com.siuthmini.Entity.DanhSachSanPhamEntity;
import sieuthimini.sangheungmin.com.siuthmini.Internet.Server;
import sieuthimini.sangheungmin.com.siuthmini.R;
public class DanhSachSanPhamActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String id_loaisp;
    private ArrayList<DanhSachSanPhamEntity> arr_sanpham = new ArrayList<>();
    private DanhSachSanPhamAdapter danhSachSanPhamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhsachsanpham_activity);
        final Intent intent = getIntent();
        id_loaisp = intent.getStringExtra("id_loaisp");
        System.out.println(""+id_loaisp);
        anhXa();
        hienThiDuLieu();
        danhSachSanPhamAdapter = new DanhSachSanPhamAdapter(arr_sanpham,getApplicationContext());
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        danhSachSanPhamAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),ChiTietSanPhamActivity.class);
                intent1.putExtra("id_sanpham",""+arr_sanpham.get(recyclerView.getChildAdapterPosition(v)).getId_sanpham());
                startActivity(intent1);
                Toast.makeText(getApplicationContext(),"Bạn Đã Chọn "+arr_sanpham.get(recyclerView.getChildAdapterPosition(v)).getId_sanpham(),Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setAdapter(danhSachSanPhamAdapter);
    }
    public void anhXa(){
        recyclerView = findViewById(R.id.recyclerview_danhsachsanpham);
    }
    public void hienThiDuLieu(){
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest= new StringRequest(Request.Method.POST, Server.Duongdandanhsachsanphamchitiet, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id_sp=0;
                int id_loaisp = 0;
                String tensp ="";
                int soLuongSp = 0;
                int donGia =0;
                String linkAnh ="";
                String moTa ="";
                int trangThai =0;
                try {
                    JSONArray array = new JSONArray(response);
                    for(int i=0;i<array.length();i++){
                        JSONObject jsonObject=array.getJSONObject(i);
                        id_sp = jsonObject.getInt("ID_SPChiTiet");
                        id_loaisp= jsonObject.getInt("ID_LoaiSanPham");
                        tensp = jsonObject.getString("Ten_SPChiTiet");
                        soLuongSp = jsonObject.getInt("SoLuong_SPChiTiet");
                        donGia =jsonObject.getInt("DonGia_SPChiTiet");
                        linkAnh = jsonObject.getString("LinkAnh_SPChiTiet");
                        moTa = jsonObject.getString("MoTa_SPChiTiet");
                        trangThai = jsonObject.getInt("TrangThai_SPChiTiet");
                        arr_sanpham.add(new DanhSachSanPhamEntity(id_sp,id_loaisp,tensp,soLuongSp,donGia,linkAnh,moTa,trangThai));
                        System.out.println("===============ARRAY"+arr_sanpham.get(i).getTenSanPham());
                        System.out.println("=================SL"+arr_sanpham.get(i).getSoLuongSanPham());
                        danhSachSanPhamAdapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap = new HashMap<String, String>();
                hashMap.put("ID_LoaiSanPham",id_loaisp);
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }
}
