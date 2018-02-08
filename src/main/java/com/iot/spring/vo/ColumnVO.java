package com.iot.spring.vo;

public class ColumnVO {
	private String columnname;
	private String columndefault;
	private String isnullable;
	private String datatype;
	private int charactermaximumlength;
	private String columntype;
	private String columnkey;
	private String columncomment ;
	
	@Override
	public String toString() {
		return "ColumnVO [columnname=" + columnname + ", columndefault=" + columndefault + ", isnullable=" + isnullable
				+ ", datatype=" + datatype + ", charactermaximumlength=" + charactermaximumlength + ", columntype="
				+ columntype + ", columnkey=" + columnkey + ", columncomment=" + columncomment + "]";
	}
	public String getColumnname() {
		return columnname;
	}
	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}
	public String getColumndefault() {
		return columndefault;
	}
	public void setColumndefault(String columndefault) {
		this.columndefault = columndefault;
	}
	public String getIsnullable() {
		return isnullable;
	}
	public void setIsnullable(String isnullable) {
		this.isnullable = isnullable;
	}
	public String getDatatype() {
		return datatype;
	}
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	public int getCharactermaximumlength() {
		return charactermaximumlength;
	}
	public void setCharactermaximumlength(int charactermaximumlength) {
		this.charactermaximumlength = charactermaximumlength;
	}
	public String getColumntype() {
		return columntype;
	}
	public void setColumntype(String columntype) {
		this.columntype = columntype;
	}
	public String getColumnkey() {
		return columnkey;
	}
	public void setColumnkey(String columnkey) {
		this.columnkey = columnkey;
	}
	public String getColumncomment() {
		return columncomment;
	}
	public void setColumncomment(String columncomment) {
		this.columncomment = columncomment;
	}
	
	
}
