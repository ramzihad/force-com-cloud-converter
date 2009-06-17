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

package com.modelmetrics.common.sforce;

import java.rmi.RemoteException;
import java.util.Calendar;

import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.DescribeGlobalResult;
import com.sforce.soap.partner.DescribeLayoutResult;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.DescribeSoftphoneLayoutResult;
import com.sforce.soap.partner.DescribeTabSetResult;
import com.sforce.soap.partner.GetDeletedResult;
import com.sforce.soap.partner.GetServerTimestampResult;
import com.sforce.soap.partner.GetUpdatedResult;
import com.sforce.soap.partner.GetUserInfoResult;
import com.sforce.soap.partner.LeadConvert;
import com.sforce.soap.partner.LeadConvertResult;
import com.sforce.soap.partner.LoginResult;
import com.sforce.soap.partner.MergeRequest;
import com.sforce.soap.partner.MergeResult;
import com.sforce.soap.partner.ProcessRequest;
import com.sforce.soap.partner.ProcessResult;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.ResetPasswordResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.SearchResult;
import com.sforce.soap.partner.SetPasswordResult;
import com.sforce.soap.partner.SoapBindingStub;
import com.sforce.soap.partner.UndeleteResult;
import com.sforce.soap.partner.UpsertResult;
import com.sforce.soap.partner.fault.InvalidFieldFault;
import com.sforce.soap.partner.fault.InvalidIdFault;
import com.sforce.soap.partner.fault.InvalidNewPasswordFault;
import com.sforce.soap.partner.fault.InvalidQueryLocatorFault;
import com.sforce.soap.partner.fault.InvalidSObjectFault;
import com.sforce.soap.partner.fault.LoginFault;
import com.sforce.soap.partner.fault.MalformedQueryFault;
import com.sforce.soap.partner.fault.MalformedSearchFault;
import com.sforce.soap.partner.fault.UnexpectedErrorFault;
import com.sforce.soap.partner.sobject.SObject;

/**
 * 2007-06-25 
 * 
 * Useful for testing.
 * 
 * @author Reid Carlberg
 *
 */
public class SoapBindStubAlwaysSucceedsImpl extends SoapBindingStub {

	public SoapBindStubAlwaysSucceedsImpl() throws Exception {
		//not calling super since this is a mock
	}

	@Override
	public LeadConvertResult[] convertLead(LeadConvert[] arg0) throws RemoteException, UnexpectedErrorFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public SaveResult[] create(SObject[] arg0) throws RemoteException, UnexpectedErrorFault, InvalidSObjectFault, InvalidIdFault {
		/*
		 * for every sobject that comes in, create a positive upsert result 
		 */
		
		SaveResult[] ret = new SaveResult[arg0.length];
		
		for (int i = 0; i < arg0.length; i++) {
			ret[i] = new SaveResult();
			ret[i].setSuccess(true);
			ret[i].setId(arg0[i].getId());
		}

		return ret;
	}

	@Override
	public DeleteResult[] delete(String[] arg0) throws RemoteException, UnexpectedErrorFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public DescribeGlobalResult describeGlobal() throws RemoteException, UnexpectedErrorFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public DescribeLayoutResult describeLayout(String arg0, String[] arg1) throws RemoteException, UnexpectedErrorFault, InvalidSObjectFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public DescribeSObjectResult describeSObject(String arg0) throws RemoteException, UnexpectedErrorFault, InvalidSObjectFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public DescribeSObjectResult[] describeSObjects(String[] arg0) throws RemoteException, UnexpectedErrorFault, InvalidSObjectFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public DescribeSoftphoneLayoutResult describeSoftphoneLayout() throws RemoteException, UnexpectedErrorFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public DescribeTabSetResult[] describeTabs() throws RemoteException, UnexpectedErrorFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public GetDeletedResult getDeleted(String arg0, Calendar arg1, Calendar arg2) throws RemoteException, UnexpectedErrorFault, InvalidSObjectFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public GetServerTimestampResult getServerTimestamp() throws RemoteException, UnexpectedErrorFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public GetUpdatedResult getUpdated(String arg0, Calendar arg1, Calendar arg2) throws RemoteException, UnexpectedErrorFault, InvalidSObjectFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public GetUserInfoResult getUserInfo() throws RemoteException, UnexpectedErrorFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public LoginResult login(String arg0, String arg1) throws RemoteException, UnexpectedErrorFault, InvalidIdFault, LoginFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public MergeResult[] merge(MergeRequest[] arg0) throws RemoteException, UnexpectedErrorFault, InvalidSObjectFault, InvalidIdFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public ProcessResult[] process(ProcessRequest[] arg0) throws RemoteException, UnexpectedErrorFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public QueryResult query(String arg0) throws RemoteException, UnexpectedErrorFault, InvalidSObjectFault, MalformedQueryFault, InvalidFieldFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public QueryResult queryAll(String arg0) throws RemoteException, UnexpectedErrorFault, InvalidSObjectFault, MalformedQueryFault, InvalidFieldFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public QueryResult queryMore(String arg0) throws RemoteException, UnexpectedErrorFault, InvalidQueryLocatorFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public ResetPasswordResult resetPassword(String arg0) throws RemoteException, UnexpectedErrorFault, InvalidIdFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public SObject[] retrieve(String arg0, String arg1, String[] arg2) throws RemoteException, UnexpectedErrorFault, InvalidSObjectFault, InvalidFieldFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public SearchResult search(String arg0) throws RemoteException, MalformedSearchFault, UnexpectedErrorFault, InvalidSObjectFault, InvalidFieldFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public SetPasswordResult setPassword(String arg0, String arg1) throws RemoteException, UnexpectedErrorFault, InvalidIdFault, InvalidNewPasswordFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public UndeleteResult[] undelete(String[] arg0) throws RemoteException, UnexpectedErrorFault {
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public SaveResult[] update(SObject[] arg0) throws RemoteException, UnexpectedErrorFault, InvalidSObjectFault, InvalidIdFault {
		
		throw new RuntimeException("Always Succeeds - Method Not Yet Implemented");
	}

	@Override
	public UpsertResult[] upsert(String arg0, SObject[] arg1) throws RemoteException, UnexpectedErrorFault, InvalidSObjectFault, InvalidIdFault, InvalidFieldFault {
		/*
		 * for every sobject that comes in, create a positive upsert result 
		 */
		
		UpsertResult[] ret = new UpsertResult[arg1.length];
		
		for (int i = 0; i < arg1.length; i++) {
			ret[i] = new UpsertResult();
			ret[i].setSuccess(true);
			ret[i].setId(arg1[i].getId());
		}

		return ret;
	}
	
	
}
