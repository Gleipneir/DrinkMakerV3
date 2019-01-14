package neir.gleip.drinkmakerv3;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CommunicateActivity extends AppCompatActivity {
    private List<Drink> drinkList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DrinkAdapter dAdapter;
    private TextView connectionText;
    String Selected_Drink;
    //private TextView connectionText,messagesView;
  //  private EditText messageBox;
    private Button sendButton;
    //private Button sendButton, connectButton;

    private CommunicateViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Setup our activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communicate);
        // Enable the back button in the action bar if possible
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Setup our ViewModel
        viewModel = ViewModelProviders.of(this).get(CommunicateViewModel.class);

        // This method return false if there is an error, so if it does, we should close.
        if (!viewModel.setupViewModel(getIntent().getStringExtra("device_name"), getIntent().getStringExtra("device_mac"))) {
            finish();
            return;
        }

        // Setup our Views
        connectionText = findViewById(R.id.communicate_connection_text);
        //messagesView = findViewById(R.id.communicate_messages);
        //messageBox = findViewById(R.id.communicate_message);
        sendButton = findViewById(R.id.communicate_send);
     //   connectButton = findViewById(R.id.communicate_connect);




        // Start observing the data sent to us by the ViewModel
        viewModel.getConnectionStatus().observe(this, this::onConnectionStatus);
        viewModel.getDeviceName().observe(this, name -> setTitle(getString(R.string.device_name_format, name)));

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Setup the send button click action
        //sendButton.setOnClickListener(v -> viewModel.sendMessage(messageBox.getText().toString()));
               sendButton.setOnClickListener(v -> viewModel.sendMessage(Selected_Drink));
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Called when the ViewModel updates us of our connectivity status
    private void onConnectionStatus(CommunicateViewModel.ConnectionStatus connectionStatus) {
        switch (connectionStatus) {

            case CONNECTED:
                connectionText.setText(R.string.status_connected);
               // messageBox.setEnabled(true);
                sendButton.setEnabled(true);
                startRecyclerView();
                //connectButton.setEnabled(true);
               // connectButton.setText(R.string.disconnect);
               // connectButton.setOnClickListener(v -> viewModel.disconnect());

                break;

            case CONNECTING:
                connectionText.setText(R.string.status_connecting);
               // messageBox.setEnabled(false);
                sendButton.setEnabled(false);
                //connectButton.setEnabled(false);
                //connectButton.setText(R.string.connect);
                break;

            case DISCONNECTED:
                connectionText.setText(R.string.status_disconnected);
              //  messageBox.setEnabled(false);
                sendButton.setEnabled(false);
                //connectButton.setEnabled(true);
               // connectButton.setText(R.string.connect);
              //  connectButton.setOnClickListener(v -> viewModel.connect());
                break;
        }
    }

    // Called when a button in the action bar is pressed
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                // If the back button was pressed, handle it the normal way
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Called when the user presses the back button
    @Override
    public void onBackPressed() {
        // Close the activity
        finish();
    }

//

//

//
//ALL STUFF FOR RECYCLERVEIW
//
    private void startRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        dAdapter = new DrinkAdapter(drinkList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(dAdapter);
        prepareMovieData();
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Drink drink = drinkList.get(position);
                Toast.makeText(getApplicationContext(), drink.getName() + " is selected!", Toast.LENGTH_SHORT).show();
                Selected_Drink =drink.getName();

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

private void prepareMovieData() {
        //to chance drink hit labels go to Drink.java and find and replace all words with drink4

  Drink drink = new Drink("Water", "None", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    drinkList.add(drink);
    //-
     drink = new Drink("Long Island", "All", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    drinkList.add(drink);
    //-
     drink = new Drink("Barbados Sunrise", "Rum", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    drinkList.add(drink);
    //-
    drink = new Drink("Vodka", "Vodka", "80", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    drinkList.add(drink);
    //-
    drink = new Drink("Drink3", "None", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    drinkList.add(drink);
    //-
    drink = new Drink("Drink4", "None", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    drinkList.add(drink);
    //-
    drink = new Drink("Drink5", "None", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    drinkList.add(drink);
    //-
    drink = new Drink("Drink6", "None", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    drinkList.add(drink);
    //-
    drink = new Drink("Drink7", "None", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    drinkList.add(drink);
    //-
    drink = new Drink("Drink8", "None", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    drinkList.add(drink);
    //-
    drink = new Drink("Drink9", "None", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    drinkList.add(drink);
    //-
    drink = new Drink("Drink10", "None", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    drinkList.add(drink);
    //-











    dAdapter.notifyDataSetChanged();
}


}