package com.lantel.homelibrary.output.list.adpter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lantel.common.GalleryDetailActivity;
import com.lantel.common.GalleryDetailActivity2;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.output.list.holder.ImageHolder;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class ImagAdapter extends BaseRecyclerViewAdapter {
    private RecyclerView.LayoutManager manager;

    /**
     * 适配器构造
     * @param context
     * @param datas
     * @param manager
     */
    public ImagAdapter(Context context, List datas, RecyclerView.LayoutManager manager) {
        super(context, datas);
        this.manager = manager;
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new ImageHolder(inflater.inflate(getLayout(),parent,false));
    }

    private int getLayout() {
        int count = getItemCount();
        if(count == 1)
            return R.layout.img_item;
        else return R.layout.img_item_square;
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, Object data, int position, int viewType) {
        ImageHolder imageHolder = (ImageHolder) holder;
        imageHolder.img.setOnClickListener((View view)-> {
            Intent intent = new Intent(context, GalleryDetailActivity2.class);
            context.startActivity(intent);
        });
    }
}
