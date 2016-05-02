package com.example.dateasy.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.dateasy.R;
import com.example.dateasy.activity.ManagementActivity;
import com.example.dateasy.adapter.ManagementListViewAdapter;
import com.example.dateasy.model.ManageEvent;
import com.example.dateasy.util.Utils;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
/**
 * 管理界面中我发布的Fragment
 * @author Xu
 *
 */
public class ReleaseFragment extends SingleFragment implements OnItemClickListener{
	private ListView mListView;
	private List<ManageEvent> mContent;
	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.management_release_fragment;
	}

	@Override
	protected void createView(View view) {
		// TODO Auto-generated method stub
		initContent();
		mListView = (ListView) view.findViewById(R.id.management_lv);
		mListView.setAdapter(new ManagementListViewAdapter(getActivity(), mContent));
		mListView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Bundle bundle = new Bundle();
		bundle.putString("EVENTNAME", mContent.get(position).getmEventName());
		Utils.toAnotherActivity(getActivity(), ManagementActivity.class, bundle);
	}
	private void initContent(){
		mContent = new ArrayList<ManageEvent>();
		ManageEvent me = new ManageEvent();
		me.setmEventName("假面舞会");
		me.setmEventState("报名中");
		me.setmIfCost(false);
		me.setmReleaseTime("3天前发布了该活动");
		me.setmType("组织聚会");
		me.setmCount(23);
		mContent.add(me);
	}



}
