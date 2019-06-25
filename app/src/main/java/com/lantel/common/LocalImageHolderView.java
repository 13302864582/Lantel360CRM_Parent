package com.lantel.common;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigkoo.convenientbanner.holder.Holder;
import com.cangwang.core.IBaseClient;
import com.cangwang.core.ModuleBus;
import com.lantel.crmparent.R;

/***
 *  本地菜单按钮的holder
 */
public class LocalImageHolderView extends Holder<Integer> {
    private ImageView splash_img;
    private TextView jump_rightnow;
    private TextView jump;

    public LocalImageHolderView(View itemView) {
        super(itemView);
    }

    @Override
    protected void initView(View itemView) {
        splash_img = itemView.findViewById(R.id.splash_img);
        jump_rightnow = itemView.findViewById(R.id.jump_rightnow);
        jump = itemView.findViewById(R.id.jump);
    }

    @Override
    public void updateUI(Integer data) {
        int position = getAdapterPosition();
        jump.setVisibility(position == 3?View.GONE:View.VISIBLE);
        jump_rightnow.setVisibility(position == 3?View.VISIBLE:View.GONE);
        splash_img.setImageResource(data);
        jump.setOnClickListener((View view)-> {
            ModuleBus.getInstance().post(IBaseClient.class,"GotoApp");
        });

        jump_rightnow.setOnClickListener((View view)-> {
            ModuleBus.getInstance().post(IBaseClient.class,"GotoApp");
        });
    }
}
