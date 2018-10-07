package com.util.express;

public enum ExpressEnum {
  	EMS("ems","EMS"),
  	SF("shunfeng","顺丰"),
	ST("shentong","申通")
	;
	String name;
	String code;
	ExpressEnum(String code,String name){
		this.code = code;
		this.name = name;
	}

	public String getCode(){
		return this.code;
	}

	public String getName(){
		return this.name;
	}


}
