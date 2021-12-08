package com.epam.tc.hw8.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Board {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("desc")
    @Expose
    private String desc;

    @SerializedName("descData")
    @Expose
    private String descData;

    @SerializedName("closed")
    @Expose
    private String closed;

    @SerializedName("idOrganization")
    @Expose
    private String idOrganization;

    @SerializedName("idEnterprise")
    @Expose
    private String idEnterprise;

    @SerializedName("pinned")
    @Expose
    private String pinned;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("shortUrl")
    @Expose
    private String shortUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDescData() {
        return descData;
    }

    public void setDescData(String descData) {
        this.descData = descData;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(String idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public String getPinned() {
        return pinned;
    }

    public void setPinned(String pinned) {
        this.pinned = pinned;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @SuppressWarnings("checkstyle:WhitespaceAround")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Board.class.getName()).append('@')
          .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("desc");
        sb.append('=');
        sb.append(((this.desc == null) ? "<null>" : this.desc));
        sb.append(',');
        sb.append("descData");
        sb.append('=');
        sb.append(((this.descData == null) ? "<null>" : this.desc));
        sb.append(',');
        sb.append("closed");
        sb.append('=');
        sb.append(((this.closed == null) ? "<null>" : this.closed));
        sb.append(',');
        sb.append("idOrganization");
        sb.append('=');
        sb.append(((this.idOrganization == null) ? "<null>" : this.idOrganization));
        sb.append(',');
        sb.append("idEnterprise");
        sb.append('=');
        sb.append(((this.idEnterprise == null) ? "<null>" : this.idEnterprise));
        sb.append(',');
        sb.append("pinned");
        sb.append('=');
        sb.append(((this.pinned == null) ? "<null>" : this.pinned));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null) ? "<null>" : this.url));
        sb.append(',');
        sb.append("shortUrl");
        sb.append('=');
        sb.append(((this.shortUrl == null) ? "<null>" : this.shortUrl));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.desc == null) ? 0 : this.desc.hashCode()));
        result = ((result * 31) + ((this.descData == null) ? 0 : this.descData.hashCode()));
        result = ((result * 31) + ((this.closed == null) ? 0 : this.closed.hashCode()));
        result = ((result * 31) + ((this.idOrganization == null) ? 0 : this.idOrganization.hashCode()));
        result = ((result * 31) + ((this.idEnterprise == null) ? 0 : this.idEnterprise.hashCode()));
        result = ((result * 31) + ((this.pinned == null) ? 0 : this.pinned.hashCode()));
        result = ((result * 31) + ((this.url == null) ? 0 : this.url.hashCode()));
        result = ((result * 31) + ((this.shortUrl == null) ? 0 : this.shortUrl.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Board)) {
            return false;
        }
        Board rhs = ((Board) other);
        return ((((((((((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id)))
            && ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name))))
            && ((this.desc == rhs.desc) || ((this.desc != null) && this.desc.equals(rhs.desc))))
            && ((this.descData == rhs.descData) || ((this.descData != null) && this.descData.equals(rhs.desc))))
            && ((this.closed == rhs.closed) || ((this.closed != null) && this.closed.equals(rhs.closed))))
            && ((this.idOrganization == rhs.idOrganization) || ((this.idOrganization != null)
            && this.idOrganization.equals(rhs.idOrganization))))
            && ((this.idEnterprise == rhs.idEnterprise) || ((this.idEnterprise != null)
            && this.idEnterprise.equals(rhs.idEnterprise))))
            && ((this.pinned == rhs.pinned) || ((this.pinned != null) && this.pinned.equals(rhs.pinned))
            && ((this.url == rhs.url) || ((this.url != null) && this.url.equals(rhs.url))))
            && ((this.shortUrl == rhs.shortUrl) || ((this.shortUrl != null) && this.shortUrl.equals(rhs.shortUrl)))));
    }

}
