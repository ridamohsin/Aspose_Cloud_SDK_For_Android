/**
 * 
 */
package com.aspose.cloud.sdk.pdf;

import com.aspose.cloud.sdk.common.BaseResponse;

/// <summary>
/// represents response of a single annotation
/// </summary>

public class AnnotationResponse extends BaseResponse

{
 public AnnotationResponse() { }

// public Annotation  Annotation;
 private Annotation  Annotation;

 public Annotation getAnnotation(){return Annotation;}
 public void setAnnotation(Annotation annotation){ this.Annotation=annotation;}
 
}