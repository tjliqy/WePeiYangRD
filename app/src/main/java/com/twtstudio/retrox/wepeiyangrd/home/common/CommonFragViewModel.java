package com.twtstudio.retrox.wepeiyangrd.home.common;

import android.databinding.ObservableArrayList;

import com.kelin.mvvmlight.base.ViewModel;
import com.twtstudio.retrox.wepeiyangrd.BR;
import com.twtstudio.retrox.wepeiyangrd.R;
import com.twtstudio.retrox.wepeiyangrd.base.BaseActivity;
import com.twtstudio.retrox.wepeiyangrd.base.BaseFragment;
import com.twtstudio.retrox.wepeiyangrd.home.common.gpaItem.GpaItemViewModel;
import com.twtstudio.retrox.wepeiyangrd.home.common.oneItem.OneInfoViewModel;

import me.tatarka.bindingcollectionadapter.ItemViewSelector;
import me.tatarka.bindingcollectionadapter.itemviews.ItemViewClassSelector;

/**
 * Created by retrox on 2017/1/16.
 */

public class CommonFragViewModel implements ViewModel {

    private BaseFragment mFragment;

//    public final ObservableArrayMap mObservableArrayMap;

    public final ObservableArrayList<ViewModel> viewModelList = new ObservableArrayList<>();

    /**
     * 思考更优化的解决方案
     * itemClassSelector?
     */
    // TODO: 2017/1/16 better solution???
//    public final ItemViewSelector<ViewModel> itemView = new BaseItemViewSelector<ViewModel>() {
//        @Override
//        public void select(ItemView itemView, int position, ViewModel item) {
//            if (position == 0){
//                itemView.set(BR.viewModel, R.layout.item_common_one);
//            }
//        }
//    };

    public final ItemViewSelector itemView = ItemViewClassSelector.builder()
            .put(OneInfoViewModel.class,BR.viewModel,R.layout.item_common_one)
            .put(GpaItemViewModel.class,BR.viewModel,R.layout.item_common_gpa)
            .build();

    public CommonFragViewModel(BaseFragment fragment) {
        mFragment = fragment;
        initList();
    }

    private void initList(){
        viewModelList.add(new OneInfoViewModel(mFragment));

        //viewModelList.add(new GpaItemViewModel((BaseActivity) mFragment.getActivity()));
        // FIXME: 2017/1/21 gpa null exception
    }
}
