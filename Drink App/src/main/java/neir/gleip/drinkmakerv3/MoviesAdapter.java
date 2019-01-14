package neir.gleip.drinkmakerv3;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Drink> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, percentage, main_alcohol;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.name);
            main_alcohol = (TextView) view.findViewById(R.id.main_alcohol);
            percentage = (TextView) view.findViewById(R.id.percentage);
        }
    }


    public MoviesAdapter(List<neir.gleip.drinkmakerv3.Drink> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Drink movie = moviesList.get(position);
        holder.title.setText(movie.getName());
        holder.main_alcohol.setText(movie.getMain_alcohol());
        holder.percentage.setText(movie.getPercentage());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
