package sieuthimini.sangheungmin.com.siuthmini.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import sieuthimini.sangheungmin.com.siuthmini.Entity.DanhSachSanPhamEntity;
import sieuthimini.sangheungmin.com.siuthmini.R;

public class DanhSachSanPhamAdapter extends RecyclerView.Adapter<DanhSachSanPhamAdapter.ViewHolder> implements View.OnClickListener{
    private ArrayList<DanhSachSanPhamEntity> arr_sanpham ;
    private Context context;
    private View.OnClickListener listener;

    public DanhSachSanPhamAdapter(ArrayList<DanhSachSanPhamEntity> arr_sanpham, Context context) {
        this.arr_sanpham = arr_sanpham;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.danhsachsanpham_entity,viewGroup,false);
        DanhSachSanPhamAdapter.ViewHolder viewHolder = new DanhSachSanPhamAdapter.ViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Picasso.with(context).load(arr_sanpham.get(i).getLinkAnhSanPham()).into(viewHolder.img_sanpham);
        viewHolder.txt_tensanpham.setText(arr_sanpham.get(i).getTenSanPham());
        viewHolder.txt_giasanpham.setText(arr_sanpham.get(i).getDonGia()+" VNĐ");
    }

    @Override
    public int getItemCount() {
        return arr_sanpham.size();
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
        private ImageView img_sanpham;
        private TextView txt_tensanpham;
        private TextView txt_giasanpham;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_sanpham = itemView.findViewById(R.id.img_danhsachsanpham);
            txt_tensanpham = itemView.findViewById(R.id.txt_tensanpham);
            txt_giasanpham = itemView.findViewById(R.id.txt_giasanpham);
        }
    }
}
