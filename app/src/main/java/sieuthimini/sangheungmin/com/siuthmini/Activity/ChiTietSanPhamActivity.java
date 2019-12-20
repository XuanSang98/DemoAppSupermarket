package sieuthimini.sangheungmin.com.siuthmini.Activity;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import sieuthimini.sangheungmin.com.siuthmini.Entity.LinkAnh_Entity;
import sieuthimini.sangheungmin.com.siuthmini.Internet.Server;
import sieuthimini.sangheungmin.com.siuthmini.R;

public class ChiTietSanPhamActivity extends AppCompatActivity {
    private CarouselView carouselView;
    private Toolbar toolbar;
    // int[] sampleImages = {R.drawable.anhc
    // anhan,R.drawable.loniu,R.drawable.dieukhoansudung};
    private ArrayList<LinkAnh_Entity> arr_linkanh;
    private String ID_SanPhamChiTiet;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietsanpham_activity);
        Intent intent = getIntent();
        arr_linkanh= new ArrayList<>();
        ID_SanPhamChiTiet = intent.getStringExtra("id_sanpham");
//        if(arr_linkanh1.size()==0){


//        }
//        arr_linkanh1 = new ArrayList<>();
        // arr_linkanh1.add("https://dichonhanh.r.worldssl.net/food/1359/b415__salad-lua-sua.png");
        // arr_linkanh1.add("http://giadinh.mediacdn.vn/2017/xa-lach-4-1500628001333.jpg");

        loadAnh();

        Log.e("Anhxa", "Hii" + arr_linkanh.size() + "");
        AnhXa();
        ActionBar();

    }

    public void AnhXa() {
        //Slide
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(arr_linkanh.size());
        Log.e("Anhxa", arr_linkanh.size() + "");
        carouselView.setImageListener(imageListener);
        //AnhXaTB
        toolbar = findViewById(R.id.tb_chitietsanpham);
        //Inten
    }

    public void ActionBar() {
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Chi Tiết Sản Phẩm");
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            //System.out.println("========LINKANH2==="+arr_linkanh1.get(position));
//            System.out.println("========LINKANH3==="+arr_linkanh.get(position).getAnh2());
            //  Picasso.with(getApplicationContext()).load(arr_linkanh1.get(position)).into(imageView);
            Picasso.with(getApplicationContext()).load(arr_linkanh.get(position).getAnh2()).into(imageView);
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void loadAnh() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdananh, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Anhxa", "Vao");
                int id_linkanh = 0;
                int id_sanpham = 0;
                String anh1 = "";
                String anh2 = "";
                String anh3 = "";
                String anh4 = "";
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jsonObject = array.getJSONObject(i);
                        id_linkanh = jsonObject.getInt("ID_LinkAnh");
                        id_sanpham = jsonObject.getInt("ID_SPChiTiet");
                        anh1 = jsonObject.getString("Anh1");
                        anh2 = jsonObject.getString("Anh2");
                        anh3 = jsonObject.getString("Anh3");
                        anh4 = jsonObject.getString("Anh4");
                        arr_linkanh.add(new LinkAnh_Entity(id_linkanh, id_sanpham, anh1, anh2, anh3, anh4));
                        System.out.println("=======================HHHHHHHHH======="+arr_linkanh.size());
                        Log.e("Anhxa 001: ", arr_linkanh.size() + "");
//                        System.out.println("========LINK ANh===="+arr_linkanh.get(i).getAnh1());
//                        System.out.println("========LINK ANh===="+arr_linkanh.get(i).getAnh2());
//                        System.out.println("========LINK ANh===="+arr_linkanh.get(i).getAnh3());
//                        System.out.println("========LINK ANh====="+arr_linkanh.get(i).getAnh4());
//                        for(int j=0;j<arr_linkanh.size();j++){
//                            arr_linkanh1.add(arr_linkanh.get(j).getAnh1());
//                            arr_linkanh1.add(arr_linkanh.get(j).getAnh2());
//                           // arr_linkanh1.add(arr_linkanh.get(j).getAnh3());
//                            arr_linkanh1.add(arr_linkanh.get(j).getAnh4());
//                        }
//                        System.out.println("9999999999999999999999999999999"+arr_linkanh1.size());
//                        System.out.println("++++++++++++++++++++++++SIZE++++++++++++++++"+arr_linkanh.size());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("ID_SPChiTiet", ID_SanPhamChiTiet);
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }
}
