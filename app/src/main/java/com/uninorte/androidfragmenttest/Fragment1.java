package com.uninorte.androidfragmenttest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class Fragment1 extends Fragment {

	private String TAG = Fragment1.class.getSimpleName();
	private Button mButton;
	private EditText mEditText;
    private Callback callback;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment1, container, false);

		mEditText = (EditText) rootView.findViewById(R.id.editTextParameter);

		mButton = (Button) rootView.findViewById(R.id.buttonFragment1);

		mButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d(TAG, "Fragment1 on click");

                int val;

				String valText = mEditText.getText().toString();

				if (valText.matches("")) {
					val = 0;
				} else {
					val = Integer.valueOf(mEditText.getText().toString());
				}

                callback.onFordward(val);

                hideKeyboard();

			}
		});

		return rootView;
	}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (Callback) activity;
        } catch (ClassCastException e) {
            Log.d(TAG, e.getMessage());
            throw new ClassCastException(activity.toString()
                    + " must implement CaptureFragment.Callback");
        }

    }

    private void hideKeyboard() {
        // Check if no view has focus:
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    public interface Callback {
        public void onFordward(int val);
    }

}
