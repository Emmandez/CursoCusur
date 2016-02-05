package com.example.emmanuel.aplicacion.activities.fragments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.emmanuel.aplicacion.R;


/**
 * Created by Emmanuel on 03/02/2016.
 */
public class CameraFragment extends Fragment {
    private final static int SELECT_PICTURE = 200;
    private ImageView mSetPicture;

    public static CameraFragment newInstance() {
        CameraFragment cameraFragment = new CameraFragment();
        return cameraFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.camera_fragment_layout, container, false);
        Button mChoosePictureButton = (Button) view.findViewById(R.id.TakeP);
        mSetPicture = (ImageView) view.findViewById(R.id.Pic);

        mChoosePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence items[] = {"Tomar foto", "Abrir galería", "Cancelar"};
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Elige una opción");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            openCamera();

                        } else if (which == 1) {
                            selectFromGallery();
                        } else
                            dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
        return view;
    }

    private void openCamera() {

    }

    private void selectFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent.createChooser(intent, "Elige una aplicación "), SELECT_PICTURE);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case SELECT_PICTURE:
                Log.d("Emmanuel","SelectPicture");
                if(resultCode== Activity.RESULT_OK){
                    Log.d("Hola","Adios");
                    Uri path = data.getData();
                    mSetPicture.setImageURI(path);
                }


        }
    }
}
