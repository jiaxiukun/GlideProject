package baway.com.glideproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * date:2017/7/11
 * author:贾秀坤(leovo)
 * funcation:
 */

public class MyAdpter extends BaseAdapter {
    private ArrayList<User> list;
    private Context mContext;

    public MyAdpter(ArrayList<User> list, Context context) {
        this.list = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder v;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.image, null);
            v = new ViewHolder();
            v.mImageView = (ImageView) convertView.findViewById(R.id.imageview);
            convertView.setTag(v);
        } else {
            v = (ViewHolder) convertView.getTag();
        }
        User user = list.get(position);
        if (user.url != null && user.url.length() > 2) {
            Glide.with(mContext).load(user.url).placeholder(R.mipmap.ic_launcher).error(R.mipmap.error).crossFade().override(600, 200).into(v.mImageView);
        } else {
            Glide.with(mContext).load(user.photo).into(v.mImageView);
        }
        return convertView;
    }

    class ViewHolder {
        private ImageView mImageView;
    }
}
