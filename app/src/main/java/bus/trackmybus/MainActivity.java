package bus.trackmybus;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity {

    private AutoCompleteTextView actv;
    private AutoCompleteTextView mactv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] countries = getResources().
                getStringArray(R.array.list_of_countries);
        ArrayAdapter adapter = new ArrayAdapter
                (this,android.R.layout.simple_list_item_1,countries);

        ArrayAdapter adapter1 = new ArrayAdapter
                (this,android.R.layout.simple_list_item_1,countries);

        actv = (AutoCompleteTextView) findViewById(R.id.source);
        mactv = (AutoCompleteTextView) findViewById
                (R.id.destination);


        actv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actv.setText("");
                actv.setDropDownBackgroundResource(R.color.listcolor);
            }
        });

        mactv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mactv.setText("");
                mactv.setDropDownBackgroundResource(R.color.listcolor);
            }
        });

        actv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!actv.isSelected()) {

                    actv.setText("Where are you currently?");
                }
            }
        });

        actv.setAdapter(adapter);
        mactv.setAdapter(adapter1);

        Button getRoutesButton = (Button) findViewById(R.id.getRoutes);

        getRoutesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               invokeWS(null);
//                Toast.makeText(view.getContext(), str + "Hie..", Toast.LENGTH_SHORT).show();
            }
        });
//        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void invokeWS(RequestParams params){
        // Show Progress Dialog
//        prgDialog.show();
        // Make RESTful webservice call using AsyncHttpClient object
        Toast.makeText(getApplicationContext(), "This is a toast Called", Toast.LENGTH_SHORT).show();
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.3:8080/RESTful_Jersey_Hello_World/rest/helloworld", null ,new AsyncHttpResponseHandler() {
            // When the response returned by REST has Http response code '200'
            @Override
            public void onSuccess(String response) {
                // Hide Progress Dialog
//                prgDialog.hide();
                try {
                    Toast.makeText(getApplicationContext(), "This is a toast in success" + response, Toast.LENGTH_SHORT).show();
                    // JSON Object
                    JSONObject obj = new JSONObject(response);
                    Toast.makeText(getApplicationContext(), "This is a toast " + obj.toString(), Toast.LENGTH_SHORT).show();
                    // When the JSON response has status boolean value assigned with true
                    if(obj.getBoolean("status")){
                        // Set Default Values for Edit View controls
//                        setDefaultValues();
                        // Display successfully registered message using Toast
//                        Toast.makeText(getApplicationContext(), "You are successfully registered!", Toast.LENGTH_LONG).show();
                    }
                    // Else display error message
                    else{
//                        errorMsg.setText(obj.getString("error_msg"));
//                        Toast.makeText(getApplicationContext(), obj.getString("error_msg"), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
//                    Toast.makeText(getApplicationContext(), "Error Occured [Server's JSON response might be invalid]!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();

                }
            }
            // When the response returned by REST has Http response code other than '200'
            @Override
            public void onFailure(int statusCode, Throwable error,
                                  String content) {
                // Hide Progress Dialog
//                prgDialog.hide();
                // When Http response code is '404'
                Toast.makeText(getApplicationContext(), "This is a toast in failure", Toast.LENGTH_SHORT).show();
                if(statusCode == 404){
//                    Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
                }
                // When Http response code is '500'
                else if(statusCode == 500){
//                    Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
                }
                // When Http response code other than 404, 500
                else{
//                    Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}