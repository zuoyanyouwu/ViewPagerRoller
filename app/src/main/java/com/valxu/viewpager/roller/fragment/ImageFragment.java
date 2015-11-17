package com.valxu.viewpager.roller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.valxu.viewpager.roller.AppConstants;
import com.valxu.viewpager.roller.Data;
import com.valxu.viewpager.roller.R;

/**
 * Author: zuoyanyouwu
 * Date: 2015-11-17
 */
public class ImageFragment extends Fragment {

    ImageView imageView;
    int imageIndex;

    public static ImageFragment newInstance(int index) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putInt(AppConstants.ARGUMENT_IMAGE_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = (ImageView) view.findViewById(R.id.fragment_image);
        imageIndex = getArguments().getInt(AppConstants.ARGUMENT_IMAGE_INDEX, 0);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Picasso.with(getActivity()).load(Data.URLS[imageIndex]).into(imageView);
    }

}
