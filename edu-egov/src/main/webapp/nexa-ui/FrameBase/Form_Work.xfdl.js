(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Form_Work");
            this.set_titletext("Form_Work");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("dsComCodeType", this);
            obj._setContents({"ColumnInfo" : {"Column" : [ {"id" : "CODE_TYPE_ID","type" : "STRING","size" : "256"},{"id" : "CODE_TYPE","type" : "STRING","size" : "256"},{"id" : "CODE_TYPE_NM","type" : "STRING","size" : "256"},{"id" : "CODE_TYPE_NM_S","type" : "STRING","size" : "256"},{"id" : "START_DATE","type" : "STRING","size" : "256"},{"id" : "END_DATE","type" : "STRING","size" : "256"},{"id" : "ENTRY_TYPE_CD","type" : "STRING","size" : "256"},{"id" : "REMARK","type" : "STRING","size" : "256"},{"id" : "CREATE_DATE","type" : "STRING","size" : "256"},{"id" : "CREATE_BY","type" : "STRING","size" : "256"},{"id" : "UPDATE_DATE","type" : "STRING","size" : "256"},{"id" : "UPDATE_BY","type" : "STRING","size" : "256"}]}});
            this.addChild(obj.name, obj);


            obj = new Dataset("dsSearch", this);
            obj._setContents({"ColumnInfo" : {"Column" : [ {"id" : "CODE_TYPE","type" : "STRING","size" : "256"},{"id" : "CODE_TYPE_NM","type" : "STRING","size" : "256"}]}});
            this.addChild(obj.name, obj);


            obj = new Dataset("dsRowCount", this);
            obj._setContents({"ColumnInfo" : {"Column" : [ {"id" : "ROW_CNT","type" : "STRING","size" : "256"}]}});
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Button("btnSearch","429","20","100","30",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("조회");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid00","18","60","1242","310",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_binddataset("dsComCodeType");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row band=\"head\" size=\"24\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"CODE_TYPE_ID\"/><Cell col=\"1\" text=\"CODE_TYPE\"/><Cell col=\"2\" text=\"CODE_TYPE_NM\"/><Cell col=\"3\" text=\"CODE_TYPE_NM_S\"/><Cell col=\"4\" text=\"START_DATE\"/><Cell col=\"5\" text=\"END_DATE\"/><Cell col=\"6\" text=\"ENTRY_TYPE_CD\"/><Cell col=\"7\" text=\"REMARK\"/><Cell col=\"8\" text=\"CREATE_DATE\"/><Cell col=\"9\" text=\"CREATE_BY\"/><Cell col=\"10\" text=\"UPDATE_DATE\"/><Cell col=\"11\" text=\"UPDATE_BY\"/></Band><Band id=\"body\"><Cell text=\"bind:CODE_TYPE_ID\"/><Cell col=\"1\" text=\"bind:CODE_TYPE\"/><Cell col=\"2\" text=\"bind:CODE_TYPE_NM\"/><Cell col=\"3\" text=\"bind:CODE_TYPE_NM_S\"/><Cell col=\"4\" text=\"bind:START_DATE\"/><Cell col=\"5\" text=\"bind:END_DATE\"/><Cell col=\"6\" text=\"bind:ENTRY_TYPE_CD\"/><Cell col=\"7\" text=\"bind:REMARK\"/><Cell col=\"8\" text=\"bind:CREATE_DATE\"/><Cell col=\"9\" text=\"bind:CREATE_BY\"/><Cell col=\"10\" text=\"bind:UPDATE_DATE\"/><Cell col=\"11\" text=\"bind:UPDATE_BY\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Button("btnDsData","534","20","100","30",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("XML보기");
            this.addChild(obj.name, obj);

            obj = new Edit("edCodeType","144","20","280","30",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_value("SYSTEM");
            obj.set_text("SYSTEM");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","19","20","120","30",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("코드유형");
            obj.set_textAlign("right");
            this.addChild(obj.name, obj);

            obj = new Static("stRowCount","1140","20","120","30",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("row count : 0");
            obj.set_textAlign("right");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","Desktop_screen",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information

            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Form_Work.xfdl", function() {

        this.btnSearch_onclick = function(obj,e)
        {
        	this.dsSearch.clearData();
        	var nRow = this.dsSearch.addRow();
        	var sCodeType = this.edCodeType.text;
        	var sCodeTypeNm = "시스템";
        	var sUserId = "Admin";

        	this.dsSearch.setColumn(nRow, "CODE_TYPE", sCodeType);
        	this.dsSearch.setColumn(nRow, "CODE_TYPE_NM", sCodeTypeNm);

        	//trace(this.dsSearch.saveXML());


        	this.transaction("selectComCodeTypeList"                                       			//서비스ID
        	                ,"http://localhost:8080/edu-egov/com/COM10000/selectComCodeTypeList.do"	//호출URL
        					,"inSearch=dsSearch"          											//INPUT데이터셋(서버 송신 Data Set Name=화면 input Data Set Name)
        					,"dsComCodeType=outSelectList dsRowCount=outSelectCount"				//OUTPUT데이터셋(화면 output Data Set Name=서버 수신된 Data Set Name)
        					,"userId=" + sUserId													//매개변수
        					,"fn_callBack"															//콜백함수
        					);
        };

        // 콜백함수
        this.fn_callBack = function(strSvcID, strErrCd, strErrMsg)
        {
        	if(strErrCd < 0) {
        		alert("오류 : " + strErrMsg);
        	}

        	switch(strSvcID) {
        		case "selectComCodeTypeList":
        			trace("###########################################################");
        			//trace(this.dsRowCount.saveXML());
        			var rowCount = this.dsRowCount.getColumn(0, "ROW_CNT");
        			this.stRowCount.text = "row count : " + rowCount;
        			if (rowCount == 0) {
        				alert("조회조건에 일치하는 데이터가 존재하지 않습니다.");
        			}
        			break;
        	}
        };

        this.fn_ResultXML = function(obj,e)
        {
        	trace(this.dsComCodeType.saveXML());
        	trace(this.dsRowCount.saveXML());
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.btnSearch.addEventHandler("onclick",this.btnSearch_onclick,this);
            this.btnDsData.addEventHandler("onclick",this.fn_ResultXML,this);
        };
        this.loadIncludeScript("Form_Work.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
