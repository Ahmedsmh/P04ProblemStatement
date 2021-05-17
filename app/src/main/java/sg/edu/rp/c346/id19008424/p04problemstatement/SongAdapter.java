package sg.edu.rp.c346.id19008424.p04problemstatement;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    Context context;
    ArrayList<Song> songs;
    int resource;
    TextView tvTitle, tvSinger, tvYear;
    RatingBar rating;
    ImageView image, imgStar1, imgStar2, imgStar3, imgStar4, imgStar5;

    public SongAdapter(Context context, int resource, ArrayList<Song> songs){
        super(context, resource, songs);
        this.context = context;
        this.songs = songs;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowVIew = inflater.inflate(resource, parent, false);

        image = rowVIew.findViewById(R.id.imageView);
        tvTitle = rowVIew.findViewById(R.id.tvTitle);
        tvYear = rowVIew.findViewById(R.id.tvYear);
        tvSinger = rowVIew.findViewById(R.id.tvSinger);
        imgStar1 = rowVIew.findViewById(R.id.imageStar1);
        imgStar2 = rowVIew.findViewById(R.id.imageStar2);
        imgStar3 = rowVIew.findViewById(R.id.imageStar3);
        imgStar4 = rowVIew.findViewById(R.id.imageStar4);
        imgStar5 = rowVIew.findViewById(R.id.imageStar5);


        Song song = songs.get(position);
       //image.setImageResource(android.R.drawable.ic_li);
        tvYear.setText("" + song.getYear());
        tvTitle.setText(song.getTitle());
        tvSinger.setText(song.getSingers());


        if (song.getStars() == 1){
            imgStar1.setImageResource(android.R.drawable.btn_star_big_on);
        }
        else if (song.getStars() == 2){
            imgStar2.setImageResource(android.R.drawable.btn_star_big_on);
            imgStar1.setImageResource(android.R.drawable.btn_star_big_on);
        }
        else if (song.getStars() ==  3){
            imgStar3.setImageResource(android.R.drawable.btn_star_big_on);
            imgStar2.setImageResource(android.R.drawable.btn_star_big_on);
            imgStar1.setImageResource(android.R.drawable.btn_star_big_on);
        }
        else if (song.getStars() == 4){
            imgStar4.setImageResource(android.R.drawable.btn_star_big_on);
            imgStar3.setImageResource(android.R.drawable.btn_star_big_on);
            imgStar2.setImageResource(android.R.drawable.btn_star_big_on);
            imgStar1.setImageResource(android.R.drawable.btn_star_big_on);
        }
        //Check if the property for starts >= 5, if so, "light" up the stars
        else if (song.getStars()>= 5) {
            imgStar5.setImageResource(android.R.drawable.btn_star_big_on);
            imgStar4.setImageResource(android.R.drawable.btn_star_big_on);
            imgStar3.setImageResource(android.R.drawable.btn_star_big_on);
            imgStar2.setImageResource(android.R.drawable.btn_star_big_on);
            imgStar1.setImageResource(android.R.drawable.btn_star_big_on);
        }

        return rowVIew;

    }
}
