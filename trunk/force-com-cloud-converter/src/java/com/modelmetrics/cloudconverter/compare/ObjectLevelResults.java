/*
The MIT License

Copyright (c) 2008, 2009 Model Metrics, Inc.

http://ModelMetrics.com
http://ModelMetrics.com/authors/rcarlberg

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package com.modelmetrics.cloudconverter.compare;

import com.sforce.soap.partner.DescribeSObjectResult;

public class ObjectLevelResults extends AbstractComparisonSessionAware {


	private DescribeSObjectResult describeSObjectResult;

		
	    public  boolean equals(java.lang.Object obj) {

	    	if (!(obj instanceof ObjectLevelResults)) return false;
	    	ObjectLevelResults otherResult = (ObjectLevelResults) obj;
	    	DescribeSObjectResult other = otherResult.getDescribeSObjectResult();
	        if (obj == null) return false;
	        if (this.getDescribeSObjectResult()== other) return true;

	        boolean _equals;
	        _equals = true && 
	            this.describeSObjectResult.isActivateable() == other.isActivateable() &&
	            this.describeSObjectResult.isCreateable() == other.isCreateable() &&
	            this.describeSObjectResult.isCustom() == other.isCustom() &&
	            this.describeSObjectResult.isDeletable() == other.isDeletable() &&
	            ((this.describeSObjectResult.getKeyPrefix()==null && other.getKeyPrefix()==null) || 
	             (this.describeSObjectResult.getKeyPrefix()!=null &&
	              this.describeSObjectResult.getKeyPrefix().equals(other.getKeyPrefix()))) &&
	            ((this.describeSObjectResult.getLabel()==null && other.getLabel()==null) || 
	             (this.describeSObjectResult.getLabel()!=null &&
	              this.describeSObjectResult.getLabel().equals(other.getLabel()))) &&
	            ((this.describeSObjectResult.getLabelPlural()==null && other.getLabelPlural()==null) || 
	             (this.describeSObjectResult.getLabelPlural()!=null &&
	              this.describeSObjectResult.getLabelPlural().equals(other.getLabelPlural()))) &&
	            this.describeSObjectResult.isLayoutable() == other.isLayoutable() &&
	            this.describeSObjectResult.isMergeable() == other.isMergeable() &&
	            ((this.describeSObjectResult.getName()==null && other.getName()==null) || 
	             (this.describeSObjectResult.getName()!=null &&
	              this.describeSObjectResult.getName().equals(other.getName()))) &&
	            this.describeSObjectResult.isQueryable() == other.isQueryable() &&
	            this.describeSObjectResult.isReplicateable() == other.isReplicateable() &&
	            this.describeSObjectResult.isRetrieveable() == other.isRetrieveable() &&
	            this.describeSObjectResult.isSearchable() == other.isSearchable() &&
	            ((this.describeSObjectResult.getTriggerable()==null && other.getTriggerable()==null) || 
	             (this.describeSObjectResult.getTriggerable()!=null &&
	              this.describeSObjectResult.getTriggerable().equals(other.getTriggerable()))) &&
	            this.describeSObjectResult.isUpdateable() == other.isUndeletable() &&
	            this.describeSObjectResult.isUpdateable() == other.isUpdateable() &&
	            ((this.describeSObjectResult.getUrlDetail()==null && other.getUrlDetail()==null) || 
	             (this.describeSObjectResult.getUrlDetail()!=null &&
	              this.describeSObjectResult.getUrlDetail().equals(other.getUrlDetail()))) &&
	            ((this.describeSObjectResult.getUrlEdit()==null && other.getUrlEdit()==null) || 
	             (this.describeSObjectResult.getUrlEdit()!=null &&
	              this.describeSObjectResult.getUrlEdit().equals(other.getUrlEdit()))) &&
	            ((this.describeSObjectResult.getUrlNew()==null && other.getUrlNew()==null) || 
	             (this.describeSObjectResult.getUrlNew()!=null &&
	              this.describeSObjectResult.getUrlNew().equals(other.getUrlNew())));

	        return _equals;
	    }

	
	public String getThisObjectsDifferenceDescription(Object obj) {

    	ObjectLevelResults otherResult = (ObjectLevelResults) obj;
    	DescribeSObjectResult other = otherResult.getDescribeSObjectResult();
        if (obj == null) return null;
        if (this.getDescribeSObjectResult()== other) return null;
        
		StringBuffer different = new StringBuffer();
		
        if(this.describeSObjectResult.isActivateable() == !other.isActivateable()) {
        	different.append("Activatable");
        }
        
        
        if (this.describeSObjectResult.isCreateable() == !other.isCreateable() ) {
        	different.append("Createable");
        }
        
        
        if (this.describeSObjectResult.isCustom() == !other.isCustom() ) {
        	different.append("Custom");
        }
        
        if (this.describeSObjectResult.isDeletable() == !other.isDeletable()) {
        	different.append("Deletable");
        }
        
        if (((this.describeSObjectResult.getKeyPrefix()==null || other.getKeyPrefix()==null) || 
         (this.describeSObjectResult.getKeyPrefix()!=null &&
          !this.describeSObjectResult.getKeyPrefix().equals(other.getKeyPrefix())))) {
        	different.append("Key Prefix");
        }
        
          
        if (((this.describeSObjectResult.getLabel()==null || other.getLabel()==null) || 
         (this.describeSObjectResult.getLabel()!=null &&
          this.describeSObjectResult.getLabel().equals(other.getLabel())))) {
        	different.append("Label");
        }
        
          
        if (((this.describeSObjectResult.getLabelPlural()==null || other.getLabelPlural()==null) || 
         (this.describeSObjectResult.getLabelPlural()!=null &&
          this.describeSObjectResult.getLabelPlural().equals(other.getLabelPlural()))) ) {
        	different.append("Plural Label");
        }

        if (this.describeSObjectResult.isLayoutable() != other.isLayoutable()) {
        	different.append("Layoutable");
        }
        
        if (this.describeSObjectResult.isMergeable() != other.isMergeable()) {
        	different.append("Mergeable");
        }
        
        
        if (((this.describeSObjectResult.getName()==null || other.getName()==null) || 
         (this.describeSObjectResult.getName()!=null &&
          this.describeSObjectResult.getName().equals(other.getName())))) {
        	different.append("Name");
        }
        
        if (this.describeSObjectResult.isQueryable() == other.isQueryable()) {
        	different.append("Queryable");
        }
        
        
        if (this.describeSObjectResult.isReplicateable() == other.isReplicateable()) {
        	different.append("Replicateable");
        }
        
        
//        this.describeSObjectResult.isRetrieveable() == other.isRetrieveable() &&
//        
//        
//        this.describeSObjectResult.isSearchable() == other.isSearchable() &&
//        
//        
//        ((this.describeSObjectResult.getTriggerable()==null && other.getTriggerable()==null) || 
//         (this.describeSObjectResult.getTriggerable()!=null &&
//          this.describeSObjectResult.getTriggerable().equals(other.getTriggerable()))) &&
//        
//          
//        this.describeSObjectResult.isUpdateable() == other.isUndeletable() &&
//        
//        
//        this.describeSObjectResult.isUpdateable() == other.isUpdateable() &&
//        
//        
//        ((this.describeSObjectResult.getUrlDetail()==null && other.getUrlDetail()==null) || 
//         (this.describeSObjectResult.getUrlDetail()!=null &&
//          this.describeSObjectResult.getUrlDetail().equals(other.getUrlDetail()))) &&
//        
//          
//        ((this.describeSObjectResult.getUrlEdit()==null && other.getUrlEdit()==null) || 
//         (this.describeSObjectResult.getUrlEdit()!=null &&
//          this.describeSObjectResult.getUrlEdit().equals(other.getUrlEdit()))) &&
//        
//          
//        ((this.describeSObjectResult.getUrlNew()==null && other.getUrlNew()==null) || 
//         (this.describeSObjectResult.getUrlNew()!=null &&
//          this.describeSObjectResult.getUrlNew().equals(other.getUrlNew())));

        return different.toString();
		
	}
	
	
	    

	public DescribeSObjectResult getDescribeSObjectResult() {
		return describeSObjectResult;
	}

	public void setDescribeSObjectResult(DescribeSObjectResult describeSObjectResult) {
		this.describeSObjectResult = describeSObjectResult;
	}

}
