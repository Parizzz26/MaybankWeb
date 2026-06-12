<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Mengambil list SOF pada Account</description>
   <name>Post_AccountSummary</name>
   <tag></tag>
   <elementGuidId>ce47df2f-908a-408b-801d-393723f00ef6</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>true</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/xml</value>
      <webElementGuid>51497413-5a2a-4bb1-aa11-d6cfeae46046</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.7.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <path></path>
   <restRequestMethod></restRequestMethod>
   <restUrl></restUrl>
   <serviceType>SOAP</serviceType>
   <soapBody>&lt;soapenv:Envelope
                xmlns:soapenv=&quot;http://schemas.xmlsoap.org/soap/envelope/&quot;
                xmlns:acc=&quot;http://www.bankbii.com/AccountServices/&quot;>
    &lt;soapenv:Header/>
    &lt;soapenv:Body>
        &lt;acc:AccountSummary>
            &lt;ChannelHeader>
                &lt;messageID>${messageID}&lt;/messageID>
                &lt;additionalHeader param=&quot;VERSION&quot;>2.0&lt;/additionalHeader>
                &lt;branchCode>270&lt;/branchCode>
                &lt;channelID>M2U&lt;/channelID>
                &lt;clientSupervisorID>0000&lt;/clientSupervisorID>
                &lt;clientUserID>0000&lt;/clientUserID>
                &lt;reference>0a598e04-dc2e-482d-ad52-4739ba8c6a58&lt;/reference>
                &lt;sequenceno>0000&lt;/sequenceno>
                &lt;transactiondate>${transactionDate}&lt;/transactiondate>
                &lt;transactiontime>${transactionTime}&lt;/transactiontime>
            &lt;/ChannelHeader>
            &lt;PaginationInfo>
                &lt;FirstPageIndicator>N&lt;/FirstPageIndicator>
                &lt;LastPageIndicator>N&lt;/LastPageIndicator>
                &lt;PaginationFlag>N&lt;/PaginationFlag>
                &lt;PaginationKey/>
            &lt;/PaginationInfo>
            &lt;AccountSummaryRequest>
                &lt;acc:CIFNo>${cifNo}&lt;/acc:CIFNo>
                &lt;acc:RequestType>ACCOUNT&lt;/acc:RequestType>
            &lt;/AccountSummaryRequest>
        &lt;/acc:AccountSummary>
    &lt;/soapenv:Body>
&lt;/soapenv:Envelope></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod>SOAP</soapRequestMethod>
   <soapServiceEndpoint>http://10.235.66.95:7700/AccountServices</soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>false</useServiceInfoFromWsdl>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress>http://10.235.66.95:7700/AccountServices</wsdlAddress>
</WebServiceRequestEntity>
