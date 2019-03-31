package edu.itm.aiforhrrecruit.Adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.itm.aiforhrrecruit.R;
import edu.itm.aiforhrrecruit.model.predictModel;


/**
 * Created by saiso on 03-02-2017.
 */
public class SingleTextAdapter extends ArrayAdapter<predictModel> {

    public int x=1,itemIndex=0;
    private static final String TAG = "SingleText";

    private final Activity activity;
    List<predictModel> citylist = new ArrayList<predictModel>();
    public ViewHolder holder;
    Typeface custom_font, custom_font1;

    public SingleTextAdapter(Activity activity,
                             List<predictModel> citylist) {
        super(activity, R.layout.item_single, citylist);
        this.activity = activity;
        this.citylist = citylist;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.item_single, null, true);
            holder = new ViewHolder();

            holder.nameTextView = (TextView) view.findViewById(R.id.addressTextView);
            holder.cardView = (CardView) view.findViewById(R.id.card);
            holder.timeTextView = (TextView) view.findViewById(R.id.timeTextView);
            holder.timeetaTextView = (TextView) view.findViewById(R.id.timeetaTextView);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }


//        custom_font = Typeface.createFromAsset(activity.getAssets(),  "fonts/bold.ttf");
//        custom_font1 = Typeface.createFromAsset(activity.getAssets(),  "fonts/normal.ttf");
//        holder.nameTextView.setTypeface(custom_font);
//        holder.timeTextView.setTypeface(custom_font1);
//        holder.timeetaTextView.setTypeface(custom_font1);


           // holder.cardView.setBackgroundColor(activity.getResources().getColor(R.color.red));
            holder.nameTextView.setText(citylist.get(position).getName());
            holder.timeTextView.setText(citylist.get(position).getScore());
            holder.timeetaTextView.setText(citylist.get(position).getMonths());




        return view;
    }

    static class ViewHolder {
        TextView nameTextView;
        TextView timeTextView;
        TextView timeetaTextView;
        CardView cardView;

    }

    public String getTime(long milli){

        return  DateFormat.format("MM-dd hh:mm ", milli).toString();
    }


}
