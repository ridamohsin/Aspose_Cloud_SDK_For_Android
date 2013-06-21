package com.aspose.cloud.sdk.cells;
import java.util.List;

import com.aspose.cloud.sdk.common.BaseResponse;

    /// <summary>
    ///  Represents response from the Validations resource
    /// </summary>
    public class ValidationsResponse extends BaseResponse
    {       
        private LinkResponse link;
        private int Count;            
        private List<LinkResponse> ValidationList;
        private Validation Validation;
        
        public LinkResponse getLink(){return link;}
        public int getCount(){return Count;}            
        public List<LinkResponse> getValidationList(){return ValidationList;}
        public Validation getValidation(){return Validation;};

    }