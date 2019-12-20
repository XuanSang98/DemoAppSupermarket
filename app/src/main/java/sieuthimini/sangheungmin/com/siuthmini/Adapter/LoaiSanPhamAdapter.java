package sieuthimini.sangheungmin.com.siuthmini.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import sieuthimini.sangheungmin.com.siuthmini.Animation.AnimationUtil;
import sieuthimini.sangheungmin.com.siuthmini.R;
import java.util.ArrayList;

import sieuthimini.sangheungmin.com.siuthmini.Entity.LoaiSanPham;

public class LoaiSanPhamAdapter extends RecyclerView.Adapter<LoaiSanPhamAdapter.ViewHolder> implements View.OnClickListener{
    ArrayList<LoaiSanPham> mangLoaiSp = new ArrayList<>();
    Context context;
    int previouPosition = 0;
    private View.OnClickListener listener;
    public LoaiSanPhamAdapter(ArrayList<LoaiSanPham> mangLoaiSp, Context context) {
        this.mangLoaiSp = mangLoaiSp;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.danhsachloaisanpham_entity,viewGroup,false);
        LoaiSanPhamAdapter.ViewHolder viewHoler = new LoaiSanPhamAdapter.ViewHolder(view);
        view.setOnClickListener(this);
        if(i>previouPosition){
            AnimationUtil.animate(viewHoler,true);
        }else {
            AnimationUtil.animate(viewHoler,true);
        }
        previouPosition=i;
        return viewHoler;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Picasso.with(context).load(mangLoaiSp.get(i).getLinkanhloaisanpham()).into(viewHolder.img_loaisp);
        viewHolder.txt_loaisp.setText(mangLoaiSp.get(i).getTenloaisanpham());
    }

    @Override
    public int getItemCount() {
        return mangLoaiSp.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_loaisp;
        TextView txt_loaisp;
       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           img_loaisp = itemView.findViewById(R.id.img_loaisanpham);
           txt_loaisp = itemView.findViewById(R.id.txt_loaisanpham);
       }
   }
}
