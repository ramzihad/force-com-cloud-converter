/**
 * MetadataPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package old.com.sforce.soap._2006._04.metadata;

public interface MetadataPortType extends java.rmi.Remote {

    /**
     * Check the current status of an asyncronous deploy call.
     */
    public com.sforce.soap._2006._04.metadata.DeployResult checkDeployStatus(java.lang.String asyncProcessId) throws java.rmi.RemoteException;

    /**
     * Check the current status of an asyncronous deploy call.
     */
    public com.sforce.soap._2006._04.metadata.RetrieveResult checkRetrieveStatus(java.lang.String asyncProcessId) throws java.rmi.RemoteException;

    /**
     * Check the current status of an asyncronous call.
     */
    public com.sforce.soap._2006._04.metadata.AsyncResult[] checkStatus(java.lang.String[] asyncProcessId) throws java.rmi.RemoteException;

    /**
     * Creates new metadata entries asyncronously.
     */
    public com.sforce.soap._2006._04.metadata.AsyncResult[] create(com.sforce.soap._2006._04.metadata.Metadata[] metadata) throws java.rmi.RemoteException;

    /**
     * Deletes metadata entries asyncronously.
     */
    public com.sforce.soap._2006._04.metadata.AsyncResult[] delete(com.sforce.soap._2006._04.metadata.Metadata[] metadata) throws java.rmi.RemoteException;

    /**
     * Deploys a zipfile full of metadata entries asynchronously.
     */
    public com.sforce.soap._2006._04.metadata.AsyncResult deploy(byte[] zipFile, com.sforce.soap._2006._04.metadata.DeployOptions deployOptions) throws java.rmi.RemoteException;

    /**
     * Describes features of the metadata API.
     */
    public com.sforce.soap._2006._04.metadata.DescribeMetadataResult describeMetadata(double asOfVersion) throws java.rmi.RemoteException;

    /**
     * Lists the available metadata components.
     */
    public com.sforce.soap._2006._04.metadata.FileProperties[] listMetadata(com.sforce.soap._2006._04.metadata.ListMetadataQuery[] queries) throws java.rmi.RemoteException;

    /**
     * Retrieves a set of individually specified metadata entries.
     */
    public com.sforce.soap._2006._04.metadata.AsyncResult retrieve(com.sforce.soap._2006._04.metadata.RetrieveRequest retrieveRequest) throws java.rmi.RemoteException;

    /**
     * Updates metadata entries asyncronously.
     */
    public com.sforce.soap._2006._04.metadata.AsyncResult[] update(com.sforce.soap._2006._04.metadata.UpdateMetadata[] updateMetadata) throws java.rmi.RemoteException;
}
