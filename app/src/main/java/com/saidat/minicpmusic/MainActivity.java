package com.saidat.minicpmusic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edtx_16 = (EditText) findViewById(R.id.editText);
        final EditText edtx_x = (EditText) findViewById(R.id.editText2);
        ListView lv = (ListView) findViewById(R.id.listView);
        Button bt = (Button) findViewById(R.id.button);
        Button cl01 = (Button) findViewById(R.id.clear);
        Button cl02 = (Button) findViewById(R.id.clear2);
        final TextView tx = (TextView) findViewById(R.id.txAfter);
        String mcName[] =
                {       "ド    :83 E8" ,
                        "ド＃  :8B DD" ,
                        "レ    :93 D1" ,
                        "レ＃  :9C C5" ,
                        "ミ    :A5 BA" ,
                        "ファ  :AF AF" ,
                        "ファ＃:B9 A6" ,
                        "ソ    :C4 9C" ,
                        "ソ＃  :D0 93" ,
                        "ラ    :DC 8B" ,
                        "ラ＃  :E9 83" ,
                        "シ    :F7 7C" ,
                        "ド    :FF 75"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,mcName);
        lv.setAdapter(adapter);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String tmp = "";
                switch (position) {
                    case 0:
                        tmp = "83";
                        break;
                    case 1:
                        tmp = "8B";
                        break;
                    case 2:
                        tmp = "93";
                        break;
                    case 3:
                        tmp = "9C";
                        break;
                    case 4:
                        tmp = "A5";
                        break;
                    case 5:
                        tmp = "AF";
                        break;
                    case 6:
                        tmp = "B9";
                        break;
                    case 7:
                        tmp = "C4";
                        break;
                    case 8:
                        tmp = "D0";
                        break;
                    case 9:
                        tmp = "DC";
                        break;
                    case 10:
                        tmp = "E9";
                        break;
                    case 11:
                        tmp = "F7";
                        break;
                    case 12:
                        tmp = "FF";
                        break;
                }
                edtx_16.setText(tmp);
                String msg = "変換前16進に選択した長さを入力しました";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int input2 = 0, tmps;
                String tmp = "0x" + edtx_16.getText().toString();//入力16進
                if (!(tmp.equals("0x"))) {
                    int inputI1 = Integer.decode(tmp);//16進数を10にした
                    tmp = edtx_x.getText().toString();
                    if (tmp.equals("")) tmp = "1";
                    float tmpF = Float.parseFloat(tmp);//長さ倍率
                    tmpF = inputI1 * tmpF;
                    int out01 = Math.round(tmpF);
                    String afterOut = Integer.toHexString(out01);//16進数に
                    tx.setText(afterOut);
                    tx.setVisibility(View.VISIBLE);
                }
            }
        });

        cl01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtx_16.setText("");
            }
        });

        cl02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtx_x.setText("");
            }
        });
    }

}
