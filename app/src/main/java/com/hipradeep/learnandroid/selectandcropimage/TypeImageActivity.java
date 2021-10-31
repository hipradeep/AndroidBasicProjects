package com.hipradeep.learnandroid.selectandcropimage;

import static android.text.Html.fromHtml;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hipradeep.learnandroid.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TypeImageActivity extends AppCompatActivity {

    private static final int GALLERY_PIC_REQUEST = 100;
    private static final int CAMERA_PIC_REQUEST = 200;
    public static final int REQUEST_CAMERA_PERMISSION_CODE = 1;
    ImageView iv_image;
    TextView tv_selected_image_path;
    Uri imageUri;  //Uri (Uniform Resource Identifier) -  data to operate on, such as a image record in the gallery database,
    String currentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_image);
        iv_image = findViewById(R.id.iv_image);
        tv_selected_image_path = findViewById(R.id.tv_selected_image_path);
    }


    public void openGallery(View view) {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, GALLERY_PIC_REQUEST);

    }

    public void openCameraBTN(View view) {
        if (checkCameraPermission()) {
            openCamera2();
        } else {
            ActivityCompat.requestPermissions(TypeImageActivity.this, new String[]{
                    Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION_CODE);
        }
    }

    private void openCamera2() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                imageUri = FileProvider.getUriForFile(this,
                        getApplicationContext().getPackageName()+".provider",
                        photoFile);

                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(takePictureIntent, CAMERA_PIC_REQUEST);
            }
        }
    }

    private void openCamera() {
        ContentValues values = new ContentValues();
        Log.e("TAG44", values.toString());
//        values.put(MediaStore.Images.Media.TITLE, "New Picture");
//        values.put(MediaStore.Images.Media.DESCRIPTION, "From your Camera");
        imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, CAMERA_PIC_REQUEST);

        //Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        // startActivityForResult(intent, CAMERA_PIC_REQUEST);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_PIC_REQUEST && data != null && data.getData() != null && resultCode == Activity.RESULT_OK) {

            imageUri = data.getData();
            iv_image.setImageURI(imageUri);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                tv_selected_image_path.setText(fromHtml("<h6>URI : </h6>" + imageUri.toString() + "\n" +
                        "<h6>Path : </h6>" + imageUri.getPath(), Html.FROM_HTML_MODE_COMPACT));
            } else {
                tv_selected_image_path.setText(fromHtml("<h6>URI : </h6>" + imageUri.toString() + "\n" +
                        "<h6>Path : </h6>" + imageUri.getPath()));
            }
//            tv_selected_image_path.setText("URI : "+imageUri.toString()+"\n"+
//                                           "Path : "+imageUri.getPath());
        } else if (requestCode == CAMERA_PIC_REQUEST && resultCode == Activity.RESULT_OK) {

//            assert data != null;
//            Bitmap image = (Bitmap) data.getExtras().get("data");
//            Log.e("TAG", image.toString());
//            iv_image.setImageBitmap(image);


//            Log.e("TAG","URI :  "+imageUri.toString());
//            try {
//                Bitmap thumbnail = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
//                iv_image.setImageBitmap(thumbnail);
//                String imagepath = getRealPathFromURI(imageUri);
//                tv_selected_image_path.setText("URI : " + imageUri + "\n" +
//                        "PATH : " + imagepath);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                Log.e("TAG", e.toString());
//            }


            File file2=new File(currentPhotoPath);
            iv_image.setImageURI(Uri.fromFile(file2));

            Log.e("TAG","URI    : "+ Uri.fromFile(file2).toString());
          // String imagepath = getRealPathFromURI(Uri.fromFile(file2));
             tv_selected_image_path.setText("URI : " + Uri.fromFile(file2) + "\n" +
                        "PATH : " + Uri.fromFile(file2).getPath());
        }


    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] result) {
        super.onRequestPermissionsResult(requestCode, permissions, result);
        switch (requestCode) {
            case REQUEST_CAMERA_PERMISSION_CODE:
                if (result.length > 0 && result[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(TypeImageActivity.this, "Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show();
                    openCamera2();
                } else {
                    Toast.makeText(TypeImageActivity.this, "Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    public String getRealPathFromURI(Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }


    private boolean checkCameraPermission() {
        int result = ContextCompat.checkSelfPermission(TypeImageActivity.this, Manifest.permission.CAMERA);
        return (result == PackageManager.PERMISSION_GRANTED);
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }
}



/*extras -- This is a Bundle of any additional information.
 *This can be used to provide extended information to the component.
 *For example, if we have a action to send an e-mail message, we could also include
 *extra pieces of data here to supply a subject, body, etc
 */