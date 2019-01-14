package neir.gleip.drinkmakerv3;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.MyViewHolder> {

    public List<Drink> drinkList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //public TextView title, percentage, main_alcohol, drink1, drink2, drink3, drink4, drink5, drink6, drink7, drink8, drink9, drink10, drink11, drink12, drink13, drink14, drink15, drink16, drink17, drink18, drink19, drink20, drink21, drink22, drink23, drink24, drink25, drink26, drink27, drink28, drink29, drink30;
        public TextView title, percentage, main_alcohol;
        private MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.name);
            main_alcohol =  view.findViewById(R.id.main_alcohol);
            percentage =  view.findViewById(R.id.percentage);

//            drink1 = (TextView) view.findViewById(R.id.drink1);
//            drink2 = (TextView) view.findViewById(R.id.drink2);
//            drink3 = (TextView) view.findViewById(R.id.drink3);
//            drink4 = (TextView) view.findViewById(R.id.drink4);
//            drink5 = (TextView) view.findViewById(R.id.drink5);
//            drink6 = (TextView) view.findViewById(R.id.drink6);
//            drink7 = (TextView) view.findViewById(R.id.drink7);
//            drink8 = (TextView) view.findViewById(R.id.drink8);
//            drink9 = (TextView) view.findViewById(R.id.drink9);
//            drink10 = (TextView) view.findViewById(R.id.drink10);
//
//            drink11 = (TextView) view.findViewById(R.id.drink11);
//            drink12 = (TextView) view.findViewById(R.id.drink12);
//            drink13 = (TextView) view.findViewById(R.id.drink13);
//            drink14 = (TextView) view.findViewById(R.id.drink14);
//            drink15 = (TextView) view.findViewById(R.id.drink15);
//            drink16 = (TextView) view.findViewById(R.id.drink16);
//            drink17 = (TextView) view.findViewById(R.id.drink17);
//            drink18 = (TextView) view.findViewById(R.id.drink18);
//            drink19 = (TextView) view.findViewById(R.id.drink19);
//            drink20 = (TextView) view.findViewById(R.id.drink20);
//
//            drink21 = (TextView) view.findViewById(R.id.drink21);
//            drink22 = (TextView) view.findViewById(R.id.drink22);
//            drink23 = (TextView) view.findViewById(R.id.drink23);
//            drink24 = (TextView) view.findViewById(R.id.drink24);
//            drink25 = (TextView) view.findViewById(R.id.drink25);
//            drink26 = (TextView) view.findViewById(R.id.drink26);
//            drink27 = (TextView) view.findViewById(R.id.drink27);
//            drink28 = (TextView) view.findViewById(R.id.drink28);
//            drink29 = (TextView) view.findViewById(R.id.drink29);
//            drink30 = (TextView) view.findViewById(R.id.drink30);

        }
    }


    public DrinkAdapter(List<neir.gleip.drinkmakerv3.Drink> drinksList) {
        this.drinkList = drinksList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drink_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Drink drink = drinkList.get(position);
        holder.title.setText(drink.getName());
        holder.main_alcohol.setText(drink.getMain_alcohol());
        holder.percentage.setText(drink.getPercentage());

//        holder.drink1.setText(drink.getDrink1());
//        holder.drink2.setText(drink.getDrink2());
//        holder.drink3.setText(drink.getDrink3());
//        holder.drink4.setText(drink.getDrink4());
//        holder.drink5.setText(drink.getDrink5());
//        holder.drink6.setText(drink.getDrink6());
//        holder.drink7.setText(drink.getDrink7());
//        holder.drink8.setText(drink.getDrink8());
//        holder.drink9.setText(drink.getDrink9());
//        holder.drink10.setText(drink.getDrink10());
//
//        holder.drink11.setText(drink.getDrink11());
//        holder.drink12.setText(drink.getDrink12());
//        holder.drink13.setText(drink.getDrink13());
//        holder.drink14.setText(drink.getDrink14());
//        holder.drink15.setText(drink.getDrink15());
//        holder.drink16.setText(drink.getDrink16());
//        holder.drink17.setText(drink.getDrink17());
//        holder.drink18.setText(drink.getDrink18());
//        holder.drink19.setText(drink.getDrink19());
//        holder.drink20.setText(drink.getDrink20());
//
//        holder.drink21.setText(drink.getDrink21());
//        holder.drink22.setText(drink.getDrink22());
//        holder.drink23.setText(drink.getDrink23());
//        holder.drink24.setText(drink.getDrink24());
//        holder.drink25.setText(drink.getDrink25());
//        holder.drink26.setText(drink.getDrink26());
//        holder.drink27.setText(drink.getDrink27());
//        holder.drink28.setText(drink.getDrink28());
//        holder.drink29.setText(drink.getDrink29());
//        holder.drink30.setText(drink.getDrink30());




    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }
}
