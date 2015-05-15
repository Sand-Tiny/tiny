package com.tiny.hive.udf;


import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class AreaUDF extends UDF{

	private static Map<Integer, String> areaMap = new HashMap<Integer, String>();
	
	static {
		areaMap.put(1, "����");
		areaMap.put(2, "�Ϻ�");
		areaMap.put(3, "����");
	}
	
	public Text evaluate(Text in){
		String result = areaMap.get(Integer.parseInt(in.toString()));
		if(result == null){
			result = "����";
		}
		return new Text(result);
	}
}
