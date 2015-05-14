package com.aspose.cloud.sdk.slides.model;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by muhammadsohailismail on 5/13/15.
 */
public class SlideResponse extends BaseResponse {
    @SerializedName("Slide")
    public SlideEnvelop slide;
    public String message;

    public class SlideEnvelop {
        public float Width;
        public float Height;
        public SlidesUri Shapes;
        public SlidesUri Theme;
        public SlidesUri Placeholders;
        public SlidesUri Images;
        public SlidesUri Comments;
        public SlidesUri Background;
        public LinkModel SelfUri;
        public ArrayList<LinkModel> AlternateLinks;
        public ArrayList<LinkModel> Links;
    }

}
