package com.wisenut.search.domain.model;


public class WNCollection {

    public static String SEARCH_IP = "127.0.0.1";
    public static int SEARCH_PORT = 7000;

    public static String MANAGER_IP = "127.0.0.1";
    public static int MANAGER_PORT = 8080;

    public static String[] COLLECTIONS = new String[]{"apvl","board"};
    public static String[] COLLECTIONS_NAME = new String[]{"apvl","board"};

    public static String[] MERGE_COLLECTIONS = new String[]{""};

    public String[][] COLLECTION_INFO = null;

    public String[][] MERGE_COLLECTION_INFO = null;

    public WNCollection() {

        // (virtual) merge collection
        /*
         * MERGE_COLLECTION_INFO = new String[][] { { "merge_sample_bbs", // set merge
         * collection name "sample_bbs/sample_edu", // set collection name, delimiter: /
         * "0,3", // set merge collection pageinfo (start,count)
         * "DOCID,TITLE,WRITER,CONTENT",// set merge document field
         * "DOCID,TITLE,WRITER,CONTENT/DOCID,TITLE,WRITER,CONTENT", // set document
         * field, delimiter: / "", // set merge collection multi-group-by field "", //
         * set merge collection multi-group-by field, delimiter: / "", // set merge
         * collection category-group-by field "" // set collection multi-group-by field,
         * delimiter: / } };
         */

        COLLECTION_INFO = new String[][]{
                {
                        "apvl", // set index name
                        "apvl", // set collection name
                        "0,3",  // set pageinfo (start,count)
                        "1,0,0,0,0", // set query analyzer (useKMA,isCase,useOriginal,useSynonym, duplcated detection)
                        "RANK/DESC,DATE/DESC",  // set sort field (field,order) multi sort '/'
                        "basic,rpfmo,100",  // set sort field (field,order) multi sort '/'
                        "DOCID,Title,Content,FILE_CONTENT,FILENAME,Author,DRAFTER_DEPARTMENT_NAME,DRAFTER_USER_NAME_ENG,DRAFTER_DEPARTMENT_NAME_ENG,DOCUMENT_NO",// set search field
                        "DOCID,Date,PROCESS_INSTANCE_ID,PARENT_PROCESS_INSTANCE_ID,DOCUMENT_VIEW_STATE_CODE,PROCESS_CODE,APPROVAL_ORDER,Title,DRAFTER_USER_ID,Author,DRAFTER_USER_NAME_ENG,DRAFTER_DEPARTMENT_NAME,DRAFTER_DEPARTMENT_NAME_ENG,APPROVAL_COMPLETED_DATE,ORIGIN_URL,FORM_PREFIX,DOCUMENT_NO,DRAFTER_COMPANY_CODE,DRAFTER_LANGUAGE_CODE,DRAFTER_POSITION_CODE,DRAFTER_POSITION_NAME,DRAFTER_POSITION_NAME_ENG,GLOBAL_DOCUMENT_AT,UNITY_APPROVAL_AT,FARM_CODE,DRAFTER_DEPARTMENT_CODE,FORM_NAME,Content,FILENAME,FILE_CONTENT,ROLE,TERMS,ALIAS",// set document field
                        "", // set date range
                        "", // set rank range
                        "", // set prefix query, example: <fieldname:contains:value1>|<fieldname:contains:value2>/1,  (fieldname:contains:value) and ' ', or '|', not '!' / operator (AND:1, OR:0)
                        "", // set collection query (<fieldname:contains:value^weight | value^weight>/option...) and ' ', or '|'
                        "", // set boost query (<fieldname:contains:value> | <field3:contains:value>...) and ' ', or '|'
                        "", // set filter operation (<fieldname:operator:value>)
                        "", // set groupby field(field, count)
                        "", // set sort field group(field/order,field/order,...)
                        "", // set categoryBoost(fieldname,matchType,boostID,boostKeyword)
                        "", // set categoryGroupBy (fieldname:value)
                        "", // set categoryQuery (fieldname:value)
                        "", // set property group (fieldname,min,max, groupcount)
                        "ROLE,FORM_PREFIX", // use check prefix query filed
                        "Date,Author,DRAFTER_USER_NAME_ENG,DRAFTER_DEPARTMENT_NAME,DRAFTER_DEPARTMENT_NAME_ENG,FORM_PREFIX", // set use check fast access field
                        "", // set multigroupby field
                        "", // set auth query (Auth Target Field, Auth Collection, Auth Reference Field, Authority Query)
                        "", // set Duplicate Detection Criterion Field, RANK/DESC,DATE/DESC
                        "apvl" // collection display name
                }
                ,
                {
                        "board", // set index name
                        "board", // set collection name
                        "0,3",  // set pageinfo (start,count)
                        "1,0,0,0,0", // set query analyzer (useKMA,isCase,useOriginal,useSynonym, duplcated detection)
                        "RANK/DESC,DATE/DESC",  // set sort field (field,order) multi sort '/'
                        "basic,rpfmo,100",  // set sort field (field,order) multi sort '/'
                        "DOCID,Title,WebTitle,Author,Content,AttachFileName,AttachFileBody,Tag,UserID",// set search field
                        "DOCID,Id,Date,WebTitle,Title,Content,Author,Tag,WorkflowVersion,Order,AttachFileName,AttachFileBody,AttachFileUrls,DetailLinkUrl,Role,ALIAS,H_ParentIDField,TERMS,AuthorID,RoleEmail,Email,SiteID,ListID,ItemID,LinkUrl",// set document field
                        "", // set date range
                        "", // set rank range
                        "", // set prefix query, example: <fieldname:contains:value1>|<fieldname:contains:value2>/1,  (fieldname:contains:value) and ' ', or '|', not '!' / operator (AND:1, OR:0)
                        "", // set collection query (<fieldname:contains:value^weight | value^weight>/option...) and ' ', or '|'
                        "", // set boost query (<fieldname:contains:value> | <field3:contains:value>...) and ' ', or '|'
                        "", // set filter operation (<fieldname:operator:value>)
                        "", // set groupby field(field, count)
                        "", // set sort field group(field/order,field/order,...)
                        "", // set categoryBoost(fieldname,matchType,boostID,boostKeyword)
                        "", // set categoryGroupBy (fieldname:value)
                        "", // set categoryQuery (fieldname:value)
                        "", // set property group (fieldname,min,max, groupcount)
                        "Id,ALIAS,Role,DetailLinkUrl,AuthorID,RoleEmail,H_ParentIDField", // use check prefix query filed
                        "Date,Order", // set use check fast access field
                        "", // set multigroupby field
                        "", // set auth query (Auth Target Field, Auth Collection, Auth Reference Field, Authority Query)
                        "", // set Duplicate Detection Criterion Field, RANK/DESC,DATE/DESC
                        "board" // collection display name
                }
        };
    }
}
