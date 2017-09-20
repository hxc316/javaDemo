package test.datacache.demo1.data;

public class DataConfig implements SiteConfig {

    protected String siteId;
    protected String tableName;
    protected String sumCloumn;
    protected String[] groupIds;
    private String columns[];

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setSumCloumn(String sumCloumn) {
        this.sumCloumn = sumCloumn;
    }

    @Override
    public String getSumCloumn() {
        return this.sumCloumn;
    }

    public String[] getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(String[] groupIds) {
        this.groupIds = groupIds;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

}
