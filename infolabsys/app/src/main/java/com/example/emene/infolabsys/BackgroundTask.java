package com.example.emene.infolabsys;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emene.infolabsys.Classes.Exame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by emene on 23/03/2018.
 */

public class BackgroundTask extends AsyncTask<String,Void, String> {


    AlertDialog alertDialog;
    Context ctx;

    public BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Informações do Login....");
    }

    @Override
    protected String doInBackground(String... params) {
        //indica o caminho do banco de dados.

        String reg_url = "http://192.168.0.9:8080/infolabsys/registro.php";
        String login_url = "http://192.168.0.9:8080/infolabsys/login.php";
        String method = params[0];


        if (method.equals("cadastroUsuario")) {
            String user_name = params[1];
            String user_pass = params[2];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                //httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter
                        (OS, "UTF-8"));
                String data =
                        URLEncoder.encode("user_name", "UTF-8") + "=" +
                                URLEncoder.encode(user_name, "UTF-8") + "&" +
                        URLEncoder.encode("user_pass", "UTF-8") + "=" +
                                URLEncoder.encode(user_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                //httpURLConnection.connect();
                httpURLConnection.disconnect();
                return "Registrado com Sucesso...";


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if (method.equals("login")) {

            String login_nome = params[1];
            String login_pass = params[2];
            String log;
            try {

                // incia a conexão
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                //verifica a conexão
                OutputStream outputStream = httpURLConnection.getOutputStream();
                //formatação de padrões
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter
                        (outputStream, "UTF-8"));
                String data = URLEncoder.encode("login_nome", "UTF-8") + "=" +
                        URLEncoder.encode(login_nome, "UTF-8") + "&" +
                        URLEncoder.encode("login_pass", "UTF-8") + "=" +
                        URLEncoder.encode(login_pass, "UTF-8");
                //edita
                bufferedWriter.write(data);
                //insere
                bufferedWriter.flush();
                //fecha
                bufferedWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader
                        (new InputStreamReader(inputStream, "iso-8859-1"));

                //limpa
                String response = "";
                String line = "";

                //verifica linhas do banco
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;


                    }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return response;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


        return null;

    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if(result != null) {
            if (result.equals("Registrado com Sucesso...")) {
                Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();

            } else {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
        }else{
            Log.i("Erro",result);
        }

    }

    /**
     * Created by emene on 03/04/2018.
     */


}