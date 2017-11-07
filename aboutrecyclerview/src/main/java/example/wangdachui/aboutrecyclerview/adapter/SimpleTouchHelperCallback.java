package example.wangdachui.aboutrecyclerview.adapter;

import android.support.annotation.IntRange;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

/**
 * 作者：WangWei
 * 日期：2017/11/7 23:05
 * 描述：实现recyclerView的Item拖动效果的callback
 */

public class SimpleTouchHelperCallback extends ItemTouchHelper.Callback {
    public static final String TAG = SimpleTouchHelperCallback.class.getSimpleName();
    private final ItemTouchEvenet mItemTouchEvent;

    public SimpleTouchHelperCallback(ItemTouchEvenet itemTouchEvenet) {
        mItemTouchEvent = itemTouchEvenet;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipFlags = ItemTouchHelper.LEFT;
        return makeMovementFlags(dragFlags, swipFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        mItemTouchEvent.onMoved(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    @Override
    public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int fromPos, RecyclerView.ViewHolder target, int toPos, int x, int y) {
        super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y);
        Log.e(TAG, "onMoved: "+fromPos+":"+toPos);
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    public static interface ItemTouchEvenet {
        void onMoved(int fromPosition, int toPosition);

        void onDissmiss(int position);
    }
}
