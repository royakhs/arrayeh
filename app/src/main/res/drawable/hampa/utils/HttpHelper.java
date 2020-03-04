package com.arayeh.hampa.utils;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;

import com.arayeh.hampa.models.User;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.util.Iterator;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class HttpHelper {
    public static String downloadUrl(String apiAddress) throws Exception //throws Exception
    {
        try {
            URL url = new URL(apiAddress);
            HttpURLConnection httpConnnect = (HttpURLConnection) url.openConnection();

            httpConnnect.setRequestMethod("GET");
            httpConnnect.setReadTimeout(10000);
            httpConnnect.setConnectTimeout(5000);

            httpConnnect.connect();

            if (httpConnnect.getResponseCode() == 200) {
                InputStream stream = httpConnnect.getInputStream();
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                BufferedOutputStream output = new BufferedOutputStream(byteArray);
                int lenght = 0;
                byte[] buffer = new byte[1024];
                while ((lenght = stream.read(buffer)) > 0) {
                    output.write(buffer, 0, lenght);
                }
                output.flush();

                return byteArray.toString();
            } else {
                throw new Exception("Not Valid Response Code <>200");
            }
        } catch (Exception ex) {
            throw ex;
        }

    }

    public static String search(String apiAddress) throws Exception //throws Exception
    {
        try {
            URL url = new URL(apiAddress);
            HttpURLConnection httpConnnect = (HttpURLConnection) url.openConnection();

            httpConnnect.setRequestMethod("GET");
            httpConnnect.setReadTimeout(10000);
            httpConnnect.setConnectTimeout(5000);

            httpConnnect.connect();

            if (httpConnnect.getResponseCode() == 200) {
                InputStream stream = httpConnnect.getInputStream();
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                BufferedOutputStream output = new BufferedOutputStream(byteArray);

                int lenght = 0;
                byte[] buffer = new byte[1024];
                while ((lenght = stream.read(buffer)) > 0) {
                    output.write(buffer, 0, lenght);
                }

                output.flush();

                return byteArray.toString();
            } else {
                throw new Exception("Not Valid Response Code <>200");
            }

        } catch (Exception ex) {
            throw ex;
        }

    }

    public static void downloadAppNewVersion(String downloadLink, Context context) {
        String destination = Environment.getExternalStorageDirectory() + "/downloads/";
        String fileName = "Pharos-1.6.apk";
        destination += fileName;
        final Uri uri = Uri.parse("file://" + destination);

        //Delete update file if exists
        //   File file = new File(destination);
        File file = new File(Environment.getExternalStorageDirectory(), "downloads/Pharos-1.6.apk");
        // if (file.exists())
        //file.delete() - test this, I think sometimes it doesnt work
        //   file.delete();

        //get url of app on server
        String url = downloadLink;

        //set downloadmanager
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setDescription("mmm");
        request.setTitle("nn");

        //set destination
        request.setDestinationUri(uri);

        // get download service and enqueue file
        final DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        final long downloadId = manager.enqueue(request);

    }

    public static boolean canHit() {

        try {
            URL url = new URL("https://www.google.com/");
            HttpURLConnection urlConnection = (HttpURLConnection) url
                    .openConnection();
            urlConnection.setConnectTimeout(10000);
            urlConnection.setConnectTimeout(5000);
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                urlConnection.disconnect();
                return true;
            } else {
                urlConnection.disconnect();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static String update(User user, String apiAddress) throws Exception {
        // OutputStream out = null;

        apiAddress = apiAddress + encrypt(user);
        //  String urlAddress = apiAddress.replaceAll(" ", "%20");
        try {
            URL url = new URL(apiAddress);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(5000);
            // conn.setDoOutput(true);
            conn.connect();
            if (conn.getResponseCode() != 200) {

                throw new Exception(apiAddress);
            }
            return apiAddress;
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }
    public static String update(String apiAddress,String sms) throws Exception {
;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(sms.getBytes(StandardCharsets.UTF_8));
        apiAddress = apiAddress + encryptSMS(hash.toString());
        try {
            URL url = new URL(apiAddress);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(5000);
            // conn.setDoOutput(true);
            conn.connect();
            if (conn.getResponseCode() != 200) {

                throw new Exception(conn.getResponseMessage());
            }
            return conn.getResponseMessage();
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }

    public String insert(User user, String apiAddress) throws Exception {
        URL url;
        String response = "";
        try {
            url = new URL(apiAddress);
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(user.getPassword().getBytes(StandardCharsets.UTF_8));
            JSONObject postDataParams = new JSONObject();
            postDataParams.put("password", hash.toString());
            postDataParams.put("name", user.getName());
            postDataParams.put("family", user.getFamily());
            postDataParams.put("mobile", user.getMobile());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(5000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(postDataParams));

            writer.flush();
            writer.close();
            os.close();

            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                conn.getInputStream()));
                StringBuffer sb = new StringBuffer("");
                String line = "";

                while ((line = in.readLine()) != null) {

                    sb.append(line);
                    break;
                }

                in.close();
                return sb.toString();
            } else {
                throw new Exception(conn.toString());
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static String encrypt(User user) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(user.getPassword().getBytes(StandardCharsets.UTF_8));
        JSONObject postDataParams = new JSONObject();
        postDataParams.put("password", hash.toString());
        postDataParams.put("name", user.getName());
        postDataParams.put("family", user.getFamily());
        postDataParams.put("mobile", user.getMobile());
        // String a = Base64.encodeToString(postDataParams.toString().getBytes("utf-8"), Base64.DEFAULT);
        return postDataParams.toString();
        // return String.valueOf(postDataParams);
    }
    public static String encryptSMS(String sms) throws Exception {

        JSONObject postDataParams = new JSONObject();
        postDataParams.put("pass",sms);
        return postDataParams.toString();
    }

    public static SecretKey generateKey()
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        return new SecretKeySpec("22AFE96@52k!pc87".getBytes(), "AES");
    }

    public static byte[] encryptMsg(String message, SecretKey secret)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidParameterSpecException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        /* Encrypt the message. */
        Cipher cipher = null;
        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secret);
        byte[] cipherText = cipher.doFinal(message.getBytes("UTF-8"));
        return cipherText;
    }

//    public static String decryptMsg(byte[] cipherText, SecretKey secret)
//            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidParameterSpecException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException
//    {
//        /* Decrypt the message, given derived encContentValues and initialization vector. */
//        Cipher cipher = null;
//        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//        cipher.init(Cipher.DECRYPT_MODE, secret);
//        String decryptString = new String(cipher.doFinal(cipherText), "UTF-8");
//        return decryptString;
//    }

    public String makeURl(String data, String apiAddress) {
        return "url";

    }


    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while (itr.hasNext()) {

            String key = itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }

}
