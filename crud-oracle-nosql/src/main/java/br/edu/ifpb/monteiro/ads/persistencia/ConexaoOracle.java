package br.edu.ifpb.monteiro.ads.persistencia;

import oracle.kv.KVStore;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;

public class ConexaoOracle {
	
	private static KVStore store;
	
	private static String storeName = "kvstore";
    private static String hostName = "localhost";
    private static String hostPort = "5000";
    
    
    public static void openStore(){
    	store = KVStoreFactory.getStore
 	            (new KVStoreConfig(storeName, hostName + ":" + hostPort));
    }
    
    public static void closeStore(){
    	store.close();
    }

	public static KVStore getStore() {
		return store;
	}
}
