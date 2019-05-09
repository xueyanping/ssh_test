package com.test.cxf.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.2
 * 2019-05-07T13:30:23.220+08:00
 * Generated source version: 2.4.2
 * 
 */
@WebService(targetNamespace = "http://cxf.ws.cxf_test/", name = "ISurveyService")
@XmlSeeAlso({
	//ObjectFactory.class
	})
public interface ISurveyService {

    @WebMethod
    @RequestWrapper(localName = "vote", targetNamespace = "http://cxf.ws.cxf_test/", className = "ws.cxf.client.Vote")
    @ResponseWrapper(localName = "voteResponse", targetNamespace = "http://cxf.ws.cxf_test/", className = "ws.cxf.client.VoteResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String vote(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1
    );
}