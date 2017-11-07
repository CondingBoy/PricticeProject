package example.wangdachui.aboutrecyclerview.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import example.wangdachui.aboutrecyclerview.R;

/**
 * 作者：WangWei
 * 日期：2017/11/7 21:51
 * 描述：
 */

public class ItemTouchHelperAdapter extends RecyclerView.Adapter<ItemTouchHelperAdapter.TempViewHolder>
implements SimpleTouchHelperCallback.ItemTouchEvenet{

    private final LayoutInflater mInflater;
    private final List<String> mData;
    private List<Integer> mColors;
    public ItemTouchHelperAdapter(Context context, List<String> data){
        mInflater =  LayoutInflater.from(context);
        mData = data;
        mColors = new ArrayList<>();
        mColors.add(R.color.color_28ec60);
        mColors.add(R.color.color_99ea1f);
        mColors.add(R.color.color_52f1ee);
    }
    @Override
    public TempViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_touchhelper_item, parent, false);
        return new TempViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TempViewHolder holder, int position) {
        holder.tvItem.setText(mData.get(position));
        holder.itemView.setBackgroundResource(mColors.get(position%3));
    }

    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }

    @Override
    public void onMoved(int fromPosition, int toPosition) {
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onDissmiss(int position) {

    }

    public static class TempViewHolder extends RecyclerView.ViewHolder{
        TextView tvItem;
        public TempViewHolder(View itemView) {
            super(itemView);
            tvItem=(TextView) itemView.findViewById(R.id.tv_item);
        }
    }
}
