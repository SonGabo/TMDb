package xyz.gabrielrohez.themoviedb.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.gabrielrohez.themoviedb.R;
import xyz.gabrielrohez.themoviedb.data.room.entity.MoviesEntity;
import xyz.gabrielrohez.themoviedb.utils.AppConfig;
import xyz.gabrielrohez.themoviedb.utils.AppConstants;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private List<MoviesEntity> list;
    private MoviesAdapterIn listener;

    public interface MoviesAdapterIn {
        void onItemClick(MoviesEntity movie);
    }

    public MoviesAdapter(List<MoviesEntity> list, MoviesAdapterIn listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(AppConfig.getAppContext()).inflate(R.layout.item_movies, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(list.get(i).getOriginal_title());
        viewHolder.rate.setText(list.get(i).getVote_average());
        Glide.with(AppConfig.getAppContext())
                .load(AppConstants.BASE_URL_IMAGE+list.get(i).getPoster_path())
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .placeholder(R.drawable.default_placeholder)
                .into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.topImageMovie)
        ImageView image;
        @BindView(R.id.topNameMovie)
        TextView name;
        @BindView(R.id.topRate)
        TextView rate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(list.get(getAdapterPosition()));
                }
            });
        }
    }

    public void updateList(List<MoviesEntity> newList) {
        list = new ArrayList<>();
        list.addAll(newList);
        notifyDataSetChanged();
    }
}
