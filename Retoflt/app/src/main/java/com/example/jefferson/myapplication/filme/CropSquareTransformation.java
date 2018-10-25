package com.example.jefferson.myapplication.filme;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Transformation;

import java.io.InputStream;

public class CropSquareTransformation implements Transformation{

    public  Bitmap transform(Bitmap source){
        int size= Math.min(source.getWidth(),source.getHeight());
        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;
        Bitmap result = Bitmap.createBitmap(source,x,y,size,size);
        if(result != source){
            source.recycle();
        }
        return result;
    }

    public String key(){
        return "square()";
    }
}
