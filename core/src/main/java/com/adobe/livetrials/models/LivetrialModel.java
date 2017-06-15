package com.adobe.livetrials.models;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, resourceType = "cq:Page")
@Exporter(name = "jackson", extensions = "json")
public class LivetrialModel {
	
    @Inject @Named("jcr:content/jcr:title")
    private String pageTitle;
    
//    @Inject
//    private String pageDesc;
//    
//    @Inject
//    private String createDate;
//    
//    @Inject
//    private String noOfChildPages;   

	public String getPageTitle() {
		return pageTitle;
	}
//
//	public String getPageDesc() {
//		return pageDesc;
//	}
//
//	public String getCreateDate() {
//		return createDate;
//	}
//
//	public String getNoOfChildPages() {
//		return noOfChildPages;
//	}


}
