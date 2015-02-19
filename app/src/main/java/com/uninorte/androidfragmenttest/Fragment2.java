package com.uninorte.androidfragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment2 extends Fragment {

	private String TAG = Fragment2.class.getSimpleName();
	private Button button2;
	private TextView mTextView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment2, container, false);

		mTextView = (TextView) rootView.findViewById(R.id.textViewParameter);

		Integer val = getArguments().getInt("someInt", 0);

		mTextView.setText(val.toString());

		button2 = (Button) rootView.findViewById(R.id.buttonFragment2);

		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				getActivity().getSupportFragmentManager().popBackStack();
			}
		});

		return rootView;
	}

}
