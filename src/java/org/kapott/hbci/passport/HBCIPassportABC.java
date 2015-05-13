package org.kapott.hbci.passport; 

import org.kapott.hbci.manager.HBCIUtils;
import org.kapott.hbci.manager.HBCIUtilsInternal;


public class HBCIPassportABC extends HBCIPassportPinTan { 
 private boolean ready;
// static final long serialVersionUID=0;           // this class is not serialized
 public HBCIPassportABC(Object init, int dummy) { 
	 super(init,0); 
 } 

 public HBCIPassportABC(Object initObject) { 
	 
	 this(initObject, 0);
	 askForMissingData(true,true,false,false,false,true,true);
	 String bankCode = this.getBLZ();
	 ready = false;
	 String info = HBCIUtilsInternal.getBLZData(bankCode);
	 String host = HBCIUtilsInternal.getNthToken(info, 6);

	 
	 String version = HBCIUtilsInternal.getNthToken(info, 8);
	 if(version == null || version.isEmpty()) version="plus";;
	 

	if(host == null || host.isEmpty()) 
	{} 
	else
	{	
		if(host.startsWith("https://")) host = host.substring(8);
		this.setHost(host);
	}
	
   this.setFilterType("Base64");
   
   this.setHBCIVersion(version);
   this.setPort(new Integer(443));               
   this.setProxy("");
   this.setCheckCert(false); 
   this.setProxyUser(""); 
   this.setProxyPass(""); 
   ready = true;
   saveChanges();
  }
   
  public boolean isReady() {
      return ready;
}



  public void saveChanges() { 

  } 
}