package com.aspose.cloud.sdk.cells;
import java.io.InputStream;
import java.util.List;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.google.gson.Gson;

public class TextEditor
    {
        /// <summary>
        /// TextEditor Class Constructor
        /// </summary>
        public TextEditor(String fileName)
        {
            this.fileName = fileName;
            gson = new Gson();

        }

        public List<TextItem> findText(String text) throws Exception
        {
            //check whether file is set or not
            if (fileName.equals(""))
                throw new Exception("No file name specified");

            //build URI
            String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
            strURI += "/findText?text=" + text;

            //sign URI
            String signedURI = Utils.sign(strURI);

            InputStream responseStream = Utils.processCommand(signedURI, "POST");

            //further process JSON response
            String strJSON = Utils.streamToString(responseStream);            

            //Deserializes the JSON to a object. 
            TextEditorResponse textEditorResponse = gson.fromJson(strJSON,TextEditorResponse.class);

            return textEditorResponse.getTextItems().getTextItemList();

        }

        public int replaceText(String oldText,String newText) throws Exception
        {
            //check whether file is set or not
            if (fileName.equals(""))
                throw new Exception("No file name specified");

            //build URI
            String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
            strURI += "/replaceText?oldValue=" + oldText + "&newValue=" + newText;
            
            //sign URI
            String signedURI = Utils.sign(strURI);

            InputStream responseStream = Utils.processCommand(signedURI, "POST");

            //further process JSON response
            String strJSON = Utils.streamToString(responseStream);   
           
            //Deserializes the JSON to a object. 
            TextEditorResponse textEditorResponse = gson.fromJson(strJSON,TextEditorResponse.class);

            return textEditorResponse.getMatches();

        }
        public List<TextItem> getTextItems() throws Exception
        {
            //check whether file is set or not
            if (fileName.equals(""))
                throw new Exception("No file name specified");

            //build URI
            String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
            strURI += "/textItems";

            //sign URI
            String signedURI = Utils.sign(strURI);

            InputStream responseStream = Utils.processCommand(signedURI, "GET");

            //further process JSON response
            String strJSON = Utils.streamToString(responseStream);   
           
            //Deserializes the JSON to a object. 
            TextEditorResponse textEditorResponse = gson.fromJson(strJSON,TextEditorResponse.class);

            return textEditorResponse.getTextItems().getTextItemList();

        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="text"></param>
        /// <returns></returns>
        public List<TextItem> findText(String WorkSheetName,String text) throws Exception
        {
            //check whether file is set or not
            if (fileName.equals(""))
                throw new Exception("No file name specified");

            //build URI
            String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
            strURI += "/worksheets/" + WorkSheetName + "/findText?text=" + text;

            //sign URI
            String signedURI = Utils.sign(strURI);

            InputStream responseStream = Utils.processCommand(signedURI, "POST");

            //further process JSON response
            String strJSON = Utils.streamToString(responseStream);   
           
            //Deserializes the JSON to a object. 
            TextEditorResponse textEditorResponse = gson.fromJson(strJSON,TextEditorResponse.class);

            return textEditorResponse.getTextItems().getTextItemList();

        }
        public int replaceText(String workSheet, String oldText, String newText) throws Exception
        {
            //check whether file is set or not
            if (fileName.equals(""))
                throw new Exception("No file name specified");

            //build URI
            String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
            strURI += "/worksheets/"+workSheet+"/replaceText?oldValue=" + oldText + "&newValue=" + newText;

            //sign URI
            String signedURI = Utils.sign(strURI);

            InputStream responseStream = Utils.processCommand(signedURI, "POST");

            //further process JSON response
            String strJSON = Utils.streamToString(responseStream);   
           
            //Deserializes the JSON to a object. 
            TextEditorResponse textEditorResponse = gson.fromJson(strJSON,TextEditorResponse.class);

            return textEditorResponse.getMatches();

        }
        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
        public List<TextItem> getTextItems(String WorkSheetName) throws Exception
        {
            //check whether file is set or not
            if (fileName.equals(""))
                throw new Exception("No file name specified");

            //build URI
            String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName + "/textItems";

            //sign URI
            String signedURI = Utils.sign(strURI);

            InputStream responseStream = Utils.processCommand(signedURI, "GET");

            //further process JSON response
            String strJSON = Utils.streamToString(responseStream);   
           
            //Deserializes the JSON to a object. 
            TextEditorResponse textEditorResponse = gson.fromJson(strJSON,TextEditorResponse.class);

            return textEditorResponse.getTextItems().getTextItemList();

        }

        Gson gson =null;
        
        public String fileName ;
    }