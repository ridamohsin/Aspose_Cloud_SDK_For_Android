package com.aspose.cloud.sdk.cells;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.Utils;
import com.google.gson.Gson;


public class ChartEditor
    {
        /// <summary>
        /// ChartEditor Class Constructor
        /// </summary>
        public ChartEditor(String fileName,String worksheetName)
        {
            this.fileName = fileName;
            this.workSheetName = worksheetName;
            
            gson = new Gson();

        }

        public boolean addChart(ChartType chartType, int upperLeftRow, int upperLeftColumn, int lowerRightRow, int lowerRightColumn) throws Exception
        {
            try
            {
                //build URI to get page count
                String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
                strURI += "/worksheets/" + workSheetName + "/charts?chartType=" + chartType + "&upperLeftRow=" + upperLeftRow +
                    "&upperLeftColumn=" + upperLeftColumn + "&lowerRightRow=" + lowerRightRow + "&lowerRightColumn=" + lowerRightColumn;
                
                String signedURI = Utils.sign(strURI);

                InputStream responseStream = Utils.processCommand(signedURI, "GET");

                //further process JSON response
                String strJSON = Utils.streamToString(responseStream);   
               

                BaseResponse baseResponse = gson.fromJson(strJSON,BaseResponse.class);

                if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK"))
                    return true;
                else
                    return false;


            }
            catch (Exception ex)
            {
                throw new Exception(ex.getMessage());
            }
        }

        public boolean deleteChart(int chartIndex) throws Exception
        {
            //check whether file is set or not
            if (fileName == "")
                throw new Exception("No file name specified");

            //build URI
            String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
            strURI += "/worksheets/" + workSheetName + "/charts/" + chartIndex;

            //sign URI
            String signedURI = Utils.sign(strURI);

            InputStream responseStream = Utils.processCommand(signedURI, "DELETE");

            //further process JSON response
            String strJSON = Utils.streamToString(responseStream);   
           

            BaseResponse baseResponse = gson.fromJson(strJSON,BaseResponse.class);

            if ( baseResponse.getStatus().equals("OK"))
               return true;
            else
                return false;
        }
        
        public ChartArea getChartArea(int chartIndex) throws Exception
        {
            //check whether file is set or not
            if (fileName.equals(""))
                throw new Exception("No file name specified");

            //build URI
            String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
            strURI += "/worksheets/" + workSheetName + "/charts/" + chartIndex + "/chartArea";

            //sign URI
            String signedURI = Utils.sign(strURI);

            InputStream responseStream = Utils.processCommand(signedURI, "GET");

            //further process JSON response
            String strJSON = Utils.streamToString(responseStream);   
    

            //Deserializes the JSON to a object. 
            ChartEditorResponse chartResponse = gson.fromJson(strJSON,ChartEditorResponse.class);

            return chartResponse.getChartArea();
        }

        public FillFormat getFillFormat(int chartIndex) throws Exception
        {
            //check whether file is set or not
            if (fileName.equals(""))
                throw new Exception("No file name specified");

            //build URI
            String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
            strURI += "/worksheets/" + workSheetName + "/charts/" + chartIndex + "/chartArea/fillFormat";

            //sign URI
            String signedURI = Utils.sign(strURI);

            InputStream responseStream = Utils.processCommand(signedURI, "GET");

            //further process JSON response
            String strJSON = Utils.streamToString(responseStream);   
    

            //Deserializes the JSON to a object. 
            ChartEditorResponse chartResponse = gson.fromJson(strJSON,ChartEditorResponse.class);

            return chartResponse.getFillFormat();
        }

        public Line getBorder(int chartIndex) throws Exception
        {
            //check whether file is set or not
            if (fileName.equals(""))
                throw new Exception("No file name specified");

            //build URI
            String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
            strURI += "/worksheets/" + workSheetName + "/charts/" + chartIndex + "/chartArea/border";

            //sign URI
            String signedURI = Utils.sign(strURI);

            InputStream responseStream = Utils.processCommand(signedURI, "GET");

            //further process JSON response
            String strJSON = Utils.streamToString(responseStream);   
    

            //Deserializes the JSON to a object. 
            ChartEditorResponse chartResponse = gson.fromJson(strJSON,ChartEditorResponse.class);

            return chartResponse.getLine();

        }
        /// <summary>
        /// 
        /// </summary>
        public String fileName ;

        /// <summary>
        /// 
        /// </summary>
        public String workSheetName ;
        
        static final Logger logger = Logger.getLogger(ChartEditor.class);
        Gson gson =null;
    }