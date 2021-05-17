package sg.edu.rp.c346.id19008424.p04problemstatement;

import android.content.Context;
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

        tvTitle = rowVIew.findViewById(R.id.tvTitle);
        tvYear = rowVIew.findViewById(R.id.tvYear);
        tvSinger = rowVIew.findViewById(R.id.tvSinger);
        rating = rowVIew.findViewById(R.id.rbStars);

        Song song = songs.get(position);
        tvYear.setText(song.getYear());
        tvTitle.setText(song.getTitle());
        tvSinger.setText(song.getSingers());
        rating.setNumStars(song.getStars());
//        tvNotes.setText(note.getNoteContent());

        return rowVIew;

    }
}
