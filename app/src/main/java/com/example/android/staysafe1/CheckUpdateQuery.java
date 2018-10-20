package com.example.android.staysafe1;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckUpdateQuery extends AsyncTask<String,String,String>
{


    Connection con;
    String phonenumber,flag,str="",un="Adroitadmin1@adroit",pass="Adroitpassword1",db="codefundo-db",ip="adroit.database.windows.net:1433";
    Double lat,lon;
    String z = "default";
    Boolean isSuccess = false;

    CheckUpdateQuery(String ph,Double l1,Double l2,String status){
        super();
        phonenumber=ph;
        lat=l1;
        lon=l2;
        flag=status;

    }
    @Override
    protected void onPreExecute()
    {
//            progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(String r)
    {
//            progressBar.setVisibility(View.GONE);
//        Toast.makeText(MainActivity.this, r, Toast.LENGTH_SHORT).show();
//        if(isSuccess)
//        {
//            Toast.makeText(MainActivity.this , "Login Successfull" , Toast.LENGTH_LONG).show();
//            //finish();
//        }
        if(z!=null)
            Log.v("zval",z);
        else
            Log.v("zisnull","zisnull");
    }
    @Override
    protected String doInBackground(String... params)
    {
        String usernam = un;
        String passwordd = pass;
        if(usernam.trim().equals("")|| passwordd.trim().equals(""))
            z = "Please enter Username and Password";
        else
        {
            try
            {
                con = connectionclass(un, pass, db, ip);        // Connect to database
                if (con == null)
                {
                    z = "Check Your Internet Access!";
                    throw new Exception();
                }
                else
                {
                    // Change below query according to your own database.
                    String query = "update location2  set lat="+lat+",lon="+lon+",flag=\'"+flag+"\' where id = \'"+phonenumber+"\';";
                    Log.v("iamhere","iamhere"+lat+lon);
                    Statement stmt = con.createStatement();Log.v("iamhere2","iamhere2");
//                    ResultSet rs =
                    stmt.execute(query);
                    Log.v("checkquery","checkquery");
//                        while (rs.next())
//                        {
//                            str=str+rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+"\n";
//                        }
//                        Log.v("strfromdb",str);
//                        runOnUiThread(new Runnable() {
//
//                            @Override
//                            public void run() {
//
//                                // Stuff that updates the UI
//                                tv1.setText(str);
//                                str="";
//
//                            }
//                        });

//                        else
//                        {
//                            z = "Invalid Credentials!";
//                            isSuccess = false;
//                        }
                }
            }
            catch (Exception ex)
            {
                isSuccess = false;
                z = ex.getMessage() + " check";
            }
        }
        return z;
    }

    @SuppressLint("NewApi")
    public Connection connectionclass(String user, String password, String database, String server)
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;
        try
        {   Log.v("hahaha","hahaha");
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Log.v("classcreated","classcreated");
            ConnectionURL = "jdbc:jtds:sqlserver://" + server +";databaseName="+ database + ";user=" + user+ ";password=" + password + ";;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            connection = DriverManager.getConnection(ConnectionURL);
        }
        catch (SQLException se)
        {
            Log.e("errorhere 1 : ", se.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            Log.e("errorhere 2 : ", e.getMessage());
        }
        catch (Exception e)
        {
            Log.e("errorhere 3 : ", e.getMessage());
        }
        return connection;
    }
}


