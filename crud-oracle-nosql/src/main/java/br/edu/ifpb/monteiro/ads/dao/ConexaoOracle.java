package br.edu.ifpb.monteiro.ads.dao;

import oracle.kv.KVStore;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;

public class ConexaoOracle {
	
	private final KVStore store;
	
	private String storeName = "kvstore";
    private String hostName = "localhost";
    private String hostPort = "5000";
    
    public ConexaoOracle(){
    	
    	 store = KVStoreFactory.getStore
    	            (new KVStoreConfig(storeName, hostName + ":" + hostPort));
    	
    }
    
    public KVStore getStore(){
    	
    	return this.store;
    	
    }

}
