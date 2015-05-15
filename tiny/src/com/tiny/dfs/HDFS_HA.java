package com.tiny.dfs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class HDFS_HA {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://ns1");
		conf.set("dfs.nameservices", "ns1");
		conf.set("dfs.ha.namenodes.ns1", "nn1,nn2");
		conf.set("dfs.namenode.rpc-address.ns1.nn1", "tiny01:9000");
		conf.set("dfs.namenode.rpc-address.ns1.nn2", "tiny02:9000");
		//conf.setBoolean(name, value);
		conf.set("dfs.client.failover.proxy.provider.ns1", "org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider");
		FileSystem fs = FileSystem.get(new URI("hdfs://ns1"), conf, "root");
		InputStream in = null;
		//in = new FileInputStream("d://ideaIU-13.0.1.exe");
		in = fs.open(new Path("/ideaIU"));
		OutputStream out = null;
		//out = fs.create(new Path("/ideaIU"));
		out = new FileOutputStream("c://ideaIU-13.0.1.exe");
		IOUtils.copyBytes(in, out, 4096, true);
	}
}
